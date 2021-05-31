package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanelView extends JPanel implements ActionListener {

    private final Controller controller;
    public JLabel lblGameOver, lblHighScore;
    public int highScore = 0;

    public GamePanelView(Controller controller) {
        super(true);
        setLayout(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setBackground(null);

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

        lblHighScore = new JLabel(String.valueOf(highScore));
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setVerticalAlignment(SwingConstants.CENTER);
        lblHighScore.setSize(getWidth(), 50);
        lblHighScore.setLocation(0, 3);
        lblHighScore.setFont(Settings.FONT_HEADING_GAME_HIGHSCORE);
        lblHighScore.setOpaque(false);
        lblHighScore.setForeground(Color.WHITE);
        add(lblHighScore);
    }

    public void updateHighScore(int additionScore) {
        highScore += additionScore;
        lblHighScore.setText(String.valueOf(highScore));
    }

    public void resetHighScore() {
        highScore = 0;
        lblHighScore.setText(String.valueOf(highScore));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("backButton".equals(e.getActionCommand())) controller.getPanelFrameManager().switchToStartPanel();
    }

    public void addObject(GameElementRender render) {
        add(render);
    }

}
