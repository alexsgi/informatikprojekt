package com.stickjumper.frontend.boot;

import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.UITools;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class LoadingFrameView extends JFrame {

    public LoadingFrameView() {
        setResizable(false);
        setUndecorated(true);
        setSize(1080, 300);
        setLocationRelativeTo(null);

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), Settings.LOADING_FRAME_CORNER_RADIUS, Settings.LOADING_FRAME_CORNER_RADIUS));
        ImageManager.APP_ICON_IMAGE = UITools.getImage(getClass(), Settings.APP_ICON);
        setIconImage(ImageManager.APP_ICON_IMAGE);
        setContentPane(new LoadingPanelView(this));
    }

}