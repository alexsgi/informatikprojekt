package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanelView extends JPanel implements ActionListener {

    private Controller controller;
    private MovingBackground movingBackground;

    private AdvancedButton backButton, startButton, stopButton;

    public GamePanelView(Controller controller) {
        super();
        this.controller = controller;
        setLayout(null);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);

        movingBackground = new MovingBackground();
        movingBackground.setVisible(true);
        movingBackground.setSize(2560, 640);
        add(movingBackground);

        JLabel lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, getWidth(), 83);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        movingBackground.add(lblTitle);

        backButton = new AdvancedButton(ImageManager.GAME_ICON_HOME_ACCENT, ImageManager.GAME_ICON_HOME);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(36, 36);
        backButton.setLocation(5, 5);
        backButton.setID("backButton");
        backButton.addActionListener(this);
        movingBackground.add(backButton);

        // Button to start the movement
        startButton = new AdvancedButton(null);
        startButton.setText("Start");
        startButton.setFont(Settings.FONT_BUTTON_PLAIN);
        startButton.setSize(200, 40);
        startButton.setLocation(((getWidth() - startButton.getWidth()) / 2) + (getWidth() - startButton.getWidth()) / 4, getHeight() - startButton.getHeight() * 2);
        startButton.setID("startButton");
        startButton.addActionListener(this);
        movingBackground.add(startButton);

        // Button to stop the movement
        stopButton = new AdvancedButton(null);
        stopButton.setText("Stop");
        stopButton.setFont(Settings.FONT_BUTTON_PLAIN);
        stopButton.setSize(200, 40);
        stopButton.setLocation((getWidth() - stopButton.getWidth()) / 4, getHeight() - stopButton.getHeight() * 2);
        stopButton.setID("stopButton");
        stopButton.addActionListener(this);
        movingBackground.add(stopButton);
    }

    public void startMovingBackground() {
        movingBackground.startMovement();
    }

    public void stopMovingBackground() {
        movingBackground.stopMovement();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "backButton" -> controller.getPanelFrameManager().switchToStartPanel();
            case "startButton" -> controller.startMovingBackground();
            case "stopButton" -> controller.stopMovingBackground();
        }
    }

    public void addObject(GameElementRender render) {
        movingBackground.add(render);
    }
}
