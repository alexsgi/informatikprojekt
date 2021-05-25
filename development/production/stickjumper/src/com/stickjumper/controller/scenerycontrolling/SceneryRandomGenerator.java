package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.obstacles.Enemy;
import com.stickjumper.data.gameelements.obstacles.SteadyObstacle;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.utils.Settings;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SceneryRandomGenerator {

    private static int coinHeight;
    Timer timer;
    private SceneryController sceneryController;
    private int h;
    private int w;
    private final int startHeight = 100;
    private Random random = new Random();

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
        coinHeight = startHeight;
        sceneryController.initGameCharacter(1);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                createCoin(coinHeight);
                createEnemy(2, 1);
                createSteadyObstacle(1);
                if (coinHeight + Coin.getStandardDimens().getHeight() + Settings.seaLevel * 2 < Settings.SCREEN_HEIGHT) {
                    coinHeight += 50;
                } else {
                    coinHeight = startHeight;
                }
            }
        }, 0, 1000);
        // the real random component
    }

    public void recreate() {
        randomGenerate();
        // dont know if this is really needed
        // overwrites all the objects in the array lists, so that the game is different from the last one
    }

    private void createCoin(int height) {
        int min = 100, max = Settings.SCREEN_HEIGHT - Settings.seaLevel - Coin.getStandardDimens().getHeight();
        int r = random.nextInt((max - min) + 1) + min;
        // sceneryController.initCertainGameObject(new Coin(new Point(w, (h - Coin.getStandardDimens().getHeight() - height))));
        sceneryController.initCertainGameObject(new Coin(new Point(w, r)));
    }

    private void createEnemy(int speed, int skinType) {
        sceneryController.initCertainGameObject(new Enemy(new Point(w, (h - Enemy.getStandardDimens().getHeight())), speed, skinType));
    }

    public void createSteadyObstacle(int skinType) {
        sceneryController.initCertainGameObject(new SteadyObstacle(new Point(w, (h - SteadyObstacle.getStandardDimens().getHeight())), skinType));
    }

    public void stop() {
        timer.cancel();
    }

}
