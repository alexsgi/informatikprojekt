package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;

import java.awt.*;

public abstract class Obstacle extends GameElement {

    private int speed;
    private static final int length = 64, width = 64;
    private static final String imagePath = "/images/elements/coin/coin.png";

    public Obstacle(Point p, int speed) {
        super(p, length, width, true, imagePath);
        // a running enemy
        this.speed = speed;
    }

    public Obstacle(Point p) {
        super(p, length, width, true, imagePath);
        // obstacle "not moving" in the game but moving on the screen
        speed = 0;
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

}