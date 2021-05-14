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


    private final int speed = 1;

    // Player management
    private Player currentPlayer;
    private List playerList;
    private int currentScore = 0;

    // Display management (temporarily)
    private Scenery scenery;

    // All frames
    public final MainFrameView mainFrameView;
    private LoginFrameView loginFrameView;

    // All panels
    private StartPanelView startPanelView;
    private GamePanelView gamePanelView;
    private LoginPanelView loginPanelView;
    private RegisterPanelView registerPanelView;

    // Manages open and close operations for frames and panels
    public final PanelAndFrameManager panelAndFrameManager;


    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
        panelAndFrameManager= new PanelAndFrameManager(this, mainFrameView);
    }

    public void setGamePanel(GamePanelView gamePanel) {
        this.gamePanelView = gamePanel;
        panelAndFrameManager.setGamePanelView(gamePanel);

    }

    public void setLoginFrameView(LoginFrameView loginFrameView) {
        this.loginFrameView = loginFrameView;
        panelAndFrameManager.setLoginFrameView(loginFrameView);
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
        panelAndFrameManager.setStartPanelView(startPanelView);
    }

    public void setLoginPanelView(LoginPanelView loginPanelView) {
        this.loginPanelView = loginPanelView;
        panelAndFrameManager.setLoginPanelView(loginPanelView);
    }

    public void setRegisterPanelView(RegisterPanelView registerPanelView) {
        this.registerPanelView = registerPanelView;
        panelAndFrameManager.setRegisterPanelView(registerPanelView);
    }





    public void startGame() {
        panelAndFrameManager.mainFrameSetPanelToGamePanel();
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
        gamePanelView.stopMovinBackground();
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
