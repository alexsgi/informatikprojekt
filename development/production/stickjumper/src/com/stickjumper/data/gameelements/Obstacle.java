package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Obstacle extends GameElement {

    public Obstacle(Point p, Dimens dimens, BufferedImage image, int speed) {
        super(p, dimens, true, image, speed);
    }

    public Obstacle(Point p, Dimens dimens, BufferedImage image) {
        super(p, dimens, true, image, 0);
    }

    public void hit() {
        //Game Over
    }

}