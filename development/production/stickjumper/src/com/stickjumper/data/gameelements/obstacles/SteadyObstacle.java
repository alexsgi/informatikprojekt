package com.stickjumper.data.gameelements.obstacles;

import com.stickjumper.data.gameelements.Obstacle;
import com.stickjumper.utils.variables.ImageManager;

import java.awt.*;

public class SteadyObstacle extends Obstacle {

    public static final Dimension dimension = new Dimension(100 + ImageManager.padding, 75 + ImageManager.padding);

    public SteadyObstacle(Point p) {
        super(p, ImageManager.STEADY_OBSTACLE_SKIN, dimension);
    }
}
