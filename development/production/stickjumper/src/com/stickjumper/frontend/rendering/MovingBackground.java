package com.stickjumper.frontend.rendering;

import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class MovingBackground extends JLabel {

    private final BufferedImage backgroundMiddle, backgroundMiddleMirrored;
    public double backgroundMiddleX, backgroundMiddleMirroredX;
    private double backgroundSpeed;


    private final Timer backgroundTimer;
    private boolean movement = true;

    public MovingBackground() {
        backgroundMiddle = UITools.getImage(getClass(), "/images/moving_background_files/mountains-middle.png");
        backgroundMiddleMirrored = UITools.getImage(getClass(), "/images/moving_background_files/mountains-middle-mirrored.png");
        backgroundMiddleX = 0;
        backgroundMiddleMirroredX = 1280;

        backgroundSpeed = 1;

        backgroundTimer = new Timer();

        move();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawImage(backgroundMiddle, (int) backgroundMiddleX, 0,1280, 640, null);
        graphics.drawImage(backgroundMiddleMirrored, (int) backgroundMiddleMirroredX,0,1280, 640,null);
        repaint();
    }

    public void stopMovement() {
        movement = false;
    }

    public void startMovement() {
        movement = true;
    }

    public void move(){
        backgroundMiddleX += 90;
        backgroundMiddleMirroredX += 90;
     backgroundTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (movement) {
                    if(backgroundMiddleX > -1277){
                        backgroundMiddleX -= 0.1;
                    } else {
                       backgroundMiddleX = 1280;
                 }
                   if(backgroundMiddleMirroredX > -1277){
                      backgroundMiddleMirroredX -= 0.1;
                 }
              }
          }
        }, 0, (long) backgroundSpeed);
    }
}

