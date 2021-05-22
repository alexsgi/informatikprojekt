package com.stickjumper.controller;

import com.stickjumper.controller.scenerycontrolling.SceneryController;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.login.LoginPanelView;
import com.stickjumper.frontend.login.RegisterPanelView;
import com.stickjumper.frontend.rendering.background.MovingBackgroundPanel;
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
    private SceneryController sceneryController;

    public PanelFrameManager(Controller controller, MainFrameView mainFrameView) {
        this.controller = controller;
        this.mainFrameView = mainFrameView;
    }

    public void enableMainFrame() {
        mainFrameView.setEnabled(true);
    }

    public void disableMainFrame() {
        mainFrameView.setEnabled(false);
    }

    public void openLoginFrame() {
        disableMainFrame();
        loginFrameView.setVisible(true);
    }

    public void closeLoginFrame() {
        enableMainFrame();
        loginFrameView.dispose();
    }

    public void switchToGamePanel() {
        mainFrameView.getContentPane().removeAll();
        mainFrameView.getContentPane().add(gamePanelView);
        startMovingBackground();
    }

    public void switchToStartPanel() {
        sceneryController.stopGame();
        mainFrameView.getContentPane().removeAll();
        mainFrameView.getContentPane().add(startPanelView);
        stopMovingBackground();
        if (controller.getCurrentPlayer() != null)
            startPanelView.showHighScore(controller.getCurrentPlayer().getHighScore());
    }

    public void startMovingBackground() {
        ((MovingBackgroundPanel) mainFrameView.getContentPane()).startMovement();
    }

    public void stopMovingBackground() {
        ((MovingBackgroundPanel) mainFrameView.getContentPane()).stopMovement();
    }

    public void switchToRegisterPanel() {
        loginFrameView.setContentPane(registerPanelView);
    }

    public void switchToLoginPanel() {
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

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
    }

    public void setLoginFrameView(LoginFrameView loginFrameView) {
        this.loginFrameView = loginFrameView;
    }

    public void setSceneryController(SceneryController sceneryController) {
        this.sceneryController = sceneryController;
    }

}
