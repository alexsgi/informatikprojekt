package com.stickjumper.data;

import com.stickjumper.controller.scenerycontrolling.GameEventListener;
import com.stickjumper.controller.scenerycontrolling.SceneryController;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameElement {

    private Point location;
    private Dimens dimens;
    private boolean visible;
    private BufferedImage image;
    private int speed;

    private GameEventListener listener;

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
        // DON'T TOUCH IT - WE DON'T KNOW WHY IT WORKS
        boolean gameOverCondition1 = location.getX() <= Settings.X_POSITION_GAME_CHARACTER + GameCharacter.getXValueDimens();
        boolean gameOverCondition2 = location.getX() >= Settings.X_POSITION_GAME_CHARACTER + GameCharacter.getXValueDimens() - Settings.GAME_OVER_SENSITIVITY;

        if (gameOverCondition1 && gameOverCondition2) {
            int difPos = (int) (SceneryController.getYPosGameCharacter() - location.getY());
            boolean firstCondition = difPos < getDimens().getHeight();
            boolean secondCondition = difPos < -GameCharacter.dimens.getHeight();
            if ((firstCondition && !secondCondition) || (!firstCondition && secondCondition)) this.hit();
        }
        location.x -= n;
    }

    public void incrementY(int n) {
        location.y -= n;
    }

    public void decrementY(int n) {
        location.y += n;
    }

    public abstract void hit();

    public abstract void addEventListener(GameEventListener listener);

}