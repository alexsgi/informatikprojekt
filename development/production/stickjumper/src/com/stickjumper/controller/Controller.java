package com.stickjumper.controller;

import com.stickjumper.data.Player;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.start.StartPanelView;

import java.util.ArrayList;

public class Controller {

    private StartPanelView startPanel;
    private GamePanelView gamePanel;
    private MainFrameView mainFrameView;
    private Player currentPlayer;
    private ArrayList<Player> playerList;
    // private int currentHighScore = 0; -> AllGameElements
    // Scenery

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
    }

    public void setStartPanel(StartPanelView panel) {
        startPanel = panel;
    }

    public void setGamePanel(GamePanelView gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void spacePressed() {
        startPanel.anpassenText("SPACE");
    }

    public void enterPressed() {
        startPanel.anpassenText("ENTER");
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

    public class Scenery {

        // private GameAlgorithm
        // List<Enemy>

    }

}
