package com.stickjumper.data;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameElement {

    private Point point;
    private int width, height;
    private boolean visible;
    private BufferedImage image;

    public GameElement(Point p, int width, int height, boolean visible, BufferedImage image) {
        this.point = p;
        this.height = height;
        this.width = width;
        this.visible = visible;
        this.image = image;
    }

    public Point getLocation() {
        return point;
    }

    public void setLocation(Point newPoint) {
        point = newPoint;
    }

    public int getX() {
        return point.x;
    }

    public void setX(int xPos) {
        point.x = xPos;
    }

    public int getY() {
        return point.y;
    }

    public void setY(int yPos) {
        point.y = yPos;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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

    public void incrementX(int n) {
        point.x += n;
    }

    public void incrementY(int n) {
        point.y += n;
    }
}