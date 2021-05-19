package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Obstacle extends GameElement {

    private int speed;

    public Obstacle(Point p, Dimens dimens, BufferedImage image, int speed) {
        super(p, dimens, true, image);
        this.speed = speed;
    }

    public Obstacle(Point p, Dimens dimens, BufferedImage image) {
        super(p, dimens, true, image);
        this.speed = 0;
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