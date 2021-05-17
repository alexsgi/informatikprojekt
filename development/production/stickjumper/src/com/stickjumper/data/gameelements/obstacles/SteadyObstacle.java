package com.stickjumper.data.gameelements.obstacles;

import com.stickjumper.data.gameelements.Obstacle;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;

import java.awt.*;

public class SteadyObstacle extends Obstacle {

    public static final Dimens dimens = new Dimens(100, 75);

    public SteadyObstacle(Point p) {
        super(p, dimens, ImageManager.STEADY_OBSTACLE_SKIN);
    }

    public static Dimens getStandardDimens() {
        return dimens;
    }

}
