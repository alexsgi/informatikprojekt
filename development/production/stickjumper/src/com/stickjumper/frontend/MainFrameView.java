package com.stickjumper.frontend;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameView extends JFrame implements KeyListener {

    private StartPanelView startPanel;
    private Controller controller;
    private GamePanelView gamePanel;

    public MainFrameView() {
        // Can't change size of window
        setResizable(false);
        // Title of window
        setTitle("StickJumper");
        // What happens when you click on X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size of window
        setSize(1280, 640);
        // Window in center of screen
        setLocationRelativeTo(null);
        // Set icon
        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));

        controller = new Controller(this);
        addKeyListener(this);
        startPanel = new StartPanelView(controller);
        controller.setStartPanel(startPanel);

        gamePanel = new GamePanelView(controller);

        // Add panel to frame
        setContentPane(startPanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                controller.spacePressed();
                break;
            case KeyEvent.VK_ENTER:
                controller.enterPressed();
                break;
            case KeyEvent.VK_LEFT:
                controller.leftPressed();
                break;
            case KeyEvent.VK_RIGHT:
                controller.rightPressed();
                break;
            case KeyEvent.VK_UP:
                controller.upPressed();
                break;
            case KeyEvent.VK_DOWN:
                controller.downPressed();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setGamePanel() {
        setContentPane(gamePanel);
        controller.setGamePanel(gamePanel);
        revalidate();
    }

    public void addPlayerListToController(List list) {
        controller.setList(list);
    }
}
