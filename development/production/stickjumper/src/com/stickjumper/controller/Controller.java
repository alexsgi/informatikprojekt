package com.stickjumper.controller;

import com.stickjumper.data.Player;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.login.LoginPanelView;
import com.stickjumper.frontend.login.RegisterPanelView;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.utils.ConnectionTester;
import com.stickjumper.utils.Settings;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    // Manages open and close operations for frames and panels
    private final PanelFrameManager panelFrameManager;
    // All frames
    private final MainFrameView mainFrameView;
    // Manages all in-game objects
    private SceneryController sceneryController;
    // Player management
    private Player currentPlayer;
    private List playerList;
    private int currentScore = 0;
    // All panels
    private StartPanelView startPanelView;
    private GamePanelView gamePanelView;

    private Timer connectionTimer;
    private boolean connectedToServer;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
        panelFrameManager = new PanelFrameManager(this, mainFrameView);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            stopTimer();
            if (getCurrentPlayer() != null) {
                updateHighScore();
                try {
                    DBConnection.updateHighScore(getCurrentPlayer());
                } catch (SQLException e) {
                    Settings.logData("SQLException (updateHighscore in Controller)", e);
                    JOptionPane.showMessageDialog(null, "Error updating highscore");
                }
            }
            DBConnection.close();
        }));
    }

    public void setGamePanelView(GamePanelView gamePanelView) {
        this.gamePanelView = gamePanelView;
        panelFrameManager.setGamePanelView(gamePanelView);
        sceneryController = new SceneryController(gamePanelView, panelFrameManager, this);
        panelFrameManager.setSceneryController(sceneryController);
        // TODO: just a test - DELETE ALL OBJECTS WHEN GOING BACK TO START? - WHEN LOAD ALL OBJECTS?
        sceneryController.initSomeObjects();
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
        panelFrameManager.setStartPanelView(startPanelView);
        initTimer();
    }

    public void setLoginFrameView(LoginFrameView loginFrameView) {
        panelFrameManager.setLoginFrameView(loginFrameView);
    }

    public void setLoginPanelView(LoginPanelView loginPanelView) {
        panelFrameManager.setLoginPanelView(loginPanelView);
    }

    public void setRegisterPanelView(RegisterPanelView registerPanelView) {
        panelFrameManager.setRegisterPanelView(registerPanelView);
    }

    public PanelFrameManager getPanelFrameManager() {
        return panelFrameManager;
    }

    private void initTimer() {
        connectionTimer = new Timer();
        connectionTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Settings.logDataOneLine("Checking connection ...");
                int connectionStatus = ConnectionTester.checkConnection();
                connectedToServer = connectionStatus == ConnectionTester.CONNECTION_OK;
                if (connectedToServer) {
                    startPanelView.getInternetIconLabel().setInternetEnabledStatus();
                    Settings.logData(" ok");
                } else {
                    startPanelView.getInternetIconLabel().setInternetDisabledStatus();
                    Settings.logData(" failed");
                }
            }
        }, 5000, 10000);
    }

    private void stopTimer() {
        if (connectionTimer != null) connectionTimer.cancel();
    }

    public void startGame() {
        panelFrameManager.switchToGamePanel();
        currentScore = -1;
        sceneryController.startGame();
    }

    public boolean playerLogin(String userName, String password) throws SQLException {
        currentPlayer = getPlayerFromList(userName, password);
        if (currentPlayer != null) startPanelView.showHighScore(currentPlayer.getHighScore());
        currentScore = -1;
        return currentPlayer != null;
    }

    private Player getPlayerFromList(String userName, String password) {
        return playerList.search(userName, password);
    }

    public void setList(List list) {
        this.playerList = list;
    }

    public void startMovingBackground() {
        panelFrameManager.startMovingBackground();
    }

    public void stopMovingBackground() {
        panelFrameManager.stopMovingBackground();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isScoreExisting() {
        return (currentScore != -1);
    }

    public int getScoreFromCurrentPlayer() {
        return (isScoreExisting()) ? currentScore : -1;
    }

    public void setScore(int newScore) {
        currentScore = newScore;
    }

    public void updateHighScore() {
        if (currentPlayer.getHighScore() < currentScore) currentPlayer.setHighScore(currentScore);
    }

    public SceneryController getSceneryController() {
        return sceneryController;
    }

}
