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

public class SceneryController {

    private GamePanelView gamePanelView;
    private PanelFrameManager panelFrameManager;
    private Controller controller;

    private ArrayList<GameElementRender> gameElementRenders = new ArrayList<>();

    public SceneryController(GamePanelView gamePanelView, PanelFrameManager panelFrameManager, Controller controller) {
        this.gamePanelView = gamePanelView;
        this.panelFrameManager = panelFrameManager;
        this.controller = controller;
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

        GameElementRender enemy = new GameElementRender(new Enemy(new Point((w - Enemy.getStandardDimens().getWidth()) / 2, h - Enemy.getStandardDimens().getHeight()), 0));
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

    public void moveLeft() {
        for (GameElementRender render : gameElementRenders) render.decrementX(50);
    }

    public void moveRight() {
        for (GameElementRender render : gameElementRenders) render.decrementX(-50);
    }

}
