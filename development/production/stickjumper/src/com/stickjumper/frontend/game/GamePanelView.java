package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.Settings;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.utils.components.AdvancedButton;

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
        backButton.setActionCommand(Settings.GAME_VIEW_BACK_BUTTON_ACTION_NAME);
        backButton.setName(Settings.GAME_VIEW_BACK_BUTTON_ACTION_NAME);
        backButton.addActionListener(this);
        backButton.addMouseListener(this);
        backButton.setIcon(Settings.GAME_ICON_HOME_DARK);
        add(backButton);

        // Button to start the movement
        startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(Settings.FONT_BUTTON_PLAIN);
        startButton.setSize(200, 40);
        startButton.setLocation(((getWidth() - startButton.getWidth()) / 2) + (getWidth() - startButton.getWidth()) / 4, getHeight() - startButton.getHeight() * 2);
        startButton.setFocusable(false);
        startButton.setActionCommand(Settings.GAME_VIEW_START_BUTTON_ACTION_NAME);
        startButton.setName(Settings.GAME_VIEW_START_BUTTON_ACTION_NAME);
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
        stopButton.setActionCommand(Settings.GAME_VIEW_STOP_BUTTON_ACTION_NAME);
        stopButton.setName(Settings.GAME_VIEW_STOP_BUTTON_ACTION_NAME);
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
            case Settings.GAME_VIEW_STOP_BUTTON_ACTION_NAME -> controller.stopMovingBackground();
            case Settings.GAME_VIEW_START_BUTTON_ACTION_NAME -> controller.startMovingBackground();
            case Settings.GAME_VIEW_BACK_BUTTON_ACTION_NAME -> controller.getPanelFrameManager().switchToStartPanel();
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
            case Settings.GAME_VIEW_BACK_BUTTON_ACTION_NAME:
                backButton.setIcon(Settings.GAME_ICON_HOME);
                break;
            case Settings.GAME_VIEW_START_BUTTON_ACTION_NAME:
                startButton.setForeground(Color.GRAY);
                break;
            case Settings.GAME_VIEW_STOP_BUTTON_ACTION_NAME:
                stopButton.setForeground(Color.GRAY);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case Settings.GAME_VIEW_BACK_BUTTON_ACTION_NAME:
                backButton.setIcon(Settings.GAME_ICON_HOME_DARK);
                break;
            case Settings.GAME_VIEW_START_BUTTON_ACTION_NAME:
                startButton.setForeground(Color.BLACK);
                break;
            case Settings.GAME_VIEW_STOP_BUTTON_ACTION_NAME:
                stopButton.setForeground(Color.BLACK);
                break;
        }
    }
}
