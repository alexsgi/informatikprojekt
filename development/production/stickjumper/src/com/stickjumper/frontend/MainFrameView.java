package com.stickjumper.frontend;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.scenerycontrolling.SceneryRandomGenerator;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.background.MovingBackgroundPanel;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameView extends JFrame implements KeyListener {

    public boolean keysEnabledInGame = true;
    private StartPanelView startPanel;
    private Controller controller;
    private GamePanelView gamePanel;
    private SceneryRandomGenerator sceneryRandomGenerator;

    public MainFrameView(SceneryRandomGenerator sceneryRandomGenerator) {
        setResizable(false);
        setTitle("StickJumper");
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setIconImage(ImageManager.APP_ICON_IMAGE);

        controller = new Controller(this, sceneryRandomGenerator);
        startPanel = new StartPanelView(controller);
        controller.setStartPanelView(startPanel);

        gamePanel = new GamePanelView(controller);
        controller.setGamePanelView(gamePanel);

        MovingBackgroundPanel movingBackgroundPanel = new MovingBackgroundPanel();
        movingBackgroundPanel.add(startPanel);
        setContentPane(movingBackgroundPanel);
    }

    public void addPlayerListToController(List list) {
        controller.setList(list);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // why doesn't that work?

        /*
        if (controller != null && !controller.gameStarted && e.getKeyCode() == KeyEvent.VK_SPACE){
            controller.startGame();
        }
        if(controller != null && SceneryController.gameOver && e.getKeyCode() == KeyEvent.VK_SPACE){
            controller.getPanelFrameManager().switchToStartPanel();
        }

         */
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (controller != null && controller.gameStarted && keysEnabledInGame)
            controller.getSceneryController().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
