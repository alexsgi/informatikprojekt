package com.stickjumper.ui.frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class FrameView extends JFrame {

    public FrameView(JPanel contentPane) {
        setResizable(false);
        setTitle("StickJumper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 640);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

    }

}
