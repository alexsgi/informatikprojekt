package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.UITools;

import javax.swing.*;

public class LoginFrameView extends JFrame {

    private LoginPanelView loginPanel;

    public LoginFrameView(Controller controller) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setLocationRelativeTo(null);
        loginPanel = new LoginPanelView(controller, this);
        setContentPane(loginPanel);
        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));
    }


    public void disposeLoginFrame() {
        setVisible(false);
        dispose();
    }

}