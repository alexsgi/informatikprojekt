package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.obstacle.Enemy;
import com.stickjumper.data.gameelements.obstacle.SteadyObstacle;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.utils.Settings;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class GameRandomGenerator {

    private static boolean highScoreReachedNow = false, gameEndReached = false;
    private Timer timer;
    private GameController sceneryController;
    private int h, w;

    public static void highScoreReached() {
        highScoreReachedNow = true;
    }

    public static void resetRandomGenerator() {
        highScoreReachedNow = false;
        gameEndReached = false;
    }

    public void setSceneryController(GameController sceneryController) {
        this.sceneryController = sceneryController;
        GamePanelView gamePanelView = sceneryController.getGamePanelView();
        h = gamePanelView.getHeight() - Settings.SEA_LEVEL;
        w = gamePanelView.getWidth();
    }

    public void randomGenerate() {
        sceneryController.initGameCharacter(1);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // min = 1; max = 15 (+1 to be included)
                if (!highScoreReachedNow) {
                    int random = ThreadLocalRandom.current().nextInt(1, 16);
                    createPattern(random);
                } else if (!gameEndReached) {
                    createPattern(16);
                    gameEndReached = true;
                } else {
                    timer.cancel();
                    sceneryController.stopGame(true);
                }
            }
        }, 0, 7000);
    }

    private void createCoin(int height, int xShift) {
        Coin coin = Coin.createCoin(new Point(w + xShift, (h - Coin.getStandardDimens().getHeight() - height)));
        sceneryController.initGameElement(coin);
    }

    private void createDefaultCoin(int height, int xShift) {
        Coin coin = new Coin(new Point(w + xShift, (h - Coin.getStandardDimens().getHeight() - height)));
        sceneryController.initGameElement(coin);
    }

    private void createEnemy(int speed, int xShift) {
        sceneryController.initGameElement(new Enemy(new Point(w + xShift, (h - Enemy.getStandardDimens().getHeight())), speed));
    }

    public void createSteadyObstacle(int xShift) {
        sceneryController.initGameElement(new SteadyObstacle(new Point(w + xShift, (h - SteadyObstacle.getStandardDimens().getHeight()))));
    }

    public void stop() {
        if (timer != null) timer.cancel();
    }

    private void createPattern(int pattern) {
        switch (pattern) {
            // Jonas ↓
            case 1 -> {
                createCoin(130, 0);
                createCoin(130, 30);
                createCoin(130, 60);
                createCoin(80, 200);
                createCoin(80, 400);
                createCoin(50, 600);
                createCoin(140, 720);
                createCoin(130, 800);
                createCoin(150, 1125);
                createSteadyObstacle(0);
                createSteadyObstacle(30);
                createSteadyObstacle(60);
                createSteadyObstacle(240);
                createSteadyObstacle(800);
                createSteadyObstacle(740);
                createSteadyObstacle(1000);
                createSteadyObstacle(1050);
                createSteadyObstacle(1250);

                // createEnemy(1, 1, 300);
                createEnemy(2, 550);
                createEnemy(3, (int) (1280 * 2.5));
                createEnemy(2, (int) (1280 * 1.9));
                createSteadyObstacle(1280);
            }
            case 2 -> {
                createCoin(0, 20);
                createCoin(30, 60);
                createCoin(60, 200);
                createCoin(130, 350);
                createCoin(120, 400);
                createCoin(150, 500);
                createCoin(20, 1250);
                createCoin(40, 700);
                createCoin(150, 740);
                createSteadyObstacle(110);
                createSteadyObstacle(150);
                createSteadyObstacle(350);
                createSteadyObstacle(550);
                createSteadyObstacle(740);
                createSteadyObstacle(1100);
                createEnemy(2, 1280);
                createEnemy(3, (1280 * 4));
                createEnemy(2, (int) (1280 * 1.9));
            }
            case 3 -> {
                createEnemy(1, 200);
                createEnemy(2, 1280 * 2);
                createEnemy(2, (1280 * 4 - 1000) / 3);
                createEnemy(1, 500);
                createEnemy(3, 1280 * 3 + 1000);
                createEnemy(1, 1000);
                createEnemy(3, (1280 * 4) + 800);
                createCoin(0, 15);
                createCoin(30, 60);
                createCoin(140, 370);
                createCoin(110, 420);
                createCoin(140, 500);
                createCoin(30, 1150);
                createCoin(50, 710);
                createCoin(140, 740);
            }
            case 4 -> {
                createCoin(180, 0);
                createCoin(150, 40);
                createCoin(60, 220);
                createCoin(130, 350);
                createCoin(120, 400);
                createCoin(150, 500);
                createCoin(20, 1250);
                createCoin(40, 700);
                createCoin(150, 740);
                createSteadyObstacle(100);
                createSteadyObstacle(120);
                createSteadyObstacle(140);
                createSteadyObstacle(160);
                createSteadyObstacle(740);
                createSteadyObstacle(1100);
                createSteadyObstacle(500);
                createEnemy(3, 1280 + 300);
                createEnemy(3, (1280 * 4));
                createEnemy(2, (int) (1280 * 1.9));
                createEnemy(3, (1280 * 2) + 800);
            }
            // Jessica ↓
            case 5 -> {
                createCoin(250, 60);
                createCoin(20, 350);
                createCoin(40, 400);
                createCoin(160, 570);
                createCoin(10, 820);
                createCoin(40, 1000);
                createCoin(160, 550);
                createEnemy(2, 500);
                createEnemy(2, 800);
                createEnemy(3, 1200);
                createEnemy(2, 1280 * 2);
                createEnemy(3, 5260);
                createSteadyObstacle(300);
                createSteadyObstacle(520);
                createSteadyObstacle(540);
                createSteadyObstacle(540 + 320);
                createSteadyObstacle(1200);
                createSteadyObstacle(1220);
            }
            case 6 -> {
                createCoin(110, 550);
                createCoin(160, 600);
                createCoin(180, 650);
                createCoin(160, 700);
                createCoin(110, 750);
                createSteadyObstacle(100);
                createSteadyObstacle(120);
                createSteadyObstacle(300);
                createSteadyObstacle(320);
                createSteadyObstacle(340);
                createSteadyObstacle(900);
                createSteadyObstacle(920);
                createSteadyObstacle(940);
                createSteadyObstacle(1120);
                createSteadyObstacle(1140);
                createEnemy(1, 620);
            }
            case 7 -> {
                createCoin(20, 100);
                createCoin(80, 320);
                createCoin(140, 560);
                createCoin(200, 820);
                createSteadyObstacle(0);
                createSteadyObstacle(200);
                createSteadyObstacle(220);
                createSteadyObstacle(420);
                createSteadyObstacle(440);
                createSteadyObstacle(460);
                createSteadyObstacle(660);
                createSteadyObstacle(680);
                createSteadyObstacle(700);
                createSteadyObstacle(720);
                createSteadyObstacle(920);
                createSteadyObstacle(940);
                createSteadyObstacle(960);
                createSteadyObstacle(980);
                createSteadyObstacle(1000);
            }
            case 8 -> {
                createCoin(10, 100);
                createCoin(80, 70);
                createCoin(150, 950);
                createCoin(200, 1000);
                createSteadyObstacle(500);
                createSteadyObstacle(560);
                createSteadyObstacle(800);
                createSteadyObstacle(1000);
                createSteadyObstacle(1040);
                createSteadyObstacle(1080);
                createEnemy(2, 900);
                createEnemy(3, 1900);
                createEnemy(2, 1900);
                createEnemy(3, 2500);
            }
            case 9 -> {
                createCoin(150, 30);
                createCoin(50, 470);
                createCoin(10, 750);
                createCoin(280, 1200);
                createSteadyObstacle(0);
                createSteadyObstacle(20);
                createSteadyObstacle(40);
                createSteadyObstacle(500);
                createSteadyObstacle(530);
                createSteadyObstacle(800);
                createSteadyObstacle(850);
                createEnemy(2, 1300);
                createEnemy(2, 2000);
                createEnemy(2, 3000);
                createEnemy(3, 2500);
            }
            // Alex ↓
            case 10 -> {
                createSteadyObstacle(280);
                createSteadyObstacle(500);
                createSteadyObstacle(720);
                createSteadyObstacle(980);
                createCoin(10, 0);
                createCoin(100, 200);
                createCoin(200, 500);
                createCoin(80, 800);
                createCoin(50, 1100);
                createCoin(100, 1250);
                createEnemy(2, 1000);
                createEnemy(3, 1280);
                createEnemy(3, 200);
            }
            case 11 -> {
                createSteadyObstacle(300);
                createSteadyObstacle(550);
                createSteadyObstacle(580);
                createSteadyObstacle(950);
                createEnemy(2, (int) (1280 * 2.5));
                createEnemy(2, 200);
                createEnemy(3, 100);
                createCoin(120, 0);
                createCoin(50, 350);
                createCoin(200, 560);
                createCoin(10, 700);
                createCoin(50, 1100);
                createCoin(200, 1250);
            }
            case 12 -> {
                createSteadyObstacle(100);
                createSteadyObstacle(300);
                createSteadyObstacle(600);
                createSteadyObstacle(950);
                createEnemy(2, (int) (1280 * 2.5));
                createEnemy(2, 200);
                createEnemy(3, 100);
                createEnemy(3, 1280);
                createCoin(120, 0);
                createCoin(50, 350);
                createCoin(200, 560);
                createCoin(200, 570);
                createCoin(50, 1100);
                createCoin(200, 1250);
            }
            case 13 -> {
                createSteadyObstacle(0);
                createSteadyObstacle(250);
                createSteadyObstacle(600);
                createSteadyObstacle(800);
                createSteadyObstacle(1280);
                createEnemy(2, (int) (1280 * 2.4));
                createEnemy(2, 300);
                createEnemy(3, 200);
                createEnemy(3, 900);
                createCoin(120, 10);
                createCoin(100, 200);
                createCoin(200, 312);
                createCoin(200, 800);
                createCoin(50, 1100);
                createCoin(200, 1250);
            }
            case 14 -> {
                createSteadyObstacle(100);
                createSteadyObstacle(300);
                createSteadyObstacle(600);
                createSteadyObstacle(950);
                createEnemy(2, 200);
                createEnemy(3, 100);
                createEnemy(2, 2000);
                createEnemy(2, (int) (1280 * 2.5));
                createCoin(0, 0);
                createCoin(50, 350);
                createCoin(100, 560);
                createCoin(150, 800);
                createCoin(200, 1000);
                createCoin(250, 1250);
            }
            case 15 -> {
                createSteadyObstacle(0);
                createSteadyObstacle(250);
                createSteadyObstacle(500);
                createSteadyObstacle(750);
                createSteadyObstacle(1050);
                createEnemy(3, 600);
                createEnemy(3, 2000);
                createEnemy(3, (int) (1280 * 2.5));
                createCoin(250, 10);
                createCoin(200, 350);
                createCoin(150, 560);
                createCoin(100, 800);
                createCoin(50, 1000);
                createCoin(0, 1250);
            }
            case 16 -> {
                for (int i = 0; i < 600; i = i + 50) {
                    for (int j = 0; j < 1000; j = j + 50) {
                        createDefaultCoin(i, j);
                    }
                }
            }
            default -> createPattern(1);
        }
    }

}
