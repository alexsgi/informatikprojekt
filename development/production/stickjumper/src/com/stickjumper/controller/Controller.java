package com.stickjumper.controller;

import com.stickjumper.data.Player;
import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.frontend.start.StartPanelView;

import java.awt.*;
import java.sql.SQLException;

public class Controller {

    private final MainFrameView mainFrameView;
    private final MovingBackground movingBackground = new MovingBackground();
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
        movingBackground.setVisible(true);
        movingBackground.setSize(2560, 640);
        gamePanel.add(movingBackground);
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

    // Keys

    public void spacePressed() {
    }

    public void enterPressed() {
    }

    public void leftPressed() {
        scenery.left(speed);
    }

    public void rightPressed() {
        scenery.right(speed);
    }

    public void upPressed() {
        scenery.up(speed);
    }

    public void downPressed() {
        scenery.down(speed);
    }

    public void startMovingBackground() {
        // start again
        movingBackground.startMovement();
    }

    public void stopMovingBackground() {
        // Game over
        movingBackground.stopMovement();
    }

    public class Scenery {

        // private GameAlgorithm
        // List<Enemy>
        GameElementRender coinElement;

        public Scenery() {
            coinElement = new GameElementRender(new Coin(new Point(600, 200)));
            gamePanel.add(coinElement);
        }

        public void left(int n) {
            coinElement.incrementX(-Math.abs(n));
        }

        public void right(int n) {
            coinElement.incrementX(Math.abs(n));
        }

        public void up(int n) {
            coinElement.incrementY(-Math.abs(n));
        }

        public void down(int n) {
            coinElement.incrementY(Math.abs(n));
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
