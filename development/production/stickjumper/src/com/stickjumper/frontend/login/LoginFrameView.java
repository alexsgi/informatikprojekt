package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.variables.ImageManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrameView extends JFrame {

    public LoginFrameView(Controller controller) {
        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                controller.getPanelFrameManager().enableMainFrame();
            }
        });

        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setLocationRelativeTo(null);
        // setAlwaysOnTop(true);

        setIconImage(ImageManager.APP_ICON_IMAGE);

        // builds both panels, they can be changed via PanelFrameManager
        RegisterPanelView registerPanelView = new RegisterPanelView(controller, this);
        controller.setRegisterPanelView(registerPanelView);
        LoginPanelView loginPanelView = new LoginPanelView(controller, this);
        controller.setLoginPanelView(loginPanelView);

        setContentPane(loginPanelView);
    }
}