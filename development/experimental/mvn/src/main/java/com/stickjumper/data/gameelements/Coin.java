package com.stickjumper.data.gameelements;

import com.stickjumper.controller.scenerycontrolling.SceneryController;
import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.SoundManager;

import java.awt.*;

public class Coin extends GameElement {

    private static final Dimens dimens = new Dimens(45, 45);
    private static final int speed = 1;
    private final int coinValue;
    private boolean hitOnce = false;

    public Coin(Point p, int coinValue) {
        super(p, dimens, true, ImageManager.COIN_SKIN, speed);
        this.coinValue = coinValue;
    }

    public Coin(Point p) {
        super(p, dimens, true, ImageManager.COIN_SKIN, speed);
        this.coinValue = 10;
    }

    public static Dimens getStandardDimens() {
        return dimens;
    }

    @Override
    public void hit() {
        if (!hitOnce) {
            Settings.logData("Coin hit");
            hitOnce = true;
            SceneryController.coinHit = true;
            SceneryController.currentCoinValue = coinValue;
            SoundManager.playSound(SoundManager.inputStreamCoinSound);
            setVisible(false);
        }
    }

    public int getCoinValue() {
        return coinValue;
    }

}
