package com.stickjumper.ui.frontend.boot;

import javax.swing.*;

public class LoadingFrameView extends JFrame {

    public LoadingFrameView(JPanel contentPane) {
        setResizable(false);
        setUndecorated(true);
        setSize(1080, 300);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
    }

}