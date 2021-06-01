package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.Settings;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrameView extends JFrame {

    public LoginFrameView(Controller controller) {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                controller.getPanelFrameManager().enableMainFrame();
            }
        });

        setResizable(false);
        setTitle("Login");
        setSize(Settings.LOGIN_SCREEN_WIDTH, Settings.LOGIN_SCREEN_HEIGHT);
        setLocationRelativeTo(null);

        setIconImage(ImageManager.APP_ICON_IMAGE);

        RegisterPanelView registerPanelView = new RegisterPanelView(controller, this);
        controller.setRegisterPanelView(registerPanelView);
        LoginPanelView loginPanelView = new LoginPanelView(controller, this);
        controller.setLoginPanelView(loginPanelView);

        setContentPane(loginPanelView);
    }
}