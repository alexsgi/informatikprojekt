package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.variables.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanelView extends JPanel implements ActionListener, MouseListener {

    private Controller controller;
    private MovingBackground movingBackground;

    private JButton startButton, stopButton;
    private AdvancedButton backButton;

    public GamePanelView(Controller controller) {
        this.controller = controller;
        setLayout(null);
        setSize(1280, 640);

        JLabel lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        add(lblTitle);

        backButton = new AdvancedButton();
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(36, 36);
        backButton.setLocation(5, 5);
        backButton.setActionCommand("backButton");
        backButton.setName("backButton");
        backButton.addActionListener(this);
        backButton.addMouseListener(this);
        backButton.setIcon(ImageManager.GAME_ICON_HOME_DARK);
        add(backButton);

        // Button to start the movement
        startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(Settings.FONT_BUTTON_PLAIN);
        startButton.setSize(200, 40);
        startButton.setLocation(((getWidth() - startButton.getWidth()) / 2) + (getWidth() - startButton.getWidth()) / 4, getHeight() - startButton.getHeight() * 2);
        startButton.setFocusable(false);
        startButton.setActionCommand("startButton");
        startButton.setName("startButton");
        startButton.addActionListener(this);
        startButton.addMouseListener(this);
        add(startButton);

        // Button to stop the movement
        stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.setFont(Settings.FONT_BUTTON_PLAIN);
        stopButton.setSize(200, 40);
        stopButton.setLocation((getWidth() - stopButton.getWidth()) / 4, getHeight() - stopButton.getHeight() * 2);
        stopButton.setFocusable(false);
        stopButton.setActionCommand("stopButton");
        stopButton.setName("stopButton");
        stopButton.addActionListener(this);
        stopButton.addMouseListener(this);
        add(stopButton);

        movingBackground = new MovingBackground();
        movingBackground.setVisible(true);
        movingBackground.setSize(2560, 640);
        add(movingBackground);
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
            case "stopButton" -> controller.stopMovingBackground();
            case "startButton" -> controller.startMovingBackground();
            case "backButton" -> controller.getPanelFrameManager().switchToStartPanel();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "backButton":
                backButton.setIcon(ImageManager.GAME_ICON_HOME);
                break;
            case "startButton":
                startButton.setForeground(Color.GRAY);
                break;
            case "stopButton":
                stopButton.setForeground(Color.GRAY);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "backButton":
                backButton.setIcon(ImageManager.GAME_ICON_HOME_DARK);
                break;
            case "startButton":
                startButton.setForeground(Color.BLACK);
                break;
            case "stopButton":
                stopButton.setForeground(Color.BLACK);
                break;
        }
    }
}
