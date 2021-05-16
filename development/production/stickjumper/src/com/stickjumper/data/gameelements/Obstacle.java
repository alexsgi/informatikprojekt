package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Obstacle extends GameElement {

    private int speed;

    public Obstacle(Point p, int speed, BufferedImage image, Dimension dimension) {
        super(p, dimension.width, dimension.height, true, image);
        this.speed = speed;
    }

    public Obstacle(Point p, BufferedImage image, Dimension dimension) {
        super(p, dimension.width, dimension.height, true, image);
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