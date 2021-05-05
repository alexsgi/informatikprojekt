package com.stickjumper.ui.frontend.login;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class LoginFrameView extends JFrame {

    public LoginFrameView(JPanel contentPane) {
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setUndecorated(true);
        int arc = 18;
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
    }

}