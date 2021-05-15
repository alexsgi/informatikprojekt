package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
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

    private JButton homeButton, startButton, stopButton;
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

        homeButton = new JButton();
        homeButton.setHorizontalAlignment(SwingConstants.CENTER);
        homeButton.setSize(36, 36);
        homeButton.setLocation(5, 5);
        homeButton.setFont(new Font("Calibri", Font.PLAIN, 12));
        homeButton.setBackground(null);
        homeButton.setOpaque(false);
        homeButton.setBorderPainted(false);
        homeButton.setFocusable(false);
        homeButton.setBorder(null);
        homeButton.setActionCommand("HOME");
        homeButton.setName("HOME");
        homeImageDark = UITools.getImage(getClass(), "/images/game_view/icons/home.png");
        homeImageLight = UITools.getImage(getClass(), "/images/game_view/icons/home-light.png");
        if (homeImageDark != null) homeButton.setIcon(new ImageIcon(homeImageDark));
        add(homeButton);

        // Button to start the movement
        startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        startButton.setSize(200, 40);
        startButton.setLocation(((getWidth() - startButton.getWidth()) / 2) + (getWidth() - startButton.getWidth()) / 4, getHeight() - startButton.getHeight() * 2);
        startButton.setVisible(true);
        startButton.setFocusable(false);
        startButton.setActionCommand("START");
        startButton.setName("START");
        add(startButton);

        // Button to stop the movement
        stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        stopButton.setSize(200, 40);
        stopButton.setLocation((getWidth() - stopButton.getWidth()) / 4, getHeight() - stopButton.getHeight() * 2);
        stopButton.setVisible(true);
        stopButton.setFocusable(false);
        stopButton.setActionCommand("STOP");
        stopButton.setName("STOP");
        add(stopButton);

        movingBackground = new MovingBackground();
        movingBackground.setVisible(true);
        movingBackground.setSize(2560, 640);
        add(movingBackground);

        homeButton.addActionListener(this);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        homeButton.addMouseListener(this);
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
            case "STOP" -> controller.stopMovingBackground();
            case "START" -> controller.startMovingBackground();
            case "HOME" -> controller.getPanelFrameManager().switchToStartPanel();
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
            case "HOME":
                if (homeImageLight != null) homeButton.setIcon(new ImageIcon(homeImageLight));
                break;
            case "START":
                startButton.setForeground(Color.GRAY);
                break;
            case "STOP":
                stopButton.setForeground(Color.GRAY);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "HOME":
                if (homeImageDark != null) homeButton.setIcon(new ImageIcon(homeImageDark));
                break;
            case "START":
                startButton.setForeground(Color.BLACK);
                break;
            case "STOP":
                stopButton.setForeground(Color.BLACK);
                break;
        }
    }
}
