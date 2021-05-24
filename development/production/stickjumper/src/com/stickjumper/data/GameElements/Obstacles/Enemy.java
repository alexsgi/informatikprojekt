package com.stickjumper.data.gameelements.obstacles;

import com.stickjumper.data.gameelements.Obstacle;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;

import java.awt.*;

public class Enemy extends Obstacle {

    private static final Dimens dimens = new Dimens(100, 88);

    public Enemy(Point p, int speed, int skinType) {
        super(p, dimens, ImageManager.ENEMY_SKIN, speed, skinType);
    }

    public static Dimens getStandardDimens() {
        return dimens;
    }


}
