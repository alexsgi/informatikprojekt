package com.stickjumper.ui.frontend.boot;

import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class LoadingFrameView extends JFrame {

    public LoadingFrameView() {
        setResizable(false);
        // No border
        setUndecorated(true);
        setSize(1080, 300);
        setLocationRelativeTo(null);
        // Make round corners
        int arc = 18;
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));

        setContentPane(new LoadingPanelView());
    }

}