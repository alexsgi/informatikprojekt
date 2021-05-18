package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
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

        movingBackground = new MovingBackground();
        movingBackground.setVisible(true);
        movingBackground.setSize(2560, 640);
        add(movingBackground);

        JLabel lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, getWidth(), 83);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        movingBackground.add(lblTitle);

        backButton = new AdvancedButton();
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(36, 36);
        backButton.setLocation(5, 5);
        backButton.setActionCommand("backButton");
        backButton.setName("backButton");
        backButton.addActionListener(this);
        backButton.addMouseListener(this);
        backButton.setIcon(ImageManager.GAME_ICON_HOME_DARK);
        movingBackground.add(backButton);

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
        movingBackground.add(startButton);

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
            case "stopButton" -> {
                controller.stopMovingBackground();
                /* test if updating high score on DB works
                controller.setScore(500);
                controller.updateHighScore()
                 */
            }
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
            case "backButton" -> backButton.setIcon(ImageManager.GAME_ICON_HOME);
            case "startButton" -> startButton.setForeground(Color.GRAY);
            case "stopButton" -> stopButton.setForeground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "backButton" -> backButton.setIcon(ImageManager.GAME_ICON_HOME_DARK);
            case "startButton" -> startButton.setForeground(Color.BLACK);
            case "stopButton" -> stopButton.setForeground(Color.BLACK);
        }
    }

    public void addObject(GameElementRender render) {
        movingBackground.add(render);
    }
}
