package com.stickjumper.frontend.boot;

import com.stickjumper.frontend.Settings;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class LoadingFrameView extends JFrame {

    public LoadingFrameView() {
        setResizable(false);
        setUndecorated(true);
        setSize(1080, 300);
        setLocationRelativeTo(null);
        // Make round corners
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), Settings.LOADING_FRAME_CORNER_RADIUS, Settings.LOADING_FRAME_CORNER_RADIUS));
        BufferedImage image = UITools.getImage(getClass(), Settings.APP_ICON);
        Settings.APP_ICON_IMAGE = image;
        setIconImage(image);

        setContentPane(new LoadingPanelView(this));
    }

}