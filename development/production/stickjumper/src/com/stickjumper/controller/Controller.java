package com.stickjumper.controller;

import com.stickjumper.data.Player;
import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.frontend.start.StartPanelView;

import java.awt.*;
import java.sql.SQLException;

public class Controller {

    private final MainFrameView mainFrameView;
    private final int speed = 1;
    private StartPanelView startPanelView;
    private GamePanelView gamePanel;
    private Player currentPlayer;
    private List playerList;
    private Scenery scenery;
    private int currentScore = 0;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
    }

    public void setStartPanel(StartPanelView panel) {
        startPanelView = panel;
    }

    public void setGamePanel(GamePanelView gamePanel) {
        this.gamePanel = gamePanel;
        scenery = new Scenery();
    }

    public void disableMainFrame() {
        mainFrameView.setVisible(false);
    }

    public void enableMainFrame() {
        mainFrameView.setVisible(true);
    }

    public void startGame() {
        mainFrameView.setGamePanel();
        currentScore = -1;
        scenery.initPlayerUI(gamePanel);
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
        gamePanel.startMovingBackground();
    }

    public void stopMovingBackground() {
        gamePanel.stopMovinBackground();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public class Scenery {

        GameElementRender coinElement;
        GameElementRender playerFigure;

        public Scenery() {
            coinElement = new GameElementRender(new Coin(new Point(600, 200)));
            gamePanel.add(coinElement);
        }

        public void initPlayerUI(GamePanelView panel) {
            Point position = new Point(50, 50);
            GameCharacter character = (currentPlayer == null) ? new GameCharacter(position, 0) : new GameCharacter(currentPlayer, position);
            playerFigure = new GameElementRender(character);
            gamePanel.add(playerFigure);
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
