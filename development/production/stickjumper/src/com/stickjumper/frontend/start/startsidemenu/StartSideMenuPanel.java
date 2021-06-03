package com.stickjumper.frontend.start.startsidemenu;

import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.manager.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartSideMenuPanel extends JPanel implements ActionListener {

    private final ButtonCallback buttonCallback;

    public StartSideMenuPanel(ButtonCallback buttonCallback) {
        super(true);
        setLayout(null);
        setSize(Settings.SCREEN_WIDTH / 6, Settings.SCREEN_HEIGHT);
        setLocation(0, 0);
        setOpaque(true);
        setBackground(new Color(86, 73, 78, 125));

        this.buttonCallback = buttonCallback;

        AdvancedButton settingsButton = new AdvancedButton(Color.GRAY, Color.WHITE);
        settingsButton.setText("Settings");
        settingsButton.setFont(Settings.FONT_BUTTON);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setSize(getWidth() - 10, 30);
        settingsButton.setLocation((getWidth() - settingsButton.getWidth()) / 2,
                (getHeight() - settingsButton.getHeight() * 3));
        settingsButton.setID("settingsButton");
        settingsButton.addActionListener(this);
        add(settingsButton);

        AdvancedButton loginButton = new AdvancedButton(Color.GRAY, Color.WHITE);
        loginButton.setText("Account");
        loginButton.setFont(Settings.FONT_BUTTON);
        loginButton.setForeground(Color.WHITE);
        loginButton.setSize(getWidth() - 10, 30);
        loginButton.setLocation((getWidth() - loginButton.getWidth()) / 2,
                settingsButton.getY() - loginButton.getHeight() - Settings.START_SPACE_BUTTONS);
        loginButton.setID("loginButton");
        loginButton.addActionListener(this);
        add(loginButton);

        AdvancedButton statisticsButton = new AdvancedButton(Color.GRAY, Color.WHITE);
        statisticsButton.setText("Statistics");
        statisticsButton.setFont(Settings.FONT_BUTTON);
        statisticsButton.setForeground(Color.WHITE);
        statisticsButton.setSize(getWidth() - 10, 30);
        statisticsButton.setLocation((getWidth() - statisticsButton.getWidth()) / 2,
                loginButton.getY() - statisticsButton.getHeight() - Settings.START_SPACE_BUTTONS);
        statisticsButton.setID("statisticsButton");
        statisticsButton.addActionListener(this);
        add(statisticsButton);

        AdvancedButton homeButton = new AdvancedButton(ImageManager.GAME_ICON_HOME, ImageManager.START_ICON_HOME);
        homeButton.setSize(32, 32);
        homeButton.setLocation((getWidth() - homeButton.getWidth()) / 2, 10);
        homeButton.setID("homeButton");
        homeButton.addActionListener(this);
        add(homeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "loginButton" -> buttonCallback.onLoginClicked();
            case "statisticsButton" -> buttonCallback.onStatisticsClicked();
            case "settingsButton" -> buttonCallback.onSettingsClicked();
            case "homeButton" -> buttonCallback.onHomeClicked();
        }
    }

    public interface ButtonCallback {

        void onStatisticsClicked();

        void onSettingsClicked();

        void onLoginClicked();

        void onHomeClicked();

    }
}
