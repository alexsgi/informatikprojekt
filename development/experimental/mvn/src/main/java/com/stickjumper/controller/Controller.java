package com.stickjumper.controller;

import com.stickjumper.controller.scenerycontrolling.SceneryController;
import com.stickjumper.controller.scenerycontrolling.SceneryRandomGenerator;
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
    public boolean gameStarted = false;
    // Manages all in-game objects
    private SceneryController sceneryController;
    private SceneryRandomGenerator sceneryRandomGenerator;
    // Player management
    private Player signedInPlayer;
    private List playerList;
    private int localHighScore = 0;
    // All panels
    private StartPanelView startPanelView;
    private GamePanelView gamePanelView;
    private Timer connectionTimer;
    private boolean connectedToServer;

    public Controller(MainFrameView mainFrameView, SceneryRandomGenerator sceneryRandomGenerator) {
        this.mainFrameView = mainFrameView;
        this.sceneryRandomGenerator = sceneryRandomGenerator;
        panelFrameManager = new PanelFrameManager(this, mainFrameView);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            stopTimer();
            if (getSignedInPlayer() != null) {
                updateHighScore();
                try {
                    DBConnection.updateHighScore(getSignedInPlayer());
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
        sceneryRandomGenerator.setSceneryController(sceneryController);
        panelFrameManager.setSceneryController(sceneryController);
        // TODO: just a test - DELETE ALL OBJECTS WHEN GOING BACK TO START? - WHEN LOAD ALL OBJECTS?
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
        panelFrameManager.setStartPanelView(startPanelView);
        // initTimer();
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
        localHighScore = -1;
        sceneryController.startGame();
        sceneryRandomGenerator.randomGenerate();
        gameStarted = true;
        mainFrameView.keysEnabledInGame = true;
    }

    public boolean playerLogin(String userName, String password) throws SQLException {
        signedInPlayer = getPlayerFromList(userName, password);
        if (signedInPlayer != null) startPanelView.showHighScore(signedInPlayer.getHighScore());
        localHighScore = -1;
        return signedInPlayer != null;
    }

    private Player getPlayerFromList(String userName, String password) {
        return playerList.search(userName, password);
    }

    public void setList(List list) {
        this.playerList = list;
    }

    public Player getSignedInPlayer() {
        return signedInPlayer;
    }

    public boolean isScoreExisting() {
        return (localHighScore != -1);
    }

    public int getScoreFromSignedInPlayer() {
        return (isScoreExisting()) ? localHighScore : -1;
    }

    public void updateHighScore() {
        if (signedInPlayer != null && signedInPlayer.getHighScore() < localHighScore)
            signedInPlayer.setHighScore(localHighScore);
        startPanelView.updateHighScoreLabel(localHighScore);
    }

    public SceneryController getSceneryController() {
        return sceneryController;
    }

    public MainFrameView getMainFrameView() {
        return mainFrameView;
    }

    public SceneryRandomGenerator getSceneryRandomGenerator() {
        return sceneryRandomGenerator;
    }

    public void updateHighScoreLabel(int newScore) {
        gamePanelView.updateHighScore(newScore);
    }

    public void resetGameScore() {
        gamePanelView.resetHighScore();
    }
}