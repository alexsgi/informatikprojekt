package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;

import java.awt.*;

public class Coin extends GameElement {

    private static final int height = 64, width = 64;
    private static final String imagePath = "/images/elements/coin/coin.png";
    private final int coinValue;

    public Coin(Point p, int coinValue) {
        super(p, height, width, true, imagePath);
        this.setVisible(true);
        this.coinValue = coinValue;
    }

    // Default coinValue
    public Coin(Point p) {
        super(p, height, width, true, imagePath);
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
