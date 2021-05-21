package com.stickjumper.controller;

import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.data.gameelements.obstacles.Enemy;
import com.stickjumper.data.gameelements.obstacles.SteadyObstacle;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.Settings;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SceneryController {

    private GamePanelView gamePanelView;
    private PanelFrameManager panelFrameManager;
    private Controller controller;

    private ArrayList<GameElementRender> gameElementRenders = new ArrayList<>();

    private boolean gameStarted = false;


    public SceneryController(GamePanelView gamePanelView, PanelFrameManager panelFrameManager, Controller controller) {
        this.gamePanelView = gamePanelView;
        this.panelFrameManager = panelFrameManager;
        this.controller = controller;
        move();
    }

    public void initSomeObjects() {
        GameElementRender coinElement = new GameElementRender(new Coin(new Point((Settings.SCREEN_WIDTH - Coin.getStandardDimens().getWidth()) / 2, 200)));
        addGameElementRender(coinElement);

        int h = gamePanelView.getHeight() - 100;
        int w = gamePanelView.getWidth();
        Point position = new Point((w - GameCharacter.width) / 4, h - GameCharacter.height);
        GameCharacter character = (controller.getCurrentPlayer() == null) ? new GameCharacter(position, 0) : new GameCharacter(controller.getCurrentPlayer(), position);
        GameElementRender playerFigure = new GameElementRender(character);
        addGameElementRender(playerFigure);

        GameElementRender enemy = new GameElementRender(new Enemy(new Point((w - Enemy.getStandardDimens().getWidth()) / 2, h - Enemy.getStandardDimens().getHeight()), 1));
        gamePanelView.addObject(enemy);
        addGameElementRender(enemy);

        GameElementRender obstacle = new GameElementRender(new SteadyObstacle(new Point((w - SteadyObstacle.getStandardDimens().getWidth()) / 2 + (w - SteadyObstacle.getStandardDimens().getWidth()) / 4, h - SteadyObstacle.getStandardDimens().getHeight())));
        gamePanelView.addObject(obstacle);
        addGameElementRender(obstacle);
    }

    public void addGameElementRender(GameElementRender render) {
        gameElementRenders.add(render);
        gamePanelView.addObject(render);
    }

    private void move(){
       Timer foregroundTimer = new Timer();
       int timerSpeed = 20;
       int generalSpeed = 1;

       foregroundTimer.scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               if(gameStarted) {
                   gameElementRenders.forEach((e) -> {
                       e.decrementX(e.getSpeed() * generalSpeed);

                       // System.out.println("yes");
                   });
               }

           }
       }, 0, timerSpeed);



    }

    public void startGame(){
        gameStarted = true;
        System.out.println("start");
    }

    public void stopGame(){
        gameStarted = false;
        System.out.println("stop");
    }

    public void moveLeft() {
        for (GameElementRender render : gameElementRenders) render.decrementX(50);
    }

    public void moveRight() {
        for (GameElementRender render : gameElementRenders) render.decrementX(-50);
    }

}
