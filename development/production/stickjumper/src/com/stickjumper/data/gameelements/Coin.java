package com.stickjumper.data.gameelements;

import com.stickjumper.controller.scenerycontrolling.GameEventListener;
import com.stickjumper.data.GameElement;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.manager.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class Coin extends GameElement {

    private static final Dimens dimens = new Dimens(45, 45);
    private static final int speed = 1;
    private static final int[] coinValues = new int[]{10, 20, 30, 40, 50};
    private final int coinValue;
    private boolean hitOnce = false;
    private GameEventListener listener;

    public Coin(Point p, int coinValue) {
        super(p, dimens, true, ImageManager.COIN_SKIN, speed);
        this.coinValue = coinValue;
    }

    private Coin(Point p, int coinValue, BufferedImage image) {
        super(p, dimens, true, image, speed);
        this.coinValue = coinValue;
    }

    public static Coin createCoin(Point p) {
        int valueCoin = coinValues[ThreadLocalRandom.current().nextInt(0, coinValues.length)];
        BufferedImage image = switch (valueCoin) {
            case 20 -> ImageManager.COIN_SKIN_20;
            case 30 -> ImageManager.COIN_SKIN_30;
            case 40 -> ImageManager.COIN_SKIN_40;
            case 50 -> ImageManager.COIN_SKIN_50;
            default -> ImageManager.COIN_SKIN_10;
        };
        return new Coin(p, valueCoin, image);
    }

    public static Dimens getStandardDimens() {
        return dimens;
    }

    @Override
    public void hit() {
        if (!hitOnce && listener != null) {
            hitOnce = true;
            listener.onContact(this);
            setVisible(false);
        }
    }

    public int getCoinValue() {
        return coinValue;
    }

    @Override
    public void addEventListener(GameEventListener listener) {
        this.listener = listener;
    }

}
