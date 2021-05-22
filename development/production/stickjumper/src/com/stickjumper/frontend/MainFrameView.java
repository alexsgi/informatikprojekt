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

public class MainFrameView extends JFrame {

    private StartPanelView startPanel;
    private Controller controller;
    private GamePanelView gamePanel;
    private SceneryRandomGenerator sceneryRandomGenerator;

    public MainFrameView(SceneryRandomGenerator sceneryRandomGenerator) {
        setResizable(false);
        setTitle("StickJumper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setIconImage(ImageManager.APP_ICON_IMAGE);

        controller = new Controller(this, sceneryRandomGenerator);
        startPanel = new StartPanelView(controller);
        controller.setStartPanelView(startPanel);

        gamePanel = new GamePanelView(controller);
        controller.setGamePanelView(gamePanel);

        // Add panel to frame
        // setContentPane(startPanel);
        MovingBackgroundPanel movingBackgroundPanel = new MovingBackgroundPanel();
        movingBackgroundPanel.add(startPanel);
        setContentPane(movingBackgroundPanel);
    }

    public void addPlayerListToController(List list) {
        controller.setList(list);
    }
}
