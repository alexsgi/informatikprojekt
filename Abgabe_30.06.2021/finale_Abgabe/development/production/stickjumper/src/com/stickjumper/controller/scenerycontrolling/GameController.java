package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.PanelFrameManager;
import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;
import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.data.gameelements.Obstacle;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.SoundManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameController {

    public static boolean spacePressedOnce = false, spacePressedTwice = false;
    private static int yPosGameCharacter, jumpVar = Settings.JUMP_HEIGHT, newPeriod = Settings.JUMP_PERIOD;
    private static boolean gameOver = false;
    // UI & Controller
    private final GamePanelView gamePanelView;
    private final PanelFrameManager panelFrameManager;
    private final Controller controller;
    // Game elements
    private final ArrayList<GameElementRender> gameElementRenders = new ArrayList<>();
    // Game event listener
    private final GameEventListener gameEventListener;
    private boolean gameCharacterAlreadyAdded;
    private GameElementRender gameCharacterElement;
    // Timer
    private Timer foregroundTimer, jumpTimer;

    public GameController(GamePanelView gamePanelView, PanelFrameManager panelFrameManager, Controller controller) {
        this.gamePanelView = gamePanelView;
        this.panelFrameManager = panelFrameManager;
        this.controller = controller;

        gameEventListener = gameElement -> {
            if (gameElement instanceof Obstacle) {
                freeze(false);
                SoundManager.playSound(SoundManager.inputStreamGameOverSound);
                gameOver = true;
            } else if (gameElement instanceof Coin) {
                SoundManager.playSound(SoundManager.inputStreamCoinSound);
                if (controller.updateHighScoreLabel(((Coin) gameElement).getCoinValue())) {
                    GameRandomGenerator.highScoreReached();
                }
            }
        };
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static int getYPosGameCharacter() {
        return yPosGameCharacter;
    }

    public Controller getController() {
        return controller;
    }

    public void initGameCharacter(Player player) {
        if (!gameCharacterAlreadyAdded) {
            GameCharacter character = new GameCharacter(player);
            character.addEventListener(gameEventListener);
            gameCharacterElement = new GameElementRender(character);
            gamePanelView.addObject(gameCharacterElement);
            gameCharacterAlreadyAdded = true;
        }
        yPosGameCharacter = gameCharacterElement.getY();
    }

    public void initGameElement(GameElement object) {
        object.addEventListener(gameEventListener);
        GameElementRender elementRender = new GameElementRender(object);
        gameElementRenders.add(elementRender);
        gamePanelView.addObject(elementRender);
    }

    public void removeGameElementRender(int arrayListNumber) {
        GameElementRender current = gameElementRenders.get(arrayListNumber);
        gameElementRenders.remove(arrayListNumber);
        gamePanelView.remove(current);
    }

    public void startGame() {
        GameRandomGenerator.resetRandomGenerator();
        controller.resetGameScore();
        unfreeze();
        panelFrameManager.startMovingBackground();
        Settings.STEADY_OBSTACLES_LETHAL = true;
        foregroundTimer = new Timer();
        foregroundTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < gameElementRenders.size(); i++) {
                    GameElementRender current = gameElementRenders.get(i);
                    if (!current.getGameElement().isVisible()) {
                        removeGameElementRender(i);
                        return;
                    }
                    current.decrementX(current.getSpeed());
                    if (current.getLocation().getX() + current.getWidth() <= 0) removeGameElementRender(i);
                }
                if (gameCharacterAlreadyAdded) yPosGameCharacter = gameCharacterElement.getY();
            }
        }, 0, Settings.FOREGROUND_SPEED);

        spacePressedOnce = false;
        spacePressedTwice = false;
    }

    public void freeze(boolean gameWon) {
        if (foregroundTimer != null) foregroundTimer.cancel();
        if (jumpTimer != null) jumpTimer.cancel();
        panelFrameManager.stopMovingBackground();
        if (gameWon) {
            gamePanelView.showGameWin();
        } else {
            gamePanelView.showGameOver();
        }
        gamePanelView.lblGameOver.setVisible(true);
    }

    public void unfreeze() {
        gameOver = false;
        gamePanelView.lblGameOver.setVisible(false);
    }

    public void stopGame(boolean won) {
        freeze(won);
        for (Component comp : gamePanelView.getComponents()) {
            if (comp instanceof GameElementRender) gamePanelView.remove(comp);
        }
        gameElementRenders.clear();
        if (gameCharacterElement != null) gamePanelView.remove(gameCharacterElement);
        gameCharacterElement = null;
        gameCharacterAlreadyAdded = false;
        controller.storeLocalHighscore();
    }

    public GamePanelView getGamePanelView() {
        return gamePanelView;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (controller.getMainFrameView().keysEnabledInGame && !isGameOver()) {
                if (!spacePressedOnce) {
                    jump();
                    spacePressedOnce = true;
                } else {
                    newPeriod = Settings.JUMP_PERIOD_FOR_HOLDING_SPACE;
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (controller.getMainFrameView().keysEnabledInGame && !isGameOver()) newPeriod = Settings.JUMP_PERIOD;
        }
    }

    public void jump() {
        jumpVar = Settings.JUMP_HEIGHT;
        jumpTimer = new Timer();
        jumpTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gameCharacterElement != null) {
                    gameCharacterElement.incrementY(jumpVar);
                    if (jumpVar > 0) {
                        jumpVar--;
                    } else if (jumpVar == 0) {
                        jumpTimer.cancel();
                        jumpBackDown();
                    }
                }
            }
        }, 0, Settings.JUMP_PERIOD);
    }

    public void jumpBackDown() {
        jumpVar = 0;
        jumpTimer = new Timer();
        jumpTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gameCharacterElement != null) {
                    if (jumpVar < Settings.JUMP_TOLERANCE_FOR_DELAY) {
                        gameCharacterElement.decrementY(jumpVar);
                        jumpVar++;
                    } else if (jumpVar == Settings.JUMP_TOLERANCE_FOR_DELAY) {
                        jumpTimer.cancel();
                        jumpBackDownFurther();
                    }
                }
            }
        }, 50, Settings.JUMP_PERIOD);
    }

    public void jumpBackDownFurther() {
        jumpVar = Settings.JUMP_TOLERANCE_FOR_DELAY;
        jumpTimer = new Timer();
        jumpTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gameCharacterElement != null) {
                    if (jumpVar < Settings.JUMP_SECOND_TOLERANCE_FOR_DELAY) {
                        gameCharacterElement.decrementY(jumpVar);
                        jumpVar++;
                    } else if (jumpVar == Settings.JUMP_SECOND_TOLERANCE_FOR_DELAY) {
                        jumpTimer.cancel();
                        jumpBackDownFurtherFurther();
                    }
                }
            }
        }, 0, newPeriod);
    }

    public void jumpBackDownFurtherFurther() {
        jumpVar = Settings.JUMP_SECOND_TOLERANCE_FOR_DELAY;
        jumpTimer = new Timer();
        jumpTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (gameCharacterElement != null) {
                    gameCharacterElement.decrementY(jumpVar);
                    if (jumpVar < Settings.JUMP_HEIGHT) {
                        jumpVar++;
                    } else if (jumpVar == Settings.JUMP_HEIGHT) {
                        jumpTimer.cancel();
                        spacePressedOnce = false;
                        spacePressedTwice = false;
                    }
                }
            }
        }, 0, newPeriod);
    }
}
