package com.stickjumper.frontend.rendering;

import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class MovingBackground extends JLabel {

    private final BufferedImage backgroundMiddle, backgroundMiddleMirrored;
    private final Timer backgroundTimer;
    public int backgroundMiddleX, backgroundMiddleMirroredX;
    private int backgroundSpeed;
    private boolean movement = true;

    public MovingBackground() {
        backgroundMiddle = UITools.getImage(getClass(), "/images/moving_background_files/mountains-middle.png");
        backgroundMiddleMirrored = UITools.getImage(getClass(), "/images/moving_background_files/mountains-middle-mirrored.png");
        backgroundMiddleX = 0;
        backgroundMiddleMirroredX = 1280;

        backgroundSpeed = 7;

        backgroundTimer = new Timer();

        backgroundTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (movement) {
                    if (backgroundMiddleX > -1277) {
                        backgroundMiddleX -= 1;
                    } else {
                        backgroundMiddleX = 1280;
                    }
                    if (backgroundMiddleMirroredX > -1277) {
                        backgroundMiddleMirroredX -= 1;
                    }
                }
            }
        },  0, backgroundSpeed);

    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawImage(backgroundMiddle, backgroundMiddleX, 0,1280, 640, null);
        graphics.drawImage(backgroundMiddleMirrored, backgroundMiddleMirroredX,0,1280, 640,null);
        repaint();
    }

    public void stopMovement() {
        movement = false;
    }

    public void startMovement() {
        movement = true;
    }


}

