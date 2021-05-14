package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.rendering.MovingBackground;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GamePanelView extends JPanel {

    private final Font MAIN_FONT = UITools.registerFont();
    private Controller controller;
    private MovingBackground movingBackground;

    public GamePanelView(Controller controller) {
        this.controller = controller;
        setLayout(null);
        setSize(1280, 640);

        JLabel lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        JButton homeButton = new JButton();
        homeButton.setHorizontalAlignment(SwingConstants.CENTER);
        homeButton.setSize(36, 36);
        homeButton.setLocation(5, 5);
        homeButton.setFont(new Font("Calibri", Font.PLAIN, 12));
        homeButton.setBackground(null);
        homeButton.setOpaque(false);
        homeButton.setBorderPainted(false);
        homeButton.setFocusable(false);
        homeButton.setBorder(null);
        BufferedImage homeImageDark = UITools.getImage(getClass(), "/images/game_view/icons/home.png");
        BufferedImage homeImageLight = UITools.getImage(getClass(), "/images/game_view/icons/home-light.png");
        if (homeImageDark != null) homeButton.setIcon(new ImageIcon(homeImageDark));
        add(homeButton);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.mainFrameView.setPanelToStartPanel();
            }
        });

        homeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (homeImageLight != null) homeButton.setIcon(new ImageIcon(homeImageLight));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (homeImageDark != null) homeButton.setIcon(new ImageIcon(homeImageDark));
            }
        });

        // Button to start the movement
        JButton startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        startButton.setBounds(0, 150, 200, 50);
        startButton.setVisible(true);
        startButton.setFocusable(false);
        add(startButton);

        // Button to stop the movement
        JButton stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        stopButton.setBounds(0, 200, 200, 50);
        stopButton.setVisible(true);
        stopButton.setFocusable(false);
        add(stopButton);

        movingBackground = new MovingBackground();
        movingBackground.setVisible(true);
        movingBackground.setSize(2560, 640);
        add(movingBackground);

        startButton.addActionListener(e -> controller.startMovingBackground());
        stopButton.addActionListener(e -> controller.stopMovingBackground());
    }

    public void startMovingBackground() {
        movingBackground.startMovement();
    }

    public void stopMovinBackground() {
        movingBackground.stopMovement();
    }

}
