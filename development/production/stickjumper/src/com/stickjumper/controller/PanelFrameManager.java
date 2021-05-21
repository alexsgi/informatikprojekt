package com.stickjumper.controller;

import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.login.LoginPanelView;
import com.stickjumper.frontend.login.RegisterPanelView;
import com.stickjumper.frontend.start.StartPanelView;

public class PanelFrameManager {

    // All panels
    public StartPanelView startPanelView;
    public LoginPanelView loginPanelView;
    public RegisterPanelView registerPanelView;
    public GamePanelView gamePanelView;

    // All frames
    public MainFrameView mainFrameView;
    public LoginFrameView loginFrameView;

    public Controller controller;

    public PanelFrameManager(Controller controller, MainFrameView mainFrameView) {
        this.controller = controller;
        this.mainFrameView = mainFrameView;
    }

    public void enableMainFrame() {
        mainFrameView.setEnabled(true);
        mainFrameView.setAlwaysOnTop(true);
    }

    public void starterLoginButton() {
        mainFrameDisable();
        loginFrameView.setVisible(true);
    }

    public void loginFrameClose() {
        loginFrameView.setVisible(false);
        enableMainFrame();
        loginFrameView.dispose();
    }

    public void mainFrameDisable() {
        mainFrameView.setEnabled(false);
        mainFrameView.setAlwaysOnTop(false);
    }

    public void switchToGamePanel() {
        //mainFrameView.setContentPane(gamePanelView);
        mainFrameView.getContentPane().removeAll();
        mainFrameView.getContentPane().add(gamePanelView);
        //mainFrameView.revalidate();
    }

    public void switchToStartPanel() {
        mainFrameView.getContentPane().removeAll();
        mainFrameView.getContentPane().add(startPanelView);
        if (controller.getCurrentPlayer() != null)
            controller.getPanelFrameManager().startPanelView.showHighScore(controller.getCurrentPlayer().getHighScore());
        mainFrameView.revalidate();
    }

    public void loginPanelToRegisterPanel() {
        loginFrameView.setContentPane(registerPanelView);
    }

    public void switchToLogin() {
        loginFrameView.setContentPane(loginPanelView);
    }

    public void setLoginPanelView(LoginPanelView loginPanelView) {
        this.loginPanelView = loginPanelView;
    }

    public void setRegisterPanelView(RegisterPanelView registerPanelView) {
        this.registerPanelView = registerPanelView;
    }

    public void setGamePanelView(GamePanelView gamePanelView) {
        this.gamePanelView = gamePanelView;
    }

    public void setLoginFrameView(LoginFrameView loginFrameView) {
        this.loginFrameView = loginFrameView;
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
    }
}
