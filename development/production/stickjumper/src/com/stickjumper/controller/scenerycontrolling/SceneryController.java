package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.PanelFrameManager;
import com.stickjumper.data.GameElement;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.SoundManager;

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
    private static int jumpVar = Settings.JUMP_HEIGHT;
    public static int keysPressed = 0;
    private static int newDelay = 50;
    // init timer:
    Timer foregroundTimer, jumpTimer;
    GameElementRender gameCharacterElement;
    private GamePanelView gamePanelView;
    private PanelFrameManager panelFrameManager;
    private Controller controller;
    private ArrayList<GameElementRender> gameElementRenders = new ArrayList<>();
    private boolean gameCharacterAlreadyAdded;
    private int timerSpeed = Settings.foregroundSpeed;
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
        // yPosGameCharacter = gamePanelView.getHeight() - Settings.seaLevel - GameCharacter.dimens.getHeight();
        yPosGameCharacter = gameCharacterElement.getY();
    }

    public void initCertainGameObject(GameElement object) {
        GameElementRender elementRender = new GameElementRender(object);
        gamePanelView.addObject(elementRender);
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
        unfreeze();
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
                    // controller.setScore(controller.getScore() + currentCoinValue);
                }
                if (gameOver) {
                    freeze();
                    SoundManager.playSound(SoundManager.inputStreamGameOverSound);
                }

            }
        }, 0, timerSpeed);
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
        // gameElementRenders.forEach((e) -> gamePanelView.remove(e));
        for (Component comp : gamePanelView.getComponents()) {
            if (comp instanceof GameElementRender) gamePanelView.remove(comp);
        }
        gameElementRenders.clear();
        gamePanelView.remove(gameCharacterElement);
        gameCharacterElement = null;
        gameCharacterAlreadyAdded = false;
        controller.updateHighScore();
    }

    public GamePanelView getGamePanelView() {
        return gamePanelView;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> {
                if (keysPressed == 0) {
                    keysPressed++;
                    jump();
                } else {
                    if (keysPressed < 5) {
                        newDelay += 100;
                    } else {

                    }
                }
                // controller.getMainFrameView().keysEnabledInGame = false;

            }
        }
    }

    private void jump() {
        if (!gameOver) jumpUp();
    }

    public void jumpUp() {
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
                    gameCharacterElement.decrementY(jumpVar);
                    if (jumpVar < Settings.JUMP_HEIGHT) {
                        jumpVar++;
                    } else if (jumpVar == Settings.JUMP_HEIGHT) {
                        jumpTimer.cancel();
                        // controller.getMainFrameView().keysEnabledInGame = true;
                        jumpVar = Settings.JUMP_HEIGHT;
                        newDelay = 50;
                        keysPressed = 0;
                    }
                }
            }
        }, newDelay, Settings.JUMP_PERIOD);
    }

        /*
        public void initCertainObject(String objectType, int height, int speed, int skinOrCoinValue){
        // the input parameter height is the height above the "sea level" in game
        int h = gamePanelView.getHeight()-Settings.seaLevel;
        int w = gamePanelView.getWidth();

        switch (objectType) {
            case "Coin":
                GameElementRender coinElement = new GameElementRender(new Coin(new Point(w, (h - Enemy.getStandardDimens().getHeight()- height)), 1));
                gamePanelView.addObject(coinElement);
                addGameElementRender(coinElement);
                break;

            case "SteadyObstacle":
                GameElementRender steadyObstacleElement = new GameElementRender(new SteadyObstacle(new Point(w , (h - SteadyObstacle.getStandardDimens().getHeight())), skinOrCoinValue));
                gamePanelView.addObject(steadyObstacleElement);
                addGameElementRender(steadyObstacleElement);
                break;

            case "Enemy":
                GameElementRender enemyElement = new GameElementRender(new Enemy(new Point(w, (h - Enemy.getStandardDimens().getHeight())- height), speed, skinOrCoinValue));
                gamePanelView.addObject(enemyElement);
                addGameElementRender(enemyElement);
                break;
        }
    }
     */
}
