package com.stickjumper.ui.frontend.login;

import com.stickjumper.ui.frontend.Controller;

import javax.swing.*;

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


    public void disposeLoginFrame() {
        setVisible(false);
        dispose();
    }

}