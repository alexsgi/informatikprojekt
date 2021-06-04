package com.stickjumper.frontend.start.startsidemenu.submenues;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;

import javax.swing.*;
import java.awt.*;

public class SettingsPanelView extends JPanel {

    private Controller controller;
    private JToggleButton soundEffectToggle, gameOverMusicToggle;

    public SettingsPanelView(Controller controller) {
        super(true);
        setLayout(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);

        this.controller = controller;

        StartSideMenuPanel menuPanel = new StartSideMenuPanel(new StartSideMenuPanel.ButtonCallback() {
            @Override
            public void onStatisticsClicked() {
                controller.getPanelFrameManager().switchToStatisticsPanel();
            }

            @Override
            public void onSettingsClicked() {
                // nothing
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
                controller.getPanelFrameManager().switchToHome();
            }
        });
        add(menuPanel);

        JLabel lblTitle = new JLabel("SETTINGS");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setSize(getWidth(), 50);
        lblTitle.setLocation(0, 20);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        // Notice: visit SoundManager → game over sound depends on sound effects

        JLabel lblSoundEffects = new JLabel("Sound effects");
        lblSoundEffects.setSize(200, 30);
        lblSoundEffects.setLocation(menuPanel.getWidth() + 80, 300);
        lblSoundEffects.setFont(Settings.FONT_LABEL_BOLD_SMALL);
        add(lblSoundEffects);

        soundEffectToggle = new JToggleButton(Settings.SOUND_EFFECTS_ON ? "ON" : "OFF", !Settings.SOUND_EFFECTS_ON);
        soundEffectToggle.setSize(80, lblSoundEffects.getHeight());
        soundEffectToggle.setLocation(lblSoundEffects.getX() + lblSoundEffects.getWidth(), lblSoundEffects.getY());
        soundEffectToggle.setFocusable(false);
        soundEffectToggle.setFont(Settings.FONT_BUTTON_PLAIN_SMALL);
        add(soundEffectToggle);

        JLabel lblGameOverMusic = new JLabel("Game over music");
        lblGameOverMusic.setSize(lblSoundEffects.getWidth(), lblSoundEffects.getHeight());
        lblGameOverMusic.setLocation(lblSoundEffects.getX(), lblSoundEffects.getY() + lblSoundEffects.getHeight() + 30);
        lblGameOverMusic.setFont(Settings.FONT_LABEL_BOLD_SMALL);
        add(lblGameOverMusic);

        gameOverMusicToggle = new JToggleButton(Settings.GAME_OVER_MUSIC_ON ? "ON" : "OFF", !Settings.GAME_OVER_MUSIC_ON);
        gameOverMusicToggle.setSize(soundEffectToggle.getWidth(), soundEffectToggle.getHeight());
        gameOverMusicToggle.setLocation(soundEffectToggle.getX(), lblGameOverMusic.getY());
        gameOverMusicToggle.setFocusable(false);
        gameOverMusicToggle.setFont(Settings.FONT_BUTTON_PLAIN_SMALL);
        gameOverMusicToggle.setEnabled(Settings.SOUND_EFFECTS_ON);
        add(gameOverMusicToggle);

        soundEffectToggle.addChangeListener(e -> {
            if (soundEffectToggle.isSelected()) {
                Settings.SOUND_EFFECTS_ON = false;
                soundEffectToggle.setText("OFF");
                gameOverMusicToggle.setSelected(true);
            } else {
                Settings.SOUND_EFFECTS_ON = true;
                soundEffectToggle.setText("ON");
            }
            gameOverMusicToggle.setEnabled(Settings.SOUND_EFFECTS_ON);
        });

        gameOverMusicToggle.addChangeListener(e -> {
            if (gameOverMusicToggle.isSelected()) {
                Settings.GAME_OVER_MUSIC_ON = false;
                gameOverMusicToggle.setText("OFF");
            } else {
                Settings.GAME_OVER_MUSIC_ON = true;
                gameOverMusicToggle.setText("ON");
            }
        });

    }

}
