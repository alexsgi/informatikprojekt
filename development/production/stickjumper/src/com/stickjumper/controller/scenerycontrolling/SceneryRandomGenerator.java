package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.obstacles.Enemy;
import com.stickjumper.data.gameelements.obstacles.SteadyObstacle;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.utils.Settings;

import java.awt.*;
import java.util.Random;
import java.util.Timer;

public class SceneryRandomGenerator {

    private final int startHeight = 100;
    Timer timer;
    private SceneryController sceneryController;
    private int h;
    private int w;
    private final Random random = new Random();

    public SceneryRandomGenerator() {
        // TODO: creating all the objects "enemy, steadyObstacle, coin" in here and passing them as input parameter in the method "initCertainObject"
        // therefore, you have to adapt the method in SceneryController for passing an object of the class GameElement as an input parameter
    }

    public void setSceneryController(SceneryController sceneryController) {
        this.sceneryController = sceneryController;
        GamePanelView gamePanelView = sceneryController.getGamePanelView();
        h = gamePanelView.getHeight() - Settings.seaLevel;
        w = gamePanelView.getWidth();
    }

    public void randomGenerate() {
        sceneryController.initGameCharacter(1);
        /*
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // createCoin(0);
                // createEnemy(2, 1);
                createSteadyObstacle(1);
            }
        }, 0, 1000);
        */
        createPattern(1);
    }

    public void recreate() {
        randomGenerate();
        // dont know if this is really needed
        // overwrites all the objects in the array lists, so that the game is different from the last one
    }

    private void createCoin(int xDelay) {
        int min = 100, max = Settings.SCREEN_HEIGHT - Settings.seaLevel - Coin.getStandardDimens().getHeight();
        int r = random.nextInt((max - min) + 1) + min;
        // sceneryController.initCertainGameObject(new Coin(new Point(w, (h - Coin.getStandardDimens().getHeight() - height))));
        sceneryController.initCertainGameObject(new Coin(new Point(w + xDelay, r)));
    }

    private void createEnemy(int speed, int skinType, int xDelay) {
        sceneryController.initCertainGameObject(new Enemy(new Point(w + xDelay, (h - Enemy.getStandardDimens().getHeight())), speed, skinType));
    }

    public void createSteadyObstacle(int skinType, int xDelay) {
        sceneryController.initCertainGameObject(new SteadyObstacle(new Point(w + xDelay, (h - SteadyObstacle.getStandardDimens().getHeight())), skinType));
    }

    public void stop() {
        timer.cancel();
    }

    private void createPattern(int pattern) {
        switch (pattern) {
            case 1:
                createCoin(0);
                break;

            case 2:
                createCoin(0);
                break;

            case 3:
                createCoin(0);
                break;

            case 4:
                createCoin(0);
                break;

            case 5:
                createCoin(0);
                break;

            case 6:
                createCoin(0);
                break;

            case 7:
                createCoin(0);
                break;

            case 8:
                createCoin(0);
                break;

            case 9:
                createCoin(0);
                break;

            case 10:
                createCoin(0);
                break;

            case 11:
                createCoin(0);
                break;

            case 12:
                createCoin(0);
                break;

        }
    }

}
