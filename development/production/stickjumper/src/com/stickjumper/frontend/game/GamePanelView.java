package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.Settings;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GamePanelView extends JPanel implements ActionListener, MouseListener {

    private final Font MAIN_FONT = UITools.registerFont();
    private Controller controller;
    private MovingBackground movingBackground;

    private JButton backButton, startButton, stopButton;
    private BufferedImage homeImageDark, homeImageLight;

    public GamePanelView(Controller controller) {
        this.controller = controller;
        setLayout(null);
        setSize(1280, 640);

        JLabel lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        backButton = new JButton();
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(36, 36);
        backButton.setLocation(5, 5);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 12));
        backButton.setBackground(null);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setBorder(null);
        backButton.setActionCommand(Settings.GAME_VIEW_BACK_BUTTON_ACTION_NAME);
        backButton.setName(Settings.GAME_VIEW_BACK_BUTTON_ACTION_NAME);
        homeImageDark = UITools.getImage(getClass(), "/images/game_view/icons/home.png");
        homeImageLight = UITools.getImage(getClass(), "/images/game_view/icons/home-light.png");
        if (homeImageDark != null) backButton.setIcon(new ImageIcon(homeImageDark));
        add(backButton);

        // Button to start the movement
        startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        startButton.setSize(200, 40);
        startButton.setLocation(((getWidth() - startButton.getWidth()) / 2) + (getWidth() - startButton.getWidth()) / 4, getHeight() - startButton.getHeight() * 2);
        startButton.setVisible(true);
        startButton.setFocusable(false);
        startButton.setActionCommand(Settings.GAME_VIEW_START_BUTTON_ACTION_NAME);
        startButton.setName(Settings.GAME_VIEW_START_BUTTON_ACTION_NAME);
        add(startButton);

        // Button to stop the movement
        stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        stopButton.setSize(200, 40);
        stopButton.setLocation((getWidth() - stopButton.getWidth()) / 4, getHeight() - stopButton.getHeight() * 2);
        stopButton.setVisible(true);
        stopButton.setFocusable(false);
        stopButton.setActionCommand(Settings.GAME_VIEW_STOP_BUTTON_ACTION_NAME);
        stopButton.setName(Settings.GAME_VIEW_STOP_BUTTON_ACTION_NAME);
        add(stopButton);

        movingBackground = new MovingBackground();
        movingBackground.setVisible(true);
        movingBackground.setSize(2560, 640);
        add(movingBackground);

        backButton.addActionListener(this);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        backButton.addMouseListener(this);
        startButton.addMouseListener(this);
        stopButton.addMouseListener(this);
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
                if (homeImageLight != null) backButton.setIcon(new ImageIcon(homeImageLight));
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
                if (homeImageDark != null) backButton.setIcon(new ImageIcon(homeImageDark));
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
