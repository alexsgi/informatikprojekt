package com.stickjumper.data;

import com.stickjumper.controller.scenerycontrolling.SceneryController;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameElement {

    private Point location;
    private Dimens dimens;
    private boolean visible;
    private BufferedImage image;
    private int speed;


    public GameElement(Point p, Dimens d, boolean visible, BufferedImage image, int speed) {
        this.location = p;
        this.dimens = new Dimens(d.getWidth() + ImageManager.getSizeTolerance(), d.getHeight() + ImageManager.getSizeTolerance());
        this.visible = visible;
        this.image = image;
        this.speed = speed;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public void decrementX(int n) {


        if (location.getX() == Settings.xPositionGameCharacter + Settings.xDimensGameCharacter) {

            int rotMinusGelb = (int) (SceneryController.yPosGameCharacter - location.getY());
            System.err.println(rotMinusGelb);
            boolean firstCondition = rotMinusGelb < getDimens().getHeight();

            boolean secondCondition = rotMinusGelb < -GameCharacter.dimens.getHeight();
            boolean yHit = firstCondition && secondCondition;
            this.hit();

        }
        location.x -= n;
    }

    public abstract void hit();

}