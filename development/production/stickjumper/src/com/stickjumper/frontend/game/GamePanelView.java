package com.stickjumper.frontend.game;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;

public class GamePanelView extends JPanel {

    private final Font MAIN_FONT = UITools.registerFont();
    private Controller controller;

    public GamePanelView(Controller controller) {
        this.controller = controller;
        setLayout(null);
        JLabel lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        // Button to start the movement
        JButton startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        startButton.setBounds(0, 150, 200, 50);
        startButton.setVisible(true);
        startButton.setFocusable(false);
        startButton.addActionListener(e -> controller.startMovingBackground());
        add(startButton);

        // Button to stop the movement
        JButton stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        stopButton.setBounds(0, 200, 200, 50);
        stopButton.setVisible(true);
        stopButton.setFocusable(false);
        stopButton.addActionListener(e -> controller.stopMovingBackground());
        add(stopButton);
    }

}
