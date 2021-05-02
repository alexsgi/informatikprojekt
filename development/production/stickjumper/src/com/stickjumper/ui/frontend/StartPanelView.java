package com.stickjumper.ui.frontend;

import com.stickjumper.ui.frontend.login.LoginFrameView;
import com.stickjumper.ui.frontend.login.LoginPanelView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class StartPanelView extends JPanel {

    private final Font MAIN_FONT = registerFont();
    private int buttonCounter = 0;
    JButton loginButton = new JButton();
    JButton otherButton = new JButton();

    public StartPanelView() {
        setLayout(null);
        JLabel lblTitel = new JLabel("StickJumper");
        lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitel.setBounds(0, 96, 1280, 83);
        lblTitel.setFont(MAIN_FONT);
        add(lblTitel);

        // this button should open up a new frame with a log in function
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setBounds(0, 150, 200, 50);
        loginButton.setVisible(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPanelView loginPanel = new LoginPanelView();
                LoginFrameView loginFrame = new LoginFrameView(loginPanel);
                loginFrame.setVisible(true);
            }
        });
        add(loginButton);


        // the following button was just an experiment in order to try out whether that works with another actionListener
        otherButton.setText("IDK");
        otherButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        otherButton.setBounds(0, 200, 200, 50);
        otherButton.setVisible(true);
        otherButton.setFocusable(false);
        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCounter++;
                otherButton.setText("Counter: " + buttonCounter);
            }
        });
        add(otherButton);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        try {
            URL url = getClass().getResource("/images/start_view/background/mountains-middle.png");
            if (url == null) return;
            Image bgImage = ImageIO.read(url);
            graphicsObject.drawImage(bgImage, 0, 0, null);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

    private Font registerFont() {
        return new Font("Arial Black", Font.PLAIN, 40);
    }

}