package com.stickjumper.data.gameelements;

import com.stickjumper.controller.scenerycontrolling.GameEventListener;
import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Obstacle extends GameElement {

    private GameEventListener listener;

    public Obstacle(Point p, Dimens dimens, BufferedImage image, int speed) {
        super(p, dimens, true, image, speed);
    }

    public Obstacle(Point p, Dimens dimens, BufferedImage image) {
        super(p, dimens, true, image, 1);
    }

    @Override
    public void hit() {
        if (listener != null) listener.onContact(this);
    }

    @Override
    public void addEventListener(GameEventListener listener) {
        this.listener = listener;
    }

}