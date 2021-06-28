package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.AdvancedLabel;
import com.stickjumper.utils.components.InternetStateLabel;
import com.stickjumper.utils.manager.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class StartPanelView extends JPanel {

    private final InternetStateLabel internetIconLabel;
    private final Controller controller;
    private final AdvancedLabel lblHighScore, lblGreeting;

    public StartPanelView(Controller controller) {
        super(true);
        setLayout(null);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setOpaque(false);

        this.controller = controller;

        StartSideMenuPanel menuPanel = new StartSideMenuPanel(new StartSideMenuPanel.ButtonCallback() {
            @Override
            public void onStatisticsClicked() {
                controller.getPanelFrameManager().switchToStatisticsPanel();
            }

            @Override
            public void onSettingsClicked() {
                controller.getPanelFrameManager().switchToSettingsPanel();
            }

            @Override
            public void onLoginClicked() {
                if (controller.getSignedInPlayer() == null) {
                    controller.getPanelFrameManager().openLoginFrame();
                } else {
                    controller.getPanelFrameManager().switchToAccountPanel();
                }
            }

            @Override
            public void onHomeClicked() {
                // Nothing
            }
        });
        add(menuPanel);

        internetIconLabel = new InternetStateLabel();
        internetIconLabel.setLocation(getWidth() - internetIconLabel.getWidth() * 2, 5);
        internetIconLabel.setInternetEnabledStatus();
        internetIconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                internetIconLabel.flipStatus();
            }
        });
        add(internetIconLabel);

        AdvancedLabel lblTitle = new AdvancedLabel();
        lblTitle.setKeyText("app.name");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setSize(400, 83);
        lblTitle.setLocation((getWidth() + menuPanel.getWidth() / 2 - lblTitle.getWidth()) / 2, 96);
        lblTitle.setFont(Settings.FONT_HEADING_BIG_BOLD);
        add(lblTitle);

        lblHighScore = new AdvancedLabel();
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setSize(300, 50);
        lblHighScore.setLocation((getWidth() + menuPanel.getWidth() / 2 - lblHighScore.getWidth()) / 2, 3);
        lblHighScore.setFont(Settings.FONT_LABEL);
        lblHighScore.setKeyText("start.highscore", String.valueOf(controller.getLocalHighScore()));
        add(lblHighScore);

        AdvancedButton playButton = new AdvancedButton(ImageManager.START_ICON_PLAY_ACCENT, ImageManager.START_ICON_PLAY);
        playButton.setSize(ImageManager.START_ICON_PLAY.getWidth(), ImageManager.START_ICON_PLAY.getHeight());
        playButton.setLocation((getWidth() + menuPanel.getWidth() / 2 - playButton.getWidth()) / 2,
                (getHeight() - playButton.getHeight()) / 2);
        playButton.setID("playButton");
        playButton.addActionListener(e -> controller.startGame());
        add(playButton);

        // just for fun
        lblGreeting = new AdvancedLabel();
        lblGreeting.setSize(400, 30);
        lblGreeting.setLocation((getWidth() + menuPanel.getWidth() / 2 - lblGreeting.getWidth()) / 2, 500);
        lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
        lblGreeting.setFont(Settings.FONT_LOGIN_HEADER);
        lblGreeting.setForeground(Color.WHITE);
        add(lblGreeting);
        refreshGreeting();
    }


    public void showHighScore() {
        lblHighScore.setKeyText("start.highscore", String.valueOf(controller.getLocalHighScore()));
    }

    public InternetStateLabel getInternetIconLabel() {
        return internetIconLabel;
    }

    public void refreshGreeting() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            lblGreeting.setKeyText("start.morning");
        } else if (timeOfDay < 16) {
            lblGreeting.setKeyText("start.afternoon");
        } else if (timeOfDay < 21) {
            lblGreeting.setKeyText("start.evening");
        } else {
            lblGreeting.setKeyText("start.night");
        }
        if (controller.getSignedInPlayer() != null)
            lblGreeting.appendValue(", " + controller.getSignedInPlayer().getPlayerName() + ".");
    }
}