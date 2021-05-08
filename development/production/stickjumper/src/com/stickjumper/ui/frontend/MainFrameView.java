package com.stickjumper.ui.frontend;

import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameView extends JFrame implements KeyListener {

    private StartPanelView startPanel;
    private Controller controller;
    private GamePanelView gamePanel = new GamePanelView();

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
}
