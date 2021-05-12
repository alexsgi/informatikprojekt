package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginPanelView extends JPanel {

    public LoginPanelView(Controller controller, LoginFrameView loginFrameView) {
        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to our service");
        add(welcomeLabel);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 20, 600, 50);
        welcomeLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));

        JButton loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setSize(200, 50);
        loginButton.setLocation((getWidth() - loginButton.getWidth()) / 4, getHeight() - loginButton.getHeight() * 2);
        loginButton.setVisible(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(e -> {
            loginButton.setEnabled(false);
            try {
                boolean successful = controller.playerLogin("Jan Marsalek", "dasisteinpasswort");
                if (successful) {
                    controller.enableMainFrame();
                    loginFrameView.disposeLoginFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "False credentials, try again");
                    loginButton.setEnabled(true);
                }

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        });
        add(loginButton);

        JButton registerButton = new JButton();
        registerButton.setText("Register");
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        registerButton.setSize(200, 50);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2 + (getWidth() - registerButton.getWidth()) / 4, getHeight() - registerButton.getHeight() * 2);
        registerButton.setVisible(true);
        registerButton.setFocusable(false);
        add(registerButton);
    }


}