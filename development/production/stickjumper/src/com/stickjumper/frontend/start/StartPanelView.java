package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.InternetStateLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanelView extends JPanel implements ActionListener {

    private final InternetStateLabel internetIconLabel;
    private final Controller controller;

    private final AdvancedButton statisticsButton, loginButton, settingsButton, playButton;
    private final JLabel lblHighScore;
    private final StartSideMenuPanel menuPanel;

    public StartPanelView(Controller controller) {
        super(true);
        setLayout(null);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setOpaque(false);

        this.controller = controller;

        menuPanel = new StartSideMenuPanel(this);
        add(menuPanel);

        internetIconLabel = new InternetStateLabel();
        internetIconLabel.setLocation(getWidth() - internetIconLabel.getWidth() * 2, 5);
        internetIconLabel.setInternetEnabledStatus();
        add(internetIconLabel);

        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        add(lblTitle);

        lblHighScore = new JLabel();
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setBounds(0, 3, getWidth(), 50);
        lblHighScore.setFont(Settings.FONT_LABEL);
        lblHighScore.setText("Highscore: " + controller.getLocalHighScore());
        add(lblHighScore);

        settingsButton = new AdvancedButton(Color.GRAY, Color.WHITE);
        settingsButton.setText("Settings");
        settingsButton.setFont(Settings.FONT_BUTTON);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setSize(menuPanel.getWidth() - 10, 30);
        settingsButton.setLocation((menuPanel.getWidth() - settingsButton.getWidth()) / 2,
                (menuPanel.getHeight() - settingsButton.getHeight() * 3));
        settingsButton.setID("settingsButton");
        settingsButton.addActionListener(this);
        menuPanel.add(settingsButton);

        loginButton = new AdvancedButton(Color.GRAY, Color.WHITE);
        loginButton.setText("Login");
        loginButton.setFont(Settings.FONT_BUTTON);
        loginButton.setForeground(Color.WHITE);
        loginButton.setSize(menuPanel.getWidth() - 10, 30);
        loginButton.setLocation((menuPanel.getWidth() - loginButton.getWidth()) / 2,
                settingsButton.getY() - loginButton.getHeight() - Settings.START_SPACE_BUTTONS);
        loginButton.setID("loginButton");
        loginButton.addActionListener(this);
        menuPanel.add(loginButton);

        statisticsButton = new AdvancedButton(Color.GRAY, Color.WHITE);
        statisticsButton.setText("Statistics");
        statisticsButton.setFont(Settings.FONT_BUTTON);
        statisticsButton.setForeground(Color.WHITE);
        statisticsButton.setSize(menuPanel.getWidth() - 10, 30);
        statisticsButton.setLocation((menuPanel.getWidth() - statisticsButton.getWidth()) / 2,
                loginButton.getY() - statisticsButton.getHeight() - Settings.START_SPACE_BUTTONS);
        statisticsButton.setID("statisticsButton");
        statisticsButton.addActionListener(this);
        menuPanel.add(statisticsButton);

        playButton = new AdvancedButton(ImageManager.START_ICON_PLAY_ACCENT, ImageManager.START_ICON_PLAY);
        playButton.setSize(ImageManager.START_ICON_PLAY.getWidth(), ImageManager.START_ICON_PLAY.getHeight());
        playButton.setLocation((getWidth() - playButton.getWidth()) / 2,
                (getHeight() - playButton.getHeight()) / 2);
        playButton.setID("playButton");
        playButton.addActionListener(this);
        add(playButton);
    }


    public void showHighScore() {
        lblHighScore.setText("Highscore: " + controller.getLocalHighScore());
    }

    public InternetStateLabel getInternetIconLabel() {
        return internetIconLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "loginButton" -> {
                LoginFrameView loginFrame = new LoginFrameView(controller);
                controller.setLoginFrameView(loginFrame);
                controller.getPanelFrameManager().openLoginFrame();
            }
            case "settingsButton" -> internetIconLabel.flipStatus();
            case "playButton" -> controller.startGame();
        }
    }

}