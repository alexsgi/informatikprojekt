package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanelView extends JPanel implements ActionListener {

    private Controller controller;

    private AdvancedButton backButton, startButton, stopButton;

    public GamePanelView(Controller controller) {
        super(true);
        setLayout(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        setBackground(null);

        this.controller = controller;

        JLabel lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, getWidth(), 83);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        lblTitle.setOpaque(false);
        add(lblTitle);

        backButton = new AdvancedButton(ImageManager.GAME_ICON_HOME_ACCENT, ImageManager.GAME_ICON_HOME);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(36, 36);
        backButton.setLocation(5, 5);
        backButton.setID("backButton");
        backButton.addActionListener(this);
        add(backButton);

        startButton = new AdvancedButton(null);
        startButton.setText("Right/Start");
        startButton.setSize(200, 40);
        startButton.setLocation(((getWidth() - startButton.getWidth()) / 2) + (getWidth() - startButton.getWidth()) / 4, 0);
        startButton.setID("startButton");
        startButton.addActionListener(this);
        add(startButton);

        stopButton = new AdvancedButton(null);
        stopButton.setText("Left/Stop");
        stopButton.setSize(200, 40);
        stopButton.setLocation((getWidth() - stopButton.getWidth()) / 4, 0);
        stopButton.setID("stopButton");
        stopButton.addActionListener(this);
        add(stopButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "backButton" -> controller.getPanelFrameManager().switchToStartPanel();
            case "startButton" -> {
                // controller.startMovingBackground();
                controller.getSceneryController().moveRight();
            }
            case "stopButton" -> {
                // controller.stopMovingBackground();
                controller.getSceneryController().moveLeft();
            }
        }
    }

    public void addObject(GameElementRender render) {
        add(render);
    }

}
