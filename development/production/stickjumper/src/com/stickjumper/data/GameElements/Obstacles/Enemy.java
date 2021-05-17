package com.stickjumper.data.gameelements.obstacles;

import com.stickjumper.data.gameelements.Obstacle;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;

import java.awt.*;

public class Enemy extends Obstacle {

    private static final Dimens dimens = new Dimens(100, 93);

    public Enemy(Point p, int speed) {
        super(p, dimens, ImageManager.ENEMY_SKIN, speed);
    }

    public static Dimens getStandardDimens() {
        return dimens;
    }

}
