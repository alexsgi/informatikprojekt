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

import javax.swing.*;
import java.sql.SQLException;

public class Controller {

    // Manages open and close operations for frames and panels
    private final PanelFrameManager panelFrameManager;
    // Manages all in-game objects
    private SceneryController sceneryController;
    // All frames
    private final MainFrameView mainFrameView;
    // Player management
    private Player currentPlayer;
    private List playerList;
    private int currentScore = 0;
    ;
    // All panels
    private StartPanelView startPanelView;
    private GamePanelView gamePanelView;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
        panelFrameManager = new PanelFrameManager(this, mainFrameView);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (getCurrentPlayer() != null) {
                updateHighScore();
                try {
                    DBConnection.updateHighScore(getCurrentPlayer());
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
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
        // TODO: just a test - DELETE ALL OBJECTS WHEN GOING BACK TO START? - WHEN LOAD ALL OBJECTS?
        sceneryController.initSomeObjects();
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
        panelFrameManager.setStartPanelView(startPanelView);
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

    public void startGame() {
        panelFrameManager.switchToGamePanel();
        currentScore = -1;
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
        getPanelFrameManager().startMovingBackground();
    }

    public void stopMovingBackground() {
        getPanelFrameManager().stopMovingBackground();
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
