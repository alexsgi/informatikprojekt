package com.stickjumper.data.gameelements.obstacle;

import com.stickjumper.data.gameelements.Obstacle;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.ImageManager;

import java.awt.*;

public class SteadyObstacle extends Obstacle {

    public static final Dimens dimens = new Dimens(50, 100);

    public SteadyObstacle(Point p) {
        super(p, dimens, ImageManager.STEADY_OBSTACLE_SKIN);
    }

    public static Dimens getStandardDimens() {
        return dimens;
    }

    @Override
    public void hit() {
        if (Settings.STEADY_OBSTACLES_LETHAL) super.hit();
    }
}
