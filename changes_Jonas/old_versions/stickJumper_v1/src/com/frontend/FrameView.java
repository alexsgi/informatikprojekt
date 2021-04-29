package com.frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameView extends JFrame {

    public FrameView(frontend.StartView contentPane) {
        setResizable(false);
        setTitle("StickJumper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 640);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
    }

    public FrameView(frontend.StartView panel) {
    }
}
