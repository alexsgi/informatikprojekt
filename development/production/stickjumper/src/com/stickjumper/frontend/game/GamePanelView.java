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

    public JLabel lblGameOver;
    private Controller controller;
    private AdvancedButton backButton;

    public GamePanelView(Controller controller) {
        super(true);
        setLayout(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setBackground(null);

        this.controller = controller;

        backButton = new AdvancedButton(ImageManager.GAME_ICON_HOME_ACCENT, ImageManager.GAME_ICON_HOME);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "backButton" -> controller.getPanelFrameManager().switchToStartPanel();
        }
    }

    public void addObject(GameElementRender render) {
        add(render);
    }


}
