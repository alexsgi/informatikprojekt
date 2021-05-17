package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;

import java.awt.*;

public class Coin extends GameElement {

    private static final Dimens dimens = new Dimens(64, 64);
    private final int coinValue;

    public Coin(Point p, int coinValue) {
        super(p, dimens, true, ImageManager.COIN_SKIN);
        this.setVisible(true);
        this.coinValue = coinValue;
    }

    public Coin(Point p) {
        super(p, dimens, true, ImageManager.COIN_SKIN);
        this.setVisible(true);
        this.coinValue = 10;
    }

    public void hit() {
        // increase highscore
    }

    public int getCoinValue() {
        return coinValue;
    }
}
