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

    private static int timerVar = 10;
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
                createPattern(timerVar);
                if (timerVar != 15) {
                    timerVar++;
                } else {
                    timerVar = 10;
                }
            }
        }, 0, 7000);

*/

        createPattern(9);
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
        timerVar = 10;
    }

    private void createPattern(int pattern) {
        switch (pattern) {
            // Jonas ↓
            case 1:
                createCoin(130, 0);
                createCoin(130, 30);
                createCoin(130, 60);
                createCoin(80, 200);
                createCoin(80, 400);
                createCoin(50, 600);
                createCoin(140, 720);
                createCoin(130, 800);
                createCoin(150, 1125);

                createSteadyObstacle(1, 0);
                createSteadyObstacle(1, 30);
                createSteadyObstacle(1, 60);
                createSteadyObstacle(1, 240);
                createSteadyObstacle(1, 800);
                createSteadyObstacle(1, 740);
                createSteadyObstacle(1, 1000);
                createSteadyObstacle(1, 1050);
                createSteadyObstacle(1, 1250);

                // createEnemy(1, 1, 300);
                createEnemy(2, 1, 550);
                createEnemy(3, 1, (int) (1280 * 2.5));
                createEnemy(2, 1, (int) (1280 * 1.9));

                createSteadyObstacle(1, 1280);
                break;
            case 2:
                createCoin(0, 20);
                createCoin(30, 60);
                createCoin(60, 200);
                createCoin(130, 350);
                createCoin(120, 400);
                createCoin(150, 500);
                createCoin(20, 1250);
                createCoin(40, 700);
                createCoin(150, 740);

                createSteadyObstacle(1, 110);
                createSteadyObstacle(1, 150);
                createSteadyObstacle(1, 350);
                createSteadyObstacle(1, 550);
                createSteadyObstacle(1, 740);
                createSteadyObstacle(1, 1100);

                createEnemy(2, 1, 1280);
                createEnemy(3, 1, (1280 * 4));
                createEnemy(2, 1, (int) (1280 * 1.9));
                break;
            case 3:
                createEnemy(1, 1, 200);
                createEnemy(2, 1, (int) (1280 * 2));
                createEnemy(2, 1, (int) (1280 * 4- 1000)/3);
                createEnemy(1, 1, 500);
                createEnemy(3, 1, (int) (1280 * 3+1000));
                createEnemy(1, 1, 1000);
                createEnemy(3, 1,  (1280 * 4)+800);

                createCoin(0, 15);
                createCoin(30, 60);
                createCoin(140, 370);
                createCoin(110, 420);
                createCoin(140, 500);
                createCoin(30, 1150);
                createCoin(50, 710);
                createCoin(140, 740);
                break;
            case 4:
                createCoin(180, 0);
                createCoin(150, 40);
                createCoin(60, 220);
                createCoin(130, 350);
                createCoin(120, 400);
                createCoin(150, 500);
                createCoin(20, 1250);
                createCoin(40, 700);
                createCoin(150, 740);

                createSteadyObstacle(1, 100);
                createSteadyObstacle(1, 120);
                createSteadyObstacle(1, 140);
                createSteadyObstacle(1, 160);
                createSteadyObstacle(1, 740);
                createSteadyObstacle(1, 1100);
                createSteadyObstacle(1, 500);

                createEnemy(3, 1, 1280+300);
                createEnemy(3, 1, (1280 * 4));
                createEnemy(2, 1, (int) (1280 * 1.9));
                createEnemy(3, 1, (1280 * 2)+800);

            /*
                // just marking the area haha
                sceneryController.initGameElementUI(new SteadyObstacle(new Point(w + 0, 50 ),1));
                sceneryController.initGameElementUI(new SteadyObstacle(new Point(w + 320, 50 ),1));
                sceneryController.initGameElementUI(new SteadyObstacle(new Point(w + 640, 50 ),1));
                sceneryController.initGameElementUI(new SteadyObstacle(new Point(w + 960, 50 ),1));
                sceneryController.initGameElementUI(new SteadyObstacle(new Point(w + 1280, 50 ),1));
            */

                break;
            // Jessica ↓
            case 5:
                createCoin(250, 60);
                createCoin(20,350);
                createCoin(40,400);
                createCoin(160,570);
                createCoin(10,820);
                createCoin(40,1000);
                createCoin(160,550);

                createEnemy(2,1,500);
                createEnemy(2,1,800);
                createEnemy(3,1,1200);
                createEnemy(2,1,1280*2);
                createEnemy(3,1,5260);

                createSteadyObstacle(1,300);
                createSteadyObstacle(1,520);
                createSteadyObstacle(1,540);
                createSteadyObstacle(1,540+320);
                createSteadyObstacle(1,1200);
                createSteadyObstacle(1,1220);
                break;
            case 6:
                createCoin(110,550);
                createCoin(160,600);
                createCoin(180,650);
                createCoin(160,700);
                createCoin(110,750);

                createSteadyObstacle(1,100);
                createSteadyObstacle(1,120);
                createSteadyObstacle(1,300);
                createSteadyObstacle(1,320);
                createSteadyObstacle(1,340);
                createSteadyObstacle(1, 900);
                createSteadyObstacle(1,920);
                createSteadyObstacle(1,940);
                createSteadyObstacle(1,1120);
                createSteadyObstacle(1,1140);

                createEnemy(1,1,620);
                break;
            case 7:
                createCoin(20,100);
                createCoin(80, 320);
                createCoin(140,560);
                createCoin(200,820);

                createSteadyObstacle(1,0);
                createSteadyObstacle(1,200);
                createSteadyObstacle(1,220);
                createSteadyObstacle(1, 420);
                createSteadyObstacle(1,440);
                createSteadyObstacle(1,460);
                createSteadyObstacle(1,660);
                createSteadyObstacle(1,680);
                createSteadyObstacle(1,700);
                createSteadyObstacle(1,720);
                createSteadyObstacle(1,920);
                createSteadyObstacle(1,940);
                createSteadyObstacle(1,960);
                createSteadyObstacle(1,980);
                createSteadyObstacle(1,1000);
                break;
            case 8:
                createCoin(10, 100);
                createCoin(80,70);
                createCoin(150,950);
                createCoin(200,1000);

                createSteadyObstacle(1,500);
                createSteadyObstacle(1,560);
                createSteadyObstacle(1,800);
                createSteadyObstacle(1,1000);
                createSteadyObstacle(1,1040);
                createSteadyObstacle(1,1080);

                createEnemy(2,1,900);
                createEnemy(3,1,1900);
                createEnemy(2,1,1900);
                createEnemy(3,1,2500);
                break;
            case 9:
                createCoin(150,30);
                createCoin(50,470);
                createCoin(10,750);
                createCoin(280,1200);

                createSteadyObstacle(1,0);
                createSteadyObstacle(1,20);
                createSteadyObstacle(1,40);
                createSteadyObstacle(1,500);
                createSteadyObstacle(1,530);
                createSteadyObstacle(1,800);
                createSteadyObstacle(1,850);

                createEnemy(2,1,1300);
                createEnemy(2,1,2000);
                createEnemy(2,1,3000);
                createEnemy(3,1, 2500);
                break;
            // Alex ↓
            case 10:

                createSteadyObstacle(1, 280);
                createSteadyObstacle(1, 500);
                createSteadyObstacle(1, 720);
                createSteadyObstacle(1, 980);

                createCoin(10, 0);
                createCoin(100, 200);
                createCoin(200, 500);
                createCoin(80, 800);
                createCoin(50, 1100);
                createCoin(100, 1250);

                createEnemy(2, 1, 1000);
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
