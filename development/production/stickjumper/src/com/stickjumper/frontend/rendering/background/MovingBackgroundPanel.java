package com.stickjumper.frontend.rendering.background;

import com.stickjumper.utils.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class MovingBackgroundPanel extends JPanel {

    private final BufferedImage backgroundMiddle, backgroundMiddleMirrored;
    private int backgroundMiddleX = 0, backgroundMiddleMirroredX = 1280;
    private boolean movement = false;

    public MovingBackgroundPanel() {
        super(true);
        setLayout(null);

        backgroundMiddle = ImageManager.MOVING_BACKGROUND;
        backgroundMiddleMirrored = ImageManager.MOVING_BACKGROUND_MIRRORED;

        java.util.Timer backgroundTimer = new Timer();
        int backgroundSpeed = 7;

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
                    } else {
                        backgroundMiddleMirroredX = 1280;
                    }
                }
            }
        }, 0, backgroundSpeed);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawImage(backgroundMiddle, backgroundMiddleX, 0, 1280, 640, null);
        graphics.drawImage(backgroundMiddleMirrored, backgroundMiddleMirroredX, 0, 1280, 640, null);
        repaint();
    }

    public void stopMovement() {
        movement = false;
    }

    public void startMovement() {
        movement = true;
    }

    public void flipStatus() {
        movement = !movement;
    }
}
