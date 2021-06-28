package com.stickjumper.controller;

import com.stickjumper.controller.scenerycontrolling.GameController;
import com.stickjumper.controller.scenerycontrolling.GameRandomGenerator;
import com.stickjumper.data.Player;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.login.LoginPanelView;
import com.stickjumper.frontend.login.RegisterPanelView;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.network.ConnectionTester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    // Manages open and close operations for frames and panels
    private final PanelFrameManager panelFrameManager;
    // All frames
    private final MainFrameView mainFrameView;
    private final GameRandomGenerator sceneryRandomGenerator;
    public boolean gameStarted = false;
    // Manages all in-game objects
    private GameController gameController;
    // Player management
    private Player signedInPlayer;
    private List playerList;
    private int localHighScore = 0, lastRoundHighScore = 0;
    // All panels
    private StartPanelView startPanelView;
    private GamePanelView gamePanelView;
    private Timer connectionTimer;
    private boolean connectedToServer;

    public Controller(MainFrameView mainFrameView, GameRandomGenerator sceneryRandomGenerator) {
        this.mainFrameView = mainFrameView;
        this.sceneryRandomGenerator = sceneryRandomGenerator;
        panelFrameManager = new PanelFrameManager(this, mainFrameView);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            stopTimer();
            if (getSignedInPlayer() != null) {
                try {
                    DBConnection.updateHighScore(getSignedInPlayer());
                } catch (SQLException e) {
                    Settings.logData("SQLException (updateHighscore in Controller)", e);
                }
            }
            DBConnection.close();
        }));
    }

    public void setGamePanelView(GamePanelView gamePanelView) {
        this.gamePanelView = gamePanelView;
        panelFrameManager.setGamePanelView(gamePanelView);
        gameController = new GameController(gamePanelView, panelFrameManager, this);
        sceneryRandomGenerator.setGameController(gameController);
        panelFrameManager.setGameController(gameController);
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
        panelFrameManager.setStartPanelView(startPanelView);
        // initTimer(); TODO: activate
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
                int connectionStatus = ConnectionTester.checkConnection();
                connectedToServer = connectionStatus == ConnectionTester.CONNECTION_OK;
                if (connectedToServer) {
                    startPanelView.getInternetIconLabel().setInternetEnabledStatus();
                    Settings.logData("Connection ok");
                } else {
                    startPanelView.getInternetIconLabel().setInternetDisabledStatus();
                    Settings.logData("Connection failed");
                }
            }
        }, 5000, 10000);
    }

    private void stopTimer() {
        if (connectionTimer != null) connectionTimer.cancel();
    }

    public void startGame() {
        panelFrameManager.switchToGamePanel();
        gameController.startGame();
        sceneryRandomGenerator.randomGenerate();
        gamePanelView.resetCheatCount();
        gameStarted = true;
        mainFrameView.keysEnabledInGame = true;
    }

    public boolean playerLogin(String userName, String password) throws SQLException {
        signedInPlayer = getPlayerFromList(userName, password);
        if (signedInPlayer != null) {
            localHighScore = signedInPlayer.getHighScore();
            startPanelView.showHighScore();
        }
        return signedInPlayer != null;
    }

    public void playerLogout() {
        if (signedInPlayer != null) {
            try {
                DBConnection.updateHighScore(signedInPlayer);
            } catch (SQLException throwables) {
                Settings.logData("Error updating highscore (logout)", throwables);
            }
        }
        localHighScore = 0;
        lastRoundHighScore = 0;
        signedInPlayer = null;
        try {
            setList(DBConnection.getAllPlayers());
        } catch (SQLException throwables) {
            Settings.logData("Error reading player list from DB (logout)", throwables);
        }
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

    public GameController getGameController() {
        return gameController;
    }

    public MainFrameView getMainFrameView() {
        return mainFrameView;
    }

    public GameRandomGenerator getSceneryRandomGenerator() {
        return sceneryRandomGenerator;
    }

    public void resetGameScore() {
        lastRoundHighScore = 0;
        gamePanelView.resetScoreLabel();
    }

    // update high score in startPanel
    public void updateHighScore() {
        startPanelView.showHighScore();
    }

    public void storeLocalHighscore() {
        if (lastRoundHighScore > localHighScore) localHighScore = lastRoundHighScore;
        if (signedInPlayer != null && signedInPlayer.getHighScore() < localHighScore)
            signedInPlayer.setHighScore(localHighScore);
    }

    // Update score in gamePanel
    public boolean updateHighScoreLabel(int additionalScore) {
        lastRoundHighScore += additionalScore;
        gamePanelView.updateHighScore();
        return lastRoundHighScore >= Settings.SCORE_TO_WIN;
    }

    public int getLocalHighScore() {
        return localHighScore;
    }

    public int getLastRoundHighScore() {
        return lastRoundHighScore;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList.asArrayList();
    }
}
