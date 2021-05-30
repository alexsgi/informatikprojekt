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
    private final Random random = new Random();
    Timer timer;
    private SceneryController sceneryController;
    private int h;
    private int w;

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
        }, 0, 20000);
        */
        //createPattern(15);
    }

    public void recreate() {
        randomGenerate();
        // dont know if this is really needed
        // overwrites all the objects in the array lists, so that the game is different from the last one
    }

    private void createCoinRandomHeight(int xShift) {
        int min = 100, max = Settings.SCREEN_HEIGHT - Settings.seaLevel - Coin.getStandardDimens().getHeight();
        int r = random.nextInt((max - min) + 1) + min;
        sceneryController.initGameElementUI(new Coin(new Point(w + xShift, r)));
    }

    private void createCoin(int height, int xShift) {
        sceneryController.initGameElementUI(new Coin(new Point(w + xShift, (h - Coin.getStandardDimens().getHeight() - height))));
    }

    private void createEnemy(int speed, int skinType, int xShift) {
        sceneryController.initGameElementUI(new Enemy(new Point(w + xShift, (h - Enemy.getStandardDimens().getHeight())), speed, skinType));
    }

    public void createSteadyObstacle(int skinType, int xShift) {
        sceneryController.initGameElementUI(new SteadyObstacle(new Point(w + xShift, (h - SteadyObstacle.getStandardDimens().getHeight())), skinType));
    }

    public void stop() {
        if (timer != null) timer.cancel();
    }

    private void createPattern(int pattern) {
        switch (pattern) {
            case 1:
                createCoin(10, 0);
                createEnemy(3, 1, 200);
                createSteadyObstacle(1, 300);
                createSteadyObstacle(1, 350);
                createEnemy(2, 1, 200);
                break;
            case 2:
                createCoin(10, 0);
                break;
            case 3:
                createCoin(10, 0);
                break;
            case 4:
                createCoin(10, 0);
                break;
            case 5:
                createCoin(10, 0);
                break;
            case 6:
                createCoin(10, 0);
                break;
            case 7:
                createCoin(10, 0);
                break;
            case 8:
                createCoin(10, 0);
                break;
            case 9:
                createCoin(10, 0);
                break;
            // Alex ↓
            case 10:

                createSteadyObstacle(1, 280);
                createSteadyObstacle(1, 500);
                createSteadyObstacle(1, 700);
                createSteadyObstacle(1, 950);

                createCoin(10, 0);
                createCoin(100, 200);
                createCoin(200, 500);
                createCoin(80, 800);
                createCoin(50, 1100);
                createCoin(100, 1250);

                createEnemy(1, 1, 1280);
                createEnemy(3, 1, 1280);
                createEnemy(3, 1, 200);

                break;
            case 11:

                createSteadyObstacle(1, 300);
                createSteadyObstacle(1, 550);
                createSteadyObstacle(1, 580);
                createSteadyObstacle(1, 950);

                createEnemy(2, 1, (int) (1280 * 2.5));
                createEnemy(2, 1, 200);
                createEnemy(3, 1, 100);

                createCoin(120, 0);
                createCoin(50, 350);
                createCoin(200, 560);
                createCoin(10, 700);
                createCoin(50, 1100);
                createCoin(200, 1250);

                break;
            case 12:

                createSteadyObstacle(1, 100);
                createSteadyObstacle(1, 300);
                createSteadyObstacle(1, 600);
                createSteadyObstacle(1, 950);

                createEnemy(2, 1, (int) (1280 * 2.5));
                createEnemy(2, 1, 200);
                createEnemy(3, 1, 100);
                createEnemy(3, 1, 1280);

                createCoin(120, 0);
                createCoin(50, 350);
                createCoin(200, 560);
                createCoin(200, 570);
                createCoin(50, 1100);
                createCoin(200, 1250);

                break;
            case 13:

                createSteadyObstacle(1, 0);
                createSteadyObstacle(1, 250);
                createSteadyObstacle(1, 600);
                createSteadyObstacle(1, 800);
                createSteadyObstacle(1, 1280);

                createEnemy(2, 1, (int) (1280 * 2.4));
                createEnemy(2, 1, 300);
                createEnemy(3, 1, 200);
                createEnemy(3, 1, 900);

                createCoin(120, 10);
                createCoin(100, 200);
                createCoin(200, 312);
                createCoin(200, 800);
                createCoin(50, 1100);
                createCoin(200, 1250);

                break;
            case 14:

                createSteadyObstacle(1, 100);
                createSteadyObstacle(1, 300);
                createSteadyObstacle(1, 600);
                createSteadyObstacle(1, 950);

                createEnemy(2, 1, 200);
                createEnemy(3, 1, 100);
                createEnemy(2, 1, 2000);
                createEnemy(2, 1, (int) (1280 * 2.5));

                createCoin(0, 0);
                createCoin(50, 350);
                createCoin(100, 560);
                createCoin(150, 800);
                createCoin(200, 1000);
                createCoin(250, 1250);

                break;
            case 15:

                createSteadyObstacle(1, 0);
                createSteadyObstacle(1, 250);
                createSteadyObstacle(1, 500);
                createSteadyObstacle(1, 750);
                createSteadyObstacle(1, 1050);

                createEnemy(3, 1, 600);
                createEnemy(3, 1, 2000);
                createEnemy(3, 1, (int) (1280 * 2.5));

                createCoin(250, 10);
                createCoin(200, 350);
                createCoin(150, 560);
                createCoin(100, 800);
                createCoin(50, 1000);
                createCoin(0, 1250);

                break;

            default:
                createPattern(1);
        }
    }

}
