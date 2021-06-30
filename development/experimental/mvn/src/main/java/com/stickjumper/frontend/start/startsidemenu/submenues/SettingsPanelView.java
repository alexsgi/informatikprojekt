package com.stickjumper.frontend.start.startsidemenu.submenues;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.Player;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedLabel;
import com.stickjumper.utils.components.AdvancedToggleButton;
import com.stickjumper.utils.manager.StringManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SettingsPanelView extends JPanel {

    private final AdvancedToggleButton soundEffectToggle, gameOverMusicToggle;
    private final Controller controller;
    private final JComboBox<String> comboBoxSkin;
    private final ItemListener itemListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED && controller.getSignedInPlayer() != null) {
                controller.getSignedInPlayer().setSkin(comboBoxSkin.getSelectedIndex());
            }
        }
    };

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

        AdvancedLabel lblTitle = new AdvancedLabel();
        lblTitle.setKeyText("menu.settings.title");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setSize(400, 50);
        lblTitle.setLocation((getWidth() + menuPanel.getWidth() - lblTitle.getWidth()) / 2, 20);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        AdvancedLabel lblSoundEffects = new AdvancedLabel();
        lblSoundEffects.setKeyText("menu.settings.soundeffects");
        lblSoundEffects.setSize(200, 30);
        lblSoundEffects.setLocation(menuPanel.getWidth() + 100, 300);
        lblSoundEffects.setFont(Settings.FONT_LABEL_BOLD_SMALL);
        add(lblSoundEffects);

        soundEffectToggle = new AdvancedToggleButton(!Settings.SOUND_EFFECTS_ON);
        soundEffectToggle.setKeyText(Settings.SOUND_EFFECTS_ON ? "menu.settings.button.on" : "menu.settings.button.off");
        soundEffectToggle.setSize(150, lblSoundEffects.getHeight());
        soundEffectToggle.setLocation(lblSoundEffects.getX() + lblSoundEffects.getWidth(), lblSoundEffects.getY());
        add(soundEffectToggle);

        AdvancedLabel lblGameOverMusic = new AdvancedLabel();
        lblGameOverMusic.setKeyText("menu.settings.gameovermusic");
        lblGameOverMusic.setSize(lblSoundEffects.getWidth(), lblSoundEffects.getHeight());
        lblGameOverMusic.setLocation(lblSoundEffects.getX(), lblSoundEffects.getY() + lblSoundEffects.getHeight() + 30);
        lblGameOverMusic.setFont(Settings.FONT_LABEL_BOLD_SMALL);
        add(lblGameOverMusic);

        gameOverMusicToggle = new AdvancedToggleButton(!Settings.GAME_OVER_MUSIC_ON);
        gameOverMusicToggle.setKeyText(Settings.GAME_OVER_MUSIC_ON ? "menu.settings.button.on" : "menu.settings.button.off");
        gameOverMusicToggle.setSize(soundEffectToggle.getWidth(), soundEffectToggle.getHeight());
        gameOverMusicToggle.setLocation(soundEffectToggle.getX(), lblGameOverMusic.getY());
        gameOverMusicToggle.setEnabled(Settings.SOUND_EFFECTS_ON);
        add(gameOverMusicToggle);

        soundEffectToggle.addChangeListener(e -> {
            if (soundEffectToggle.isSelected()) {
                Settings.SOUND_EFFECTS_ON = false;
                soundEffectToggle.setKeyText("menu.settings.button.off");
                gameOverMusicToggle.setSelected(true);
            } else {
                Settings.SOUND_EFFECTS_ON = true;
                soundEffectToggle.setKeyText("menu.settings.button.on");
            }
            gameOverMusicToggle.setEnabled(Settings.SOUND_EFFECTS_ON);
        });

        gameOverMusicToggle.addChangeListener(e -> {
            if (gameOverMusicToggle.isSelected()) {
                Settings.GAME_OVER_MUSIC_ON = false;
                gameOverMusicToggle.setKeyText("menu.settings.button.off");
            } else {
                Settings.GAME_OVER_MUSIC_ON = true;
                gameOverMusicToggle.setKeyText("menu.settings.button.on");
            }
        });

        AdvancedLabel lblLanguage = new AdvancedLabel();
        lblLanguage.setKeyText("menu.settings.language");
        lblLanguage.setSize(lblSoundEffects.getWidth(), lblSoundEffects.getHeight());
        lblLanguage.setLocation(lblSoundEffects.getX(), lblGameOverMusic.getY() + lblGameOverMusic.getHeight() + 30);
        lblLanguage.setFont(Settings.FONT_LABEL_BOLD_SMALL);
        add(lblLanguage);

        String[] choices = {StringManager.DE.toUpperCase(), StringManager.EN.toUpperCase()};
        JComboBox<String> comboBox = new JComboBox<>(choices);
        comboBox.setSize(gameOverMusicToggle.getWidth(), gameOverMusicToggle.getHeight());
        comboBox.setLocation(gameOverMusicToggle.getX(), gameOverMusicToggle.getY() + gameOverMusicToggle.getHeight() + 30);
        comboBox.setFocusable(false);
        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String language = e.getItem().toString();
                if (language.equalsIgnoreCase(StringManager.DE) || language.equalsIgnoreCase(StringManager.EN)) {
                    StringManager.init(language);
                    StringManager.refreshAllFields();
                    refreshSkins();
                }
            }
        });
        add(comboBox);

        AdvancedLabel lblSkin = new AdvancedLabel();
        lblSkin.setKeyText("menu.settings.skin");
        lblSkin.setSize(lblLanguage.getWidth(), lblLanguage.getHeight());
        lblSkin.setLocation(lblLanguage.getX(), lblLanguage.getY() + lblLanguage.getHeight() + 30);
        lblSkin.setFont(Settings.FONT_LABEL_BOLD_SMALL);
        add(lblSkin);

        comboBoxSkin = new JComboBox<>();
        comboBoxSkin.setSize(gameOverMusicToggle.getWidth(), gameOverMusicToggle.getHeight());
        comboBoxSkin.setLocation(comboBox.getX(), comboBox.getY() + comboBox.getHeight() + 30);
        comboBoxSkin.setFocusable(false);
        comboBoxSkin.addItemListener(itemListener);
        add(comboBoxSkin);
        comboBoxSkin.setVisible(true);

        JLabel lblVersion = new JLabel();
        lblVersion.setText(Settings.APP_VERSION);
        lblVersion.setSize(500, 30);
        lblVersion.setLocation((getWidth() + menuPanel.getWidth() - lblVersion.getWidth()) / 2, getHeight() - lblVersion.getHeight() * 2);
        lblVersion.setFont(Settings.FONT_LABEL_BOLD_SMALL);
        lblVersion.setForeground(Color.WHITE);
        lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblVersion);
    }

    public void refreshSkins() {
        Player player = controller.getSignedInPlayer();
        comboBoxSkin.removeItemListener(itemListener);
        comboBoxSkin.removeAllItems();
        comboBoxSkin.setEditable(false);
        comboBoxSkin.addItem(StringManager.getString("menu.settings.skin1"));
        if (player == null) {
            comboBoxSkin.setEditable(true);
            comboBoxSkin.addItemListener(itemListener);
            return;
        }
        if (player.getHighScore() > 1000) {
            comboBoxSkin.addItem(StringManager.getString("menu.settings.skin2"));
            if (player.getHighScore() > 2000) {
                comboBoxSkin.addItem(StringManager.getString("menu.settings.skin3"));
            }
        }
        comboBoxSkin.setSelectedIndex(player.getSkin());
        if (controller.getSignedInPlayer() != null) {
            controller.getSignedInPlayer().setSkin(comboBoxSkin.getSelectedIndex());
        }
        comboBoxSkin.setEditable(true);
        comboBoxSkin.addItemListener(itemListener);
    }
}
