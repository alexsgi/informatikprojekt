package com.stickjumper.controller.scenerycontrolling;

public class SceneryRandomGenerator {

    private SceneryController sceneryController;


    public SceneryRandomGenerator(){
        // missing random component
        // TODO: creating all the objects "enemy, steadyObstacle, Coin" in here and passing them as input parameter in the method "initCertainObject"
        // therefore, you have to adapt the method in SceneryController for passing an object of the class GameElement as an input parameter
    }

    public void setSceneryController(SceneryController sceneryController) {
        this.sceneryController = sceneryController;
    }

}
