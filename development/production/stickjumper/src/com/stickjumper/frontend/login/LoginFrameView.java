package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.UITools;

import javax.swing.*;

public class LoginFrameView extends JFrame {

    Controller controller;

    public LoginFrameView(Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setLocationRelativeTo(null);
        LoginPanelView loginPanel = new LoginPanelView(controller, this);
        setContentPane(loginPanel);
        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));
    }


    public void disposeLoginFrame() {
        setVisible(false);
        controller.enableMainFrame();
        dispose();

    }

    public void openRegister() {
        // setContentPane(null);
        RegisterPanelView registerPanelView = new RegisterPanelView(controller, this);
        setContentPane(registerPanelView);
    }

}