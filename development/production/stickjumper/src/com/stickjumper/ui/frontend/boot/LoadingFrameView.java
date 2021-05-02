package com.stickjumper.ui.frontend.boot;

import com.stickjumper.start.Starter;

import javax.swing.*;

public class LoadingFrameView extends JFrame {

    public LoadingFrameView(JPanel contentPane) {
        setResizable(false);
        setUndecorated(true);
        setSize(1080, 300);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        setIconImage(Starter.getImage(getClass(), "/images/icons/appicon_5.png"));
    }

}