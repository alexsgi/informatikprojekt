package com.stickjumper.data;

public abstract class GameElement {

    private int xPos;
    private int yPos;
    private int length;
    private int width;
    private boolean visible;
    // private boolean vulnerable;
    // private int highScore;
    // private int skinType;
    // is this information really necessary in all objects, which use GameElement like coins?


    public GameElement() {
        xPos = 0;
        yPos = 0;
        length = 0;
        width = 0;
        // TODO: What are the default values for those?
        visible = true;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}