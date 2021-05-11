package com.stickjumper.controller;

import com.stickjumper.data.Player;
import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.frontend.start.StartPanelView;

import java.awt.*;
import java.util.ArrayList;

public class Controller {

    private StartPanelView startPanel;
    private GamePanelView gamePanel;
    private MainFrameView mainFrameView;
    private Player currentPlayer;
    private ArrayList<Player> playerList;
    private Scenery scenery;
    private MovingBackground movingBackground;

    private int speed = 1;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
    }

    public void setStartPanel(StartPanelView panel) {
        startPanel = panel;
    }

    public void setGamePanel(GamePanelView gamePanel) {
        this.gamePanel = gamePanel;
        scenery = new Scenery();
        movingBackground = new MovingBackground();
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
    }

    public boolean playerLogin(String userName, String password) {
        currentPlayer = getPlayerFromList(userName, password);
        return currentPlayer != null;
    }

    private Player getPlayerFromList(String userName, String password) {
        // return list.searchPlayerInList(String userName, String password) TODO: search-method in List
        return null;
    }

    public void setList(ArrayList<Player> list) {
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

}
