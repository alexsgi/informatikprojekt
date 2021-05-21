package com.stickjumper.controller;

import com.stickjumper.data.Player;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.data.gameelements.GameCharacter;
import com.stickjumper.data.gameelements.obstacles.Enemy;
import com.stickjumper.data.gameelements.obstacles.SteadyObstacle;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.login.LoginPanelView;
import com.stickjumper.frontend.login.RegisterPanelView;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Controller {

    // Manages open and close operations for frames and panels
    private final PanelFrameManager panelFrameManager;
    // All frames
    private final MainFrameView mainFrameView;
    // Player management
    private Player currentPlayer;
    private List playerList;
    private int currentScore = 0;
    // Display management (temporarily)
    private Scenery scenery;
    // All panels
    private StartPanelView startPanelView;
    private GamePanelView gamePanelView;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
        panelFrameManager = new PanelFrameManager(this, mainFrameView);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
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
                SoundManager.playSound(SoundManager.inputStreamBootSound);
            }
        }));
    }

    public void setGamePanelView(GamePanelView gamePanelView) {
        this.gamePanelView = gamePanelView;
        panelFrameManager.setGamePanelView(gamePanelView);
    }

    public void setLoginFrameView(LoginFrameView loginFrameView) {
        panelFrameManager.setLoginFrameView(loginFrameView);
    }

    public void setStartPanelView(StartPanelView startPanelView) {
        this.startPanelView = startPanelView;
        panelFrameManager.setStartPanelView(startPanelView);
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
        // new scenery (temporarily)
        scenery = new Scenery();
        scenery.initUIObjects();
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

    public class Scenery {

        public Scenery() {
            GameElementRender coinElement = new GameElementRender(new Coin(new Point((Settings.SCREEN_WIDTH - Coin.getStandardDimens().getWidth()) / 2, 200)));
            gamePanelView.addObject(coinElement);
        }

        public void initUIObjects() {
            int h = gamePanelView.getHeight() - 100;
            int w = gamePanelView.getWidth();
            Point position = new Point((w - GameCharacter.width) / 4, h - GameCharacter.height);
            GameCharacter character = (currentPlayer == null) ? new GameCharacter(position, 0) : new GameCharacter(currentPlayer, position);
            GameElementRender playerFigure = new GameElementRender(character);
            gamePanelView.addObject(playerFigure);

            GameElementRender enemy = new GameElementRender(new Enemy(new Point((w - Enemy.getStandardDimens().getWidth()) / 2, h - Enemy.getStandardDimens().getHeight()), 0));
            gamePanelView.addObject(enemy);

            GameElementRender obstacle = new GameElementRender(new SteadyObstacle(new Point((w - SteadyObstacle.getStandardDimens().getWidth()) / 2 + (w - SteadyObstacle.getStandardDimens().getWidth()) / 4, h - SteadyObstacle.getStandardDimens().getHeight())));
            gamePanelView.addObject(obstacle);
        }

    }

}
