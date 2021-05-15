package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.Settings;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.UITools;
import com.stickjumper.utils.components.AdvancedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class StartPanelView extends JPanel implements ActionListener, MouseListener {

    private final Font MAIN_FONT = UITools.registerFont();

    private JLabel lblHighScore;
    private Controller controller;

    // All buttons
    private JButton loginButton, settingsButton;
    private AdvancedButton playButton;

    // images needed
    private BufferedImage playImage = UITools.getImage(getClass(), "/images/start_view/icons/play.png");
    private BufferedImage playImageDark = UITools.getImage(getClass(), "/images/start_view/icons/play-dark.png");

    public StartPanelView(Controller controller) {
        setLayout(null);
        setSize(1280, 640);

        this.controller = controller;
        StartSideMenuPanel menuPanel = new StartSideMenuPanel(this);
        add(menuPanel);

        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        lblHighScore = new JLabel();
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setBounds(0, 3, getWidth(), 50);
        lblHighScore.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblHighScore.setText("Highscore: " + controller.new MethodsToSubmitForWednesday().getScoreFromCurrentPlayer());
        add(lblHighScore);

        // Button to open login frame
        loginButton = new AdvancedButton();
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.BOLD, 17));
        loginButton.setForeground(Color.WHITE);
        loginButton.setSize(menuPanel.getWidth() - 10, 40);
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.setLocation((menuPanel.getWidth() - loginButton.getWidth()) / 2, (menuPanel.getHeight() - loginButton.getHeight() * 2 - 80));
        loginButton.setActionCommand(Settings.START_VIEW_LOGIN_BUTTON_ACTION_NAME);
        loginButton.setName(Settings.START_VIEW_LOGIN_BUTTON_ACTION_NAME);
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        menuPanel.add(loginButton);

        settingsButton = new AdvancedButton();
        settingsButton.setText("Settings");
        settingsButton.setFont(new Font("Calibri", Font.BOLD, 17));
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setSize(menuPanel.getWidth() - 10, 40);
        settingsButton.setHorizontalAlignment(SwingConstants.CENTER);
        settingsButton.setLocation((menuPanel.getWidth() - loginButton.getWidth()) / 2, (menuPanel.getHeight() - settingsButton.getHeight() * 2));
        settingsButton.setActionCommand(Settings.START_VIEW_SETTINGS_BUTTON_ACTION_NAME);
        settingsButton.setName(Settings.START_VIEW_SETTINGS_BUTTON_ACTION_NAME);
        settingsButton.addActionListener(this);
        settingsButton.addMouseListener(this);
        menuPanel.add(settingsButton);

        playButton = new AdvancedButton();
        playButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        playButton.setSize((playImage != null) ? playImage.getWidth() : 64, (playImage != null) ? playImage.getHeight() : 64);
        playButton.setLocation((getWidth() - playButton.getWidth()) / 2, (getHeight() - playButton.getHeight()) / 2);
        playButton.setActionCommand(Settings.START_VIEW_PLAY_BUTTON_ACTION_NAME);
        playButton.setName(Settings.START_VIEW_PLAY_BUTTON_ACTION_NAME);
        playButton.addActionListener(this);
        playButton.addMouseListener(this);
        playButton.setIcon(playImage);
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
            case Settings.START_VIEW_LOGIN_BUTTON_ACTION_NAME:
                LoginFrameView loginFrame = new LoginFrameView(controller);
                controller.setLoginFrameView(loginFrame);
                controller.getPanelFrameManager().starterLoginButton();
                break;
            case Settings.START_VIEW_SETTINGS_BUTTON_ACTION_NAME:
                break;
            case Settings.START_VIEW_PLAY_BUTTON_ACTION_NAME:
                controller.startGame();
                break;
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
            case Settings.START_VIEW_LOGIN_BUTTON_ACTION_NAME:
                loginButton.setForeground(Color.GRAY);
                break;
            case Settings.START_VIEW_SETTINGS_BUTTON_ACTION_NAME:
                settingsButton.setForeground(Color.GRAY);
                break;
            case Settings.START_VIEW_PLAY_BUTTON_ACTION_NAME:
                playButton.setIcon(playImageDark);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case Settings.START_VIEW_LOGIN_BUTTON_ACTION_NAME:
                loginButton.setForeground(Color.WHITE);
                break;
            case Settings.START_VIEW_SETTINGS_BUTTON_ACTION_NAME:
                settingsButton.setForeground(Color.WHITE);
                break;
            case Settings.START_VIEW_PLAY_BUTTON_ACTION_NAME:
                playButton.setIcon(playImage);
                break;
        }
    }
}