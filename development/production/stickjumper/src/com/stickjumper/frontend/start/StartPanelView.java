package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.InternetStateLabel;
import com.stickjumper.utils.manager.ImageManager;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartPanelView extends JPanel {

    private final InternetStateLabel internetIconLabel;
    private final Controller controller;
    private final JLabel lblHighScore;

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
                // nothing
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

        JLabel lblTitle = new JLabel(Settings.APP_NAME);
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

        AdvancedButton playButton = new AdvancedButton(ImageManager.START_ICON_PLAY_ACCENT, ImageManager.START_ICON_PLAY);
        playButton.setSize(ImageManager.START_ICON_PLAY.getWidth(), ImageManager.START_ICON_PLAY.getHeight());
        playButton.setLocation((getWidth() - playButton.getWidth()) / 2,
                (getHeight() - playButton.getHeight()) / 2);
        playButton.setID("playButton");
        playButton.addActionListener(e -> controller.startGame());
        add(playButton);
    }


    public void showHighScore() {
        lblHighScore.setText("Highscore: " + controller.getLocalHighScore());
    }

    public InternetStateLabel getInternetIconLabel() {
        return internetIconLabel;
    }

}