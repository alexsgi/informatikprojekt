package com.stickjumper.data;

import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameElement {

    private Point location;
    private Dimens dimens;
    private boolean visible;
    private BufferedImage image;

    public GameElement(Point p, Dimens d, boolean visible, BufferedImage image) {
        this.location = p;
        d = new Dimens(d.getWidth() + ImageManager.getSizeTolerance(), d.getHeight() + ImageManager.getSizeTolerance());
        this.dimens = d;
        this.visible = visible;
        this.image = image;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point newPoint) {
        location = newPoint;
    }

    public Dimens getDimens() {
        return dimens;
    }

    public void setDimens(Dimens dimens) {
        this.dimens = dimens;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void incrementX(int n) {
        location.x += n;
    }

    public void incrementY(int n) {
        location.y += n;
    }
}