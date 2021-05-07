package com.stickjumper.ui.frontend;

import com.stickjumper.ui.frontend.login.LoginFrameView;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class StartPanelView extends JPanel {

    private final Font MAIN_FONT = UITools.registerFont();

    private JButton loginButton = new JButton();
    private JButton playButton = new JButton();
    private int buttonCounter = 0;

    public StartPanelView(Controller controller) {
        setLayout(null);
        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        // this button should open up a new frame with a log in function
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setBounds(0, 150, 200, 50);
        loginButton.setVisible(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.disableMainFrame();

                LoginFrameView loginFrame = new LoginFrameView(controller);
                loginFrame.setVisible(true);
            }
        });
        add(loginButton);

        // the following button was just an experiment in order to try out whether that works with another actionListener
        playButton.setText("PLAY");
        playButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        playButton.setBounds(0, 200, 200, 50);
        playButton.setVisible(true);
        playButton.setFocusable(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startGame();
            }
        });
        playButton.setActionCommand("ACTION COMMAND");
        add(playButton);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = UITools.getImage(getClass(), "/images/start_view/background/mountains-middle.png");
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

    public void anpassenText(String neuerText) {
        playButton.setText(neuerText);
    }
}