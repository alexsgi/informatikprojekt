package com.stickjumper.data;

import java.awt.*;

public abstract class GameElement {

    private Point point = new Point();
    private int length;
    private int width;
    private boolean visible;
    private String imagePath;

    public GameElement(Point p, int length, int width, boolean visible, String imagePath) {
        this.point = p;
        this.length = length;
        this.width = width;
        this.visible = visible;
        this.imagePath = imagePath;
    }

    public void setLocation(Point newPoint) {
        point = newPoint;
    }

    public Point getLocation() {
        return point;
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

    public int getLength() {
        return length;
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
}