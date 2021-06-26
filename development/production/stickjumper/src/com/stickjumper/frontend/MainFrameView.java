package com.stickjumper.frontend;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.scenerycontrolling.GameRandomGenerator;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.game.GamePanelView;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.rendering.background.MovingBackgroundPanel;
import com.stickjumper.frontend.start.StartPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.AccountPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.SettingsPanelView;
import com.stickjumper.frontend.start.startsidemenu.submenues.StatisticsPanelView;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedFrame;
import com.stickjumper.utils.security.PasswordHasher;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

public class MainFrameView extends AdvancedFrame implements KeyListener {

    private final Controller controller;
    public boolean keysEnabledInGame = true;

    public MainFrameView(GameRandomGenerator sceneryRandomGenerator, List playerList) {
        super();
        setKeyTitle("app.name");
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setLocationRelativeTo(null);

        controller = new Controller(this, sceneryRandomGenerator);
        StartPanelView startPanel = new StartPanelView(controller);
        controller.setStartPanelView(startPanel);

        LoginFrameView loginFrameView = new LoginFrameView(controller);
        controller.setLoginFrameView(loginFrameView);

        controller.getPanelFrameManager().setStatisticsPanel(new StatisticsPanelView(controller));
        controller.getPanelFrameManager().setSettingsPanelView(new SettingsPanelView(controller));
        controller.getPanelFrameManager().setAccountPanelView(new AccountPanelView(controller));

        GamePanelView gamePanel = new GamePanelView(controller);
        controller.setGamePanelView(gamePanel);

        controller.setList(playerList);

        MovingBackgroundPanel movingBackgroundPanel = new MovingBackgroundPanel();
        movingBackgroundPanel.add(startPanel);
        setContentPane(movingBackgroundPanel);
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

    public void automaticLogin() throws SQLException {
        controller.playerLogin("test", PasswordHasher.hash("test"));
        controller.getPanelFrameManager().refreshStartGreeting();
    }
}
