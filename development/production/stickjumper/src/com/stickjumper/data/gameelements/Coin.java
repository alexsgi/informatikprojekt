package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.utils.variables.ImageManager;

import java.awt.*;

public class Coin extends GameElement {

    public static final int width = 64 + ImageManager.padding, height = 64 + ImageManager.padding;
    private final int coinValue;

    public Coin(Point p, int coinValue) {
        super(p, width, height, true, ImageManager.COIN_SKIN);
        this.setVisible(true);
        this.coinValue = coinValue;
    }

    // Default coinValue
    public Coin(Point p) {
        super(p, width, height, true, ImageManager.COIN_SKIN);
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
