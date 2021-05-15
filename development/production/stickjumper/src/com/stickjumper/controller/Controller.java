package com.stickjumper.controller;

import com.stickjumper.data.Player;
import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.login.LoginPanelView;
import com.stickjumper.frontend.login.RegisterPanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.frontend.start.StartPanelView;

import java.awt.*;
import java.sql.SQLException;

public class Controller {

    // Manages open and close operations for frames and panels
    private final PanelFrameManager panelFrameManager;
    // Player management
    private Player currentPlayer;
    private List playerList;
    private int currentScore = 0;
    // Display management (temporarily)
    private Scenery scenery;
    // All panels
    private StartPanelView startPanelView;
    private GamePanelView gamePanelView;
    private LoginPanelView loginPanelView;
    private RegisterPanelView registerPanelView;
    // All frames
    private final MainFrameView mainFrameView;
    private LoginFrameView loginFrameView;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
        panelFrameManager = new PanelFrameManager(this, mainFrameView);
    }

    public void setGamePanelView(GamePanelView gamePanelView) {
        this.gamePanelView = gamePanelView;
        panelFrameManager.setGamePanelView(gamePanelView);
    }

    public void setLoginFrameView(LoginFrameView loginFrameView) {
        this.loginFrameView = loginFrameView;
        panelFrameManager.setLoginFrameView(loginFrameView);
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
        panelFrameManager.setStartPanelView(startPanelView);
    }

    public void setLoginPanelView(LoginPanelView loginPanelView) {
        this.loginPanelView = loginPanelView;
        panelFrameManager.setLoginPanelView(loginPanelView);
    }

    public void setRegisterPanelView(RegisterPanelView registerPanelView) {
        this.registerPanelView = registerPanelView;
        panelFrameManager.setRegisterPanelView(registerPanelView);
    }

    public PanelFrameManager getPanelFrameManager() {
        return panelFrameManager;
    }

    public void startGame() {
        panelFrameManager.switchToGamePanel();
        currentScore = -1;
        // new scenery (temporarily)
        scenery = new Scenery();
        scenery.initPlayerUI(gamePanelView);
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
        gamePanelView.startMovingBackground();
    }

    public void stopMovingBackground() {
        gamePanelView.stopMovingBackground();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public class Scenery {

        GameElementRender coinElement;
        GameElementRender playerFigure;

        public Scenery() {
            coinElement = new GameElementRender(new Coin(new Point(600, 200)));
            gamePanelView.add(coinElement);
        }

        public void initPlayerUI(GamePanelView panel) {
            Point position = new Point(50, 50);
            GameCharacter character = (currentPlayer == null) ? new GameCharacter(position, 0) : new GameCharacter(currentPlayer, position);
            playerFigure = new GameElementRender(character);
            gamePanelView.add(playerFigure);
        }

    }

    public class MethodsToSubmitForWednesday {

        public boolean isScoreExisting() {
            return (currentScore != -1);
        }

        public int getScoreFromCurrentPlayer() {
            if (isScoreExisting()) return currentScore;
            return -1;
        }

        public void setScore(int newScore) {
            currentScore = newScore;
        }

        public void updateHighScore() {
            if (currentPlayer.getHighScore() < currentScore) currentPlayer.setHighScore(currentScore);
        }
    }

}
