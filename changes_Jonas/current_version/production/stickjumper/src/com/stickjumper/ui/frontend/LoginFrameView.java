package com.stickjumper.ui.frontend;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class LoginFrameView extends JFrame {

    public LoginFrameView(JPanel contentPane) {
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

    }

}