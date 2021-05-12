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

    private StartPanelView startPanel;
    private GamePanelView gamePanel;
    private final MainFrameView mainFrameView;
    private Player currentPlayer;
    private List playerList;
    private Scenery scenery;
    private final MovingBackground movingBackground = new MovingBackground();
    private int currentScore = 0;

    private final int speed = 1;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;

    }

    public void setStartPanel(StartPanelView panel) {
        startPanel = panel;
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
        startPanel.anpassenText("SPACE");
    }

    public void enterPressed() {
        startPanel.anpassenText("ENTER");
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
<<<<<<< HEAD
            if (isScoreExisting()) return currentScore;
=======
            if (newHighScoreExisting()) return currentPlayer.getHighScore();
>>>>>>> 3bce90e26170096539022649e2c62b88f3210a53
            return 0;
        }

        public void setScore(int newScore) {
<<<<<<< HEAD
            currentScore = newScore;
        }

        public void updateHighScore() {
            if (currentScore > currentPlayer.getHighScore()) currentPlayer.setHighScore(currentScore);
=======
            currentPlayer.setHighScore(newScore);
>>>>>>> 3bce90e26170096539022649e2c62b88f3210a53
        }
    }

}
