package com.stickjumper.data.gameelements.obstacles;

import com.stickjumper.data.gameelements.Obstacle;
import com.stickjumper.utils.variables.ImageManager;

import java.awt.*;

public class Enemy extends Obstacle {

    public static final Dimension dimension = new Dimension(100 + ImageManager.padding, 93 + ImageManager.padding);

    public Enemy(Point p, int speed) {
        super(p, speed, ImageManager.ENEMY_SKIN, dimension);
    }
}
