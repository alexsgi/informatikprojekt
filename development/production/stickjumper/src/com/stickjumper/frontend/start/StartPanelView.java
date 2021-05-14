package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartPanelView extends JPanel {

    private final Font MAIN_FONT = UITools.registerFont();

    private final JLabel lblHighScore;

    public StartPanelView(Controller controller) {
        setLayout(null);
        setSize(1280, 640);
        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        StartSideMenuPanel menuPanel = new StartSideMenuPanel(this);
        add(menuPanel);

        lblHighScore = new JLabel();
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setBounds(0, 3, getWidth(), 50);
        lblHighScore.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblHighScore.setText("Highscore: " + controller.new MethodsToSubmitForWednesday().getScoreFromCurrentPlayer());
        add(lblHighScore);

        // Button to open login frame
        JButton loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.BOLD, 17));
        loginButton.setForeground(Color.WHITE);
        loginButton.setSize(menuPanel.getWidth() - 10, 40);
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.setLocation((menuPanel.getWidth() - loginButton.getWidth()) / 2, (menuPanel.getHeight() - loginButton.getHeight() * 2 - 80));
        loginButton.setFocusable(false);
        loginButton.setBackground(null);
        loginButton.setBorder(null);
        loginButton.setOpaque(false);
        loginButton.setBorderPainted(false);
        menuPanel.add(loginButton);

        JButton settingsButton = new JButton();
        settingsButton.setText("Settings");
        settingsButton.setFont(new Font("Calibri", Font.BOLD, 17));
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setSize(menuPanel.getWidth() - 10, 40);
        settingsButton.setHorizontalAlignment(SwingConstants.CENTER);
        settingsButton.setLocation((menuPanel.getWidth() - loginButton.getWidth()) / 2, (menuPanel.getHeight() - settingsButton.getHeight() * 2));
        settingsButton.setFocusable(false);
        settingsButton.setBackground(null);
        settingsButton.setBorder(null);
        settingsButton.setOpaque(false);
        settingsButton.setBorderPainted(false);
        menuPanel.add(settingsButton);

        BufferedImage playImage = UITools.getImage(getClass(), "/images/start_view/icons/play.png");
        BufferedImage playImageDark = UITools.getImage(getClass(), "/images/start_view/icons/play-dark.png");
        JButton playButton = new JButton();
        playButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        playButton.setSize((playImage != null) ? playImage.getWidth() : 64, (playImage != null) ? playImage.getHeight() : 64);
        playButton.setLocation((getWidth() - playButton.getWidth()) / 2, (getHeight() - playButton.getHeight()) / 2);
        playButton.setFocusable(false);
        playButton.setBackground(null);
        playButton.setOpaque(false);
        playButton.setBorderPainted(false);
        playButton.setFocusable(false);
        playButton.setBorder(null);
        if (playImage != null) playButton.setIcon(new ImageIcon(playImage));
        add(playButton);

        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (playImageDark != null) {
                    playButton.setIcon(new ImageIcon(playImageDark));
                } else {
                    playButton.setText("PLAY");
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (playImage != null) {
                    playButton.setIcon(new ImageIcon(playImage));
                } else {
                    playButton.setText("PLAY");
                }
            }

        });

        playButton.addActionListener(e -> controller.startGame());

        loginButton.addActionListener(e -> {
            controller.disableMainFrame();
            LoginFrameView loginFrame = new LoginFrameView(controller);
            loginFrame.setVisible(true);
        });

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setForeground(Color.GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setForeground(Color.WHITE);
            }
        });

        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButton.setForeground(Color.GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButton.setForeground(Color.WHITE);
            }
        });

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