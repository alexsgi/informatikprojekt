package com.stickjumper.ui.frontend.boot;

import com.stickjumper.start.Starter;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class LoadingFrameView extends JFrame {

    public LoadingFrameView(JPanel contentPane) {
        setResizable(false);
        setUndecorated(true);
        setSize(1080, 300);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        int arc = 25;
        setShape(new RoundRectangle2D.Double(0, 0, 1080, 300, arc, arc));
        setIconImage(Starter.getImage(getClass(), "/images/icons/appicon_5.png"));
    }

}