package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrameView extends AdvancedFrame {

    public LoginFrameView(Controller controller) {
        super();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                controller.getPanelFrameManager().enableMainFrame();
            }
        });

        setKeyTitle("login.frame.title");
        setSize(Settings.LOGIN_SCREEN_WIDTH, Settings.LOGIN_SCREEN_HEIGHT);
        setLocationRelativeTo(null);

        RegisterPanelView registerPanelView = new RegisterPanelView(controller, this);
        controller.setRegisterPanelView(registerPanelView);
        LoginPanelView loginPanelView = new LoginPanelView(controller, this);
        controller.setLoginPanelView(loginPanelView);

        setContentPane(loginPanelView);
    }
}