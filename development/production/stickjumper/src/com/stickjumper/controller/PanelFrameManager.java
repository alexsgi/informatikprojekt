package com.stickjumper.controller;

import com.stickjumper.controller.scenerycontrolling.SceneryController;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.login.LoginPanelView;
import com.stickjumper.frontend.login.RegisterPanelView;
import com.stickjumper.frontend.rendering.background.MovingBackgroundPanel;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.AccountPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.SettingsPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.StatisticsPanelView;

public class PanelFrameManager {

    // All panels
    public StartPanelView startPanelView;
    public LoginPanelView loginPanelView;
    public RegisterPanelView registerPanelView;
    public GamePanelView gamePanelView;
    public StatisticsPanelView statisticsPanelView;
    public SettingsPanelView settingsPanelView;
    public AccountPanelView accountPanelView;

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
    }

    public void switchToStartPanel() {
        sceneryController.stopGame();
        controller.getSceneryRandomGenerator().stop();
        mainFrameView.getContentPane().removeAll();

        controller.gameStarted = false;
        controller.updateHighScore();

        mainFrameView.getContentPane().add(startPanelView);
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

    public boolean isGamePanelActive() {
        return mainFrameView.getContentPane() instanceof GamePanelView;
    }

    public boolean isStartPanelActive() {
        return mainFrameView.getContentPane() instanceof StartPanelView;
    }

    public void setStatisticsPanel(StatisticsPanelView statisticsPanelView) {
        this.statisticsPanelView = statisticsPanelView;
    }

    public void setSettingsPanelView(SettingsPanelView settingsPanelView) {
        this.settingsPanelView = settingsPanelView;
    }

    public void setAccountPanelView(AccountPanelView accountPanelView) {
        this.accountPanelView = accountPanelView;
    }

    public void switchToStatisticsPanel() {
        mainFrameView.getContentPane().removeAll();
        mainFrameView.getContentPane().add(statisticsPanelView);
        statisticsPanelView.refresh();
    }

    public void switchToSettingsPanel() {
        mainFrameView.getContentPane().removeAll();
        mainFrameView.getContentPane().add(settingsPanelView);
    }

    public void switchToAccountPanel() {
        mainFrameView.getContentPane().removeAll();
        accountPanelView.refreshValues();
        mainFrameView.getContentPane().add(accountPanelView);
    }

    public void switchToHome() {
        mainFrameView.getContentPane().removeAll();
        mainFrameView.getContentPane().add(startPanelView);
    }

}