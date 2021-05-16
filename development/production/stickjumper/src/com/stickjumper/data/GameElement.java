package com.stickjumper.data;

import java.awt.*;

public abstract class GameElement {

    private Point point;
    private int height;
    private int width;
    private boolean visible;
    private String imagePath;

    public GameElement(Point p, int width, int height, boolean visible, String imagePath) {
        this.point = p;
        this.height = height;
        this.width = width;
        this.visible = visible;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void incrementX(int n) {
        point.x += n;
    }

    public void incrementY(int n) {
        point.y += n;
    }
}