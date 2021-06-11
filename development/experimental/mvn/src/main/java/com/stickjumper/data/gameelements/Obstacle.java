package com.stickjumper.data.gameelements;

import com.stickjumper.controller.scenerycontrolling.GameEventListener;
import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Obstacle extends GameElement {

    private int skinType;
    private GameEventListener listener;

    public Obstacle(Point p, Dimens dimens, BufferedImage image, int speed, int skinType) {
        super(p, dimens, true, image, speed);
        this.skinType = skinType;
    }

    public Obstacle(Point p, Dimens dimens, BufferedImage image, int skinType) {
        super(p, dimens, true, image, 0);
        this.skinType = skinType;
    }

    @Override
    public void hit() {
        if (listener != null) listener.onContact(this);
        // SceneryController.gameOver = true;
    }

    @Override
    public void addEventListener(GameEventListener listener) {
        this.listener = listener;
    }


}