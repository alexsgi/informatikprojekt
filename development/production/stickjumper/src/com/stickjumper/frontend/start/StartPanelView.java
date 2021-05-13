package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.start.menu.MenuPanel;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartPanelView extends JPanel {

    private final Font MAIN_FONT = UITools.registerFont();

    private JLabel lblHighScore;

    public StartPanelView(Controller controller) {
        setLayout(null);
        setSize(1280, 640);
        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        MenuPanel menuPanel = new MenuPanel(this);

        lblHighScore = new JLabel();
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setBounds(0, 3, getWidth(), 50);
        lblHighScore.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblHighScore.setText("Highscore: " + controller.new MethodsToSubmitForWednesday().getScoreFromCurrentPlayer());
        add(lblHighScore);

        // Button to open login frame
        JButton loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setSize(menuPanel.getWidth(), 30);
        loginButton.setHorizontalAlignment(SwingConstants.LEFT);
        loginButton.setLocation(0, (menuPanel.getHeight() - loginButton.getHeight()) / 2);
        loginButton.setFocusable(false);
        loginButton.addActionListener(e -> {
            controller.disableMainFrame();
            LoginFrameView loginFrame = new LoginFrameView(controller);
            loginFrame.setVisible(true);
        });
        menuPanel.add(loginButton);

        BufferedImage image = UITools.getImage(getClass(), "/images/start_view/icons/play.png");
        JButton playButton = new JButton();
        playButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        playButton.setSize((image != null) ? image.getWidth() : 64, (image != null) ? image.getHeight() : 64);
        playButton.setLocation((getWidth() - playButton.getWidth()) / 2, (getHeight() - playButton.getHeight()) / 2);
        playButton.setFocusable(false);
        playButton.addActionListener(e -> controller.startGame());
        add(playButton);
        playButton.setBackground(null);
        playButton.setOpaque(false);
        playButton.setBorderPainted(false);
        playButton.setFocusable(false);
        playButton.setBorder(null);
        if (image != null) {
            ImageIcon icon = new ImageIcon(image);
            playButton.setIcon(icon);
        } else {
            playButton.setText("PLAY");
        }

        add(menuPanel);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = UITools.getImage(getClass(), "/images/start_view/background/mountains-middle.png");
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

    public void showHighScore(int highScore) {
        lblHighScore.setText("Highscore: " + highScore);
    }
}