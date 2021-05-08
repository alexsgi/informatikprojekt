package com.stickjumper.ui.frontend;

import com.stickjumper.data.Player;
import com.stickjumper.database.DBConnection;

public class Controller {

    private StartPanelView startPanel;
    private GamePanelView gamePanel;
    private MainFrameView mainFrameView;

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

    public Player playerLogin(String userName, String password){
        return DBConnection.playerLogin(userName, password);

    }

}
