package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;

public abstract class Obstacle extends GameElement {

    private int speed;
    private final int skinType;

    public Obstacle(int speed, int skinType) {
        // a running enemy
        this.speed = speed;
        this.skinType = skinType;
    }

    public Obstacle(int skinType) {
        // obstacle "not moving" in the game but moving on the screen
        speed = 0;
        this.skinType = skinType;

    }

    public void hit() {
        //Game Over
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkinType() {
        return skinType;
    }
}