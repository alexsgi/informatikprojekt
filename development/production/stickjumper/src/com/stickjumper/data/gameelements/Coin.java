package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;

import java.awt.*;

public class Coin extends GameElement {

    private static final Dimens dimens = new Dimens(64, 64);
    private static final int speed = 1;
    private final int coinValue;

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
        System.out.println("Coin hit");
    }

    public int getCoinValue() {
        return coinValue;
    }

}
