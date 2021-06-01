package com.stickjumper.frontend;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.scenerycontrolling.SceneryRandomGenerator;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.rendering.background.MovingBackgroundPanel;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.SettingsPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.StatisticsPanelView;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.ImageManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameView extends JFrame implements KeyListener {

    private final Controller controller;
    public boolean keysEnabledInGame = true;

    public MainFrameView(SceneryRandomGenerator sceneryRandomGenerator) {
        setResizable(false);
        setTitle("StickJumper");
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setIconImage(ImageManager.APP_ICON_IMAGE);

        // StartSideMenuPanel menuPanel = new StartSideMenuPanel();

        controller = new Controller(this, sceneryRandomGenerator);
        StartPanelView startPanel = new StartPanelView(controller);
        controller.setStartPanelView(startPanel);

        controller.getPanelFrameManager().setStatisticsPanel(new StatisticsPanelView());
        controller.getPanelFrameManager().setSettingsPanelView(new SettingsPanelView());

        GamePanelView gamePanel = new GamePanelView(controller);
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
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (controller != null && controller.gameStarted) {
            controller.getSceneryController().keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (controller != null && controller.gameStarted) {
            controller.getSceneryController().keyReleased(e);
        }
    }
}
