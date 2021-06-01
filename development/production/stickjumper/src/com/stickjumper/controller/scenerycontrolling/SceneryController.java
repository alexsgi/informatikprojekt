package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.PanelFrameManager;
import com.stickjumper.data.GameElement;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.SoundManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SceneryController {

    public static boolean gameOver = false;
    // this position is relative to the frame
    public static int yPosGameCharacter;
    // this variable will turn true for a millisecond, when a coin is hit in order to increment the high score
    public static boolean coinHit = false;
    public static int currentCoinValue = 0;
    public static boolean spacePressedOnce = false, spacePressedTwice = false;
    private static int jumpVar = Settings.JUMP_HEIGHT;
    private static int newDelay = 50;
    private static int newPeriod = Settings.JUMP_PERIOD;

    // init timer:
    Timer foregroundTimer, jumpTimer;
    GameElementRender gameCharacterElement;
    private GamePanelView gamePanelView;
    private PanelFrameManager panelFrameManager;
    private Controller controller;
    private ArrayList<GameElementRender> gameElementRenders = new ArrayList<>();
    private boolean gameCharacterAlreadyAdded;
    private int timerSpeed = Settings.FOREGROUND_SPEED;
    private int generalSpeed = 1;

    public SceneryController(GamePanelView gamePanelView, PanelFrameManager panelFrameManager, Controller controller) {
        this.gamePanelView = gamePanelView;
        this.panelFrameManager = panelFrameManager;
        this.controller = controller;
    }

    public void initGameCharacter(int skinType) {
        if (!gameCharacterAlreadyAdded) {
            gameCharacterElement = new GameElementRender(new GameCharacter(skinType));
            gamePanelView.addObject(gameCharacterElement);
            gameCharacterAlreadyAdded = true;
        }
        yPosGameCharacter = gameCharacterElement.getY();
    }

    public void initGameElementUI(GameElement object) {
        GameElementRender elementRender = new GameElementRender(object);
        addGameElementRender(elementRender);
    }

    public void addGameElementRender(GameElementRender render) {
        gameElementRenders.add(render);
        gamePanelView.addObject(render);
    }

    public void removeGameElementRender(int arrayListNumber) {
        GameElementRender current = gameElementRenders.get(arrayListNumber);
        gameElementRenders.remove(arrayListNumber);
        gamePanelView.remove(current);
    }

    public void startGame() {
        controller.resetGameScore();
        panelFrameManager.startMovingBackground();
        unfreeze();
        Settings.STEADY_OBSTACLES_LETHAL = true;
        foregroundTimer = new Timer();
        foregroundTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // IT'S WORKING - DON'T TOUCH IT
                for (int i = 0; i < gameElementRenders.size(); i++) {
                    GameElementRender current = gameElementRenders.get(i);
                    if (!current.getGameElement().isVisible()) {
                        removeGameElementRender(i);
                    }
                    current.decrementX(current.getSpeed() * generalSpeed);
                    if (current.getLocation().getX() + current.getWidth() <= 0) removeGameElementRender(i);
                }
                if (gameCharacterAlreadyAdded) yPosGameCharacter = gameCharacterElement.getY();
                if (coinHit) {
                    coinHit = false;
                    controller.updateHighScoreLabel(currentCoinValue);
                }
                if (gameOver) {
                    freeze();
                    SoundManager.playSound(SoundManager.inputStreamGameOverSound);
                }

            }
        }, 0, timerSpeed);

        spacePressedOnce = false;
        spacePressedTwice = false;
    }

    public void freeze() {
        if (foregroundTimer != null) foregroundTimer.cancel();
        if (jumpTimer != null) jumpTimer.cancel();
        controller.getPanelFrameManager().stopMovingBackground();
        gamePanelView.lblGameOver.setVisible(true);
    }

    public void unfreeze() {
        gameOver = false;
        gamePanelView.lblGameOver.setVisible(false);
    }

    public void stopGame() {
        freeze();
        for (Component comp : gamePanelView.getComponents()) {
            if (comp instanceof GameElementRender) gamePanelView.remove(comp);
        }
        gameElementRenders.clear();
        gamePanelView.remove(gameCharacterElement);
        gameCharacterElement = null;
        gameCharacterAlreadyAdded = false;
        controller.storeLocalHighscore();
    }

    public GamePanelView getGamePanelView() {
        return gamePanelView;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> {
                if (controller.getMainFrameView().keysEnabledInGame && !gameOver) {
                    if (!spacePressedOnce) {
                        jump();
                        spacePressedOnce = true;
                    } else {
                        newPeriod = Settings.JUMP_PERIOD_FOR_HOLDING_SPACE;
                    }
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> {
                if (controller.getMainFrameView().keysEnabledInGame && !gameOver) newPeriod = Settings.JUMP_PERIOD;
            }
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
