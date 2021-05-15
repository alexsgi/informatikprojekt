package com.stickjumper.frontend.start;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.login.LoginFrameView;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StartPanelView extends JPanel implements ActionListener {

    private final Font MAIN_FONT = UITools.registerFont();

    private final JLabel lblHighScore;
    private Controller controller;

    // All buttons
    private JButton loginButton = new JButton();
    private JButton settingsButton = new JButton();
    private JButton playButton = new JButton();

    // images needed
    private BufferedImage playImage = UITools.getImage(getClass(), "/images/start_view/icons/play.png");
    private BufferedImage playImageDark = UITools.getImage(getClass(), "/images/start_view/icons/play-dark.png");

    public StartPanelView(Controller controller) {
        setLayout(null);
        setSize(1280, 640);
        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        this.controller = controller;

        StartSideMenuPanel menuPanel = new StartSideMenuPanel(this);
        add(menuPanel);

        lblHighScore = new JLabel();
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setBounds(0, 3, getWidth(), 50);
        lblHighScore.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblHighScore.setText("Highscore: " + controller.new MethodsToSubmitForWednesday().getScoreFromCurrentPlayer());
        add(lblHighScore);

        // Button to open login frame
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
        loginButton.setActionCommand("loginButton");
        loginButton.addActionListener(this);
        menuPanel.add(loginButton);


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
        settingsButton.addActionListener(this);
        settingsButton.setActionCommand("settingsButton");
        menuPanel.add(settingsButton);


        playButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        playButton.setSize((playImage != null) ? playImage.getWidth() : 64, (playImage != null) ? playImage.getHeight() : 64);
        playButton.setLocation((getWidth() - playButton.getWidth()) / 2, (getHeight() - playButton.getHeight()) / 2);
        playButton.setFocusable(false);
        playButton.setBackground(null);
        playButton.setOpaque(false);
        playButton.setBorderPainted(false);
        playButton.setFocusable(false);
        playButton.setBorder(null);
        playButton.addActionListener(this);
        playButton.setActionCommand("playButton");
        if (playImage != null) playButton.setIcon(new ImageIcon(playImage));
        add(playButton);


        // adds all feedbacks when moving the mouse over the buttons
        addAllMouseListeners();
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

        switch (e.getActionCommand()){
            case "loginButton":
                LoginFrameView loginFrame = new LoginFrameView(controller);
                controller.setLoginFrameView(loginFrame);
                controller.panelFrameManager.starterLoginButton();
                break;
            case "settingsButton":

                break;

            case "playButton":
                            /*
                    if (controller.getCurrentPlayer() != null) {
                      controller.startGame();
                     } else {
                      JOptionPane.showMessageDialog(null, "Please sign in to play");
                     }
                             */
                controller.startGame();
                break;


        }

    }

    public void addAllMouseListeners(){
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

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (playImageDark != null) playButton.setIcon(new ImageIcon(playImageDark));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (playImage != null) playButton.setIcon(new ImageIcon(playImage));
            }
        });

    }
}