package com.stickjumper.ui.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartView extends JPanel{

    private Font AHARONI_FONT = registerFont();
    private int buttonCounter = 0;
    JButton loginButton = new JButton();
    JButton otherButton = new JButton();

    public StartView() {
        setLayout(null);
        JLabel lblTitel = new JLabel("StickJumper");
        lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitel.setBounds(0, 96, 1280, 83);
        lblTitel.setFont(AHARONI_FONT);
        // lblTitel.setFont(lblTitel.getFont().deriveFont(64f));
        add(lblTitel);

        //this button should open up a new frame with a log in function
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setBounds(0, 150, 200, 50);
        loginButton.setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPanelView loginPanel = new LoginPanelView();
                LoginFrameView loginFrame = new LoginFrameView(loginPanel);
                loginFrame.setVisible(true);
            }
        });
        add(loginButton);


        //the following button was just an experiment in order to try out whether that works with another actionListener
        otherButton.setText("IDK");
        otherButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        otherButton.setBounds(0, 200, 200, 50);
        otherButton.setVisible(true);
        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCounter++;
                otherButton.setText("IDK "+buttonCounter);
            }
        });
        add(otherButton);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        Image bgImage;
        try {
            bgImage = ImageIO.read(getClass().getResource("/res/images/mountains-middle.png"));
            graphicsObject.drawImage(bgImage, 0, 0, null);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

    private Font registerFont() {
       /* try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/res/fonts/aharoni.ttf"));

            boolean registerSuccess = GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            if (registerSuccess) {
                System.out.println("Schriftart registriert!");
                return font;
            } else {
                System.err.println("Schriftart konnte nicht registriert werden!");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        } */
       // return  new Font("Comic Sans MS", Font.PLAIN, 30);
        return  new Font("Arial Black", Font.PLAIN, 30);
    }


}