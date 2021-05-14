package com.stickjumper.frontend;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.utils.UITools;

import javax.swing.*;

public class MainFrameView extends JFrame {

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
        startPanel = new StartPanelView(controller);
        controller.setStartPanel(startPanel);

        gamePanel = new GamePanelView(controller);

        // Add panel to frame
        setContentPane(startPanel);
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
