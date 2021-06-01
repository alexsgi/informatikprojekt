package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.controller.scenerycontrolling.SceneryController;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanelView extends JPanel implements ActionListener {

    private final Controller controller;
    public JLabel lblGameOver, lblHighScore;

    private int steadyObstaclesCheatCount;

    public GamePanelView(Controller controller) {
        super(true);
        setLayout(null);
        setBackground(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);

        this.controller = controller;

        AdvancedButton backButton = new AdvancedButton(ImageManager.GAME_ICON_HOME_ACCENT, ImageManager.GAME_ICON_HOME);
        backButton.setSize(36, 36);
        backButton.setLocation(5, 5);
        backButton.setID("backButton");
        backButton.addActionListener(this);
        add(backButton);

        lblGameOver = new JLabel("Game over");
        lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameOver.setVerticalAlignment(SwingConstants.CENTER);
        lblGameOver.setSize(getWidth(), getHeight() + 100);
        lblGameOver.setLocation(0, -100);
        lblGameOver.setFont(Settings.FONT_HEADING_GAME_OVER);
        lblGameOver.setOpaque(true);
        lblGameOver.setVisible(false);
        lblGameOver.setBackground(new Color(112, 128, 144, 100));
        lblGameOver.setForeground(Color.WHITE);
        add(lblGameOver);

        backButton = new AdvancedButton(ImageManager.GAME_ICON_HOME_ACCENT, ImageManager.GAME_ICON_HOME);
        backButton.setSize(36, 36);
        backButton.setLocation(5, 105);
        backButton.setID("backButton");
        backButton.addActionListener(this);
        lblGameOver.add(backButton);

        lblHighScore = new JLabel(String.valueOf(controller.getLocalHighScore()));
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setVerticalAlignment(SwingConstants.CENTER);
        lblHighScore.setSize(getWidth(), 50);
        lblHighScore.setLocation(0, 3);
        lblHighScore.setFont(Settings.FONT_HEADING_GAME_HIGHSCORE);
        lblHighScore.setOpaque(false);
        lblHighScore.setForeground(Color.WHITE);
        add(lblHighScore);
        lblHighScore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SceneryController.gameOver) return;
                if (Settings.STEADY_OBSTACLES_LETHAL) {
                    steadyObstaclesCheatCount++;
                    if (steadyObstaclesCheatCount >= 10) {
                        Settings.STEADY_OBSTACLES_LETHAL = false;
                        lblHighScore.setText("Secret cheat code activated");
                    }
                }
            }
        });
    }

    public void updateHighScore() {
        lblHighScore.setText(String.valueOf(controller.getLastRoundHighScore()));
    }

    public void resetScoreLabel() {
        lblHighScore.setText(String.valueOf(controller.getLastRoundHighScore()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("backButton".equals(e.getActionCommand())) controller.getPanelFrameManager().switchToStartPanel();
    }

    public void addObject(GameElementRender render) {
        add(render);
    }

    public void resetCheatCount() {
        steadyObstaclesCheatCount = 0;
    }
}
