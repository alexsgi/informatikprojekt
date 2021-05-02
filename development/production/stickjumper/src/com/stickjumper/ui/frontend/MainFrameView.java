package com.stickjumper.ui.frontend;

import com.stickjumper.utils.UITools;

import javax.swing.*;

public class MainFrameView extends JFrame {

    public MainFrameView(JPanel contentPane) {
        setResizable(false);
        setTitle("StickJumper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 640);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));
    }
}
