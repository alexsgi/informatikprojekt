package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.UITools;

import javax.swing.*;

public class LoginFrameView extends JFrame {

    private Controller controller;
    private LoginPanelView loginPanelView;
    private RegisterPanelView registerPanelView;

    public LoginFrameView(Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setLocationRelativeTo(null);

        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));

        // builds both panels, they can be changed via PanelFrameManager
        registerPanelView = new RegisterPanelView(controller, this);
        controller.setRegisterPanelView(registerPanelView);
        loginPanelView = new LoginPanelView(controller, this);
        controller.setLoginPanelView(loginPanelView);

        setContentPane(loginPanelView);


    }


}