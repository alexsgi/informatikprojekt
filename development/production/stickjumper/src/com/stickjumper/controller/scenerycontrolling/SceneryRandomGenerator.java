package com.stickjumper.controller.scenerycontrolling;

import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.obstacles.Enemy;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.utils.Settings;

import java.awt.*;

public class SceneryRandomGenerator {

    private SceneryController sceneryController;

    // array lists for all objects


    public SceneryRandomGenerator(){
        // TODO: creating all the objects "enemy, steadyObstacle, Coin" in here and passing them as input parameter in the method "initCertainObject"
        // therefore, you have to adapt the method in SceneryController for passing an object of the class GameElement as an input parameter
    }

    public void setSceneryController(SceneryController sceneryController) {
        this.sceneryController = sceneryController;
    }

    public void generate(){
        GamePanelView gamePanelView = sceneryController.getGamePanelView();
        int h = gamePanelView.getHeight()- Settings.seaLevel;
        int w = gamePanelView.getWidth();


        sceneryController.initCertainGameObject(new Coin(new Point(w, (h - Enemy.getStandardDimens().getHeight()- 0)), 1));
        // the real random component
    }

    public void recreate(){
        generate();
        // dont know if this is really needed

        // overwrites all the objects in the array lists, so that the game is different form the last one
    }

}
