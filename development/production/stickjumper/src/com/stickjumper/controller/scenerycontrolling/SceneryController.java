package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.PanelFrameManager;
import com.stickjumper.data.GameElement;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.Settings;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SceneryController {

    private GamePanelView gamePanelView;
    private PanelFrameManager panelFrameManager;
    private Controller controller;
    private ArrayList<GameElementRender> gameElementRenders = new ArrayList<>();
    private boolean gameCharacterAlreadyAdded;

    // this position is relative to the frame
    public static int yPosGameCharacter;

    // init timer:
    Timer foregroundTimer;
    int timerSpeed = Settings.foregroundSpeed;
    int generalSpeed = 1;

    GameElementRender gameCharacterElement;

    public SceneryController(GamePanelView gamePanelView, PanelFrameManager panelFrameManager, Controller controller) {
        this.gamePanelView = gamePanelView;
        this.panelFrameManager = panelFrameManager;
        this.controller = controller;
    }

    public void initGameCharacter(int skinType) {
        if (!gameCharacterAlreadyAdded) {
            gameCharacterElement = new GameElementRender(new GameCharacter(skinType));
            addGameElementRender(gameCharacterElement);
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
        foregroundTimer = new Timer();
        foregroundTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // IT'S WORKING - DON'T TOUCH IT
                for (int i = 0; i < gameElementRenders.size(); i++) {
                    GameElementRender current = gameElementRenders.get(i);
                    current.decrementX(current.getSpeed() * generalSpeed);
                    if (current.getLocation().getX() + current.getWidth() <= 0) removeGameElementRender(i);
                }
                if (gameCharacterAlreadyAdded) yPosGameCharacter = gameCharacterElement.getY();
            }
        }, 0, timerSpeed);
    }

    public void stopGame() {
        foregroundTimer.cancel();
        gameElementRenders.forEach((e) -> gamePanelView.remove(e));
        gameElementRenders.clear();
        gameCharacterAlreadyAdded = false;
    }

    public void moveLeft() {
        for (GameElementRender render : gameElementRenders) render.decrementX(50);
    }

    public void moveRight() {
        for (GameElementRender render : gameElementRenders) render.decrementX(-50);
    }

    public GamePanelView getGamePanelView() {
        return gamePanelView;
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
