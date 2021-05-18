package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.UITools;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.InternetStateLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class StartPanelView extends JPanel implements ActionListener, MouseListener {

    private JLabel lblHighScore;
    private InternetStateLabel internetIconLabel;
    private Controller controller;

    // All buttons
    private JButton loginButton, settingsButton;
    private AdvancedButton playButton;

    public StartPanelView(Controller controller) {
        setLayout(null);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);

        this.controller = controller;
        StartSideMenuPanel menuPanel = new StartSideMenuPanel(this);
        add(menuPanel);

        internetIconLabel = new InternetStateLabel();
        internetIconLabel.setLocation(getWidth() - internetIconLabel.getWidth() * 2, 5);
        internetIconLabel.setInternetEnabledStatus();
        add(internetIconLabel);

        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        add(lblTitle);

        lblHighScore = new JLabel();
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setBounds(0, 3, getWidth(), 50);
        lblHighScore.setFont(Settings.FONT_LABEL);
        lblHighScore.setText("Highscore: " + controller.new MethodsToSubmitForWednesday().getScoreFromCurrentPlayer());
        add(lblHighScore);

        // Button to open login frame
        loginButton = new AdvancedButton();
        loginButton.setText("Login");
        loginButton.setFont(Settings.FONT_BUTTON);
        loginButton.setForeground(Color.WHITE);
        loginButton.setSize(menuPanel.getWidth() - 10, 40);
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.setLocation((menuPanel.getWidth() - loginButton.getWidth()) / 2, (menuPanel.getHeight() - loginButton.getHeight() * 2 - 80));
        loginButton.setActionCommand("loginButton");
        loginButton.setName("loginButton");
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        menuPanel.add(loginButton);

        settingsButton = new AdvancedButton();
        settingsButton.setText("Settings");
        settingsButton.setFont(Settings.FONT_BUTTON);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setSize(menuPanel.getWidth() - 10, 40);
        settingsButton.setHorizontalAlignment(SwingConstants.CENTER);
        settingsButton.setLocation((menuPanel.getWidth() - loginButton.getWidth()) / 2, (menuPanel.getHeight() - settingsButton.getHeight() * 2));
        settingsButton.setActionCommand("settingsButton");
        settingsButton.setName("settingsButton");
        settingsButton.addActionListener(this);
        settingsButton.addMouseListener(this);
        menuPanel.add(settingsButton);

        playButton = new AdvancedButton();
        playButton.setSize(ImageManager.START_ICON_PLAY.getWidth(), ImageManager.START_ICON_PLAY.getHeight());
        playButton.setLocation((getWidth() - playButton.getWidth()) / 2, (getHeight() - playButton.getHeight()) / 2);
        playButton.setActionCommand("playButton");
        playButton.setName("playButton");
        playButton.addActionListener(this);
        playButton.addMouseListener(this);
        playButton.setIcon(ImageManager.START_ICON_PLAY);
        add(playButton);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "loginButton" -> {
                LoginFrameView loginFrame = new LoginFrameView(controller);
                controller.setLoginFrameView(loginFrame);
                controller.getPanelFrameManager().starterLoginButton();
            }
            case "settingsButton" -> internetIconLabel.flipStatus();
            case "playButton" -> controller.startGame();
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
            case "loginButton" -> loginButton.setForeground(Color.GRAY);
            case "settingsButton" -> settingsButton.setForeground(Color.GRAY);
            case "playButton" -> playButton.setIcon(ImageManager.START_ICON_PLAY_DARK);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "loginButton" -> loginButton.setForeground(Color.WHITE);
            case "settingsButton" -> settingsButton.setForeground(Color.WHITE);
            case "playButton" -> playButton.setIcon(ImageManager.START_ICON_PLAY);
        }
    }
}