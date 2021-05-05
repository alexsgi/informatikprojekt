package com.stickjumper.ui.frontend.login;

import com.stickjumper.ui.frontend.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrameView extends JFrame {

    private LoginPanelView loginPanel;

    public LoginFrameView(Controller controller) {
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setLocationRelativeTo(null);
        loginPanel = new LoginPanelView(controller, this);
        setContentPane(loginPanel);

    }


    public void pullThePlug() {
        // this will hide and dispose the frame, so that the application quits by
        // itself if there is nothing else around.
        setVisible(false);
        dispose();

    }

}