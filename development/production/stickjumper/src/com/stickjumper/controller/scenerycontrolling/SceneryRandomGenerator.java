package com.stickjumper.controller.scenerycontrolling;

public class SceneryRandomGenerator {

    private SceneryController sceneryController;

    // array lists for all objects


    public SceneryRandomGenerator(){
        generate();
        // TODO: creating all the objects "enemy, steadyObstacle, Coin" in here and passing them as input parameter in the method "initCertainObject"
        // therefore, you have to adapt the method in SceneryController for passing an object of the class GameElement as an input parameter
    }

    public void setSceneryController(SceneryController sceneryController) {
        this.sceneryController = sceneryController;
    }

    public void generate(){
        // the real random component
    }

    public void recreate(){
        generate();
        // dont know if this is really needed

        // overwrites all the objects in the array lists, so that the game is different form the last one
    }

}
