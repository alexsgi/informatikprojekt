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
        welcomeLabel.setText("Welcome to StickJumper");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 20, 600, 50);
        welcomeLabel.setFont(new Font("Open Sans", Font.BOLD, 22));
        add(welcomeLabel);

        JLabel signInLabel = new JLabel();
        signInLabel.setText("Sign in to play and compete with other players");
        signInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signInLabel.setSize(getWidth(), 30);
        signInLabel.setLocation(0, welcomeLabel.getY() + welcomeLabel.getHeight() + 5);
        signInLabel.setFont(new Font("Open Sans", Font.PLAIN, 14));
        add(signInLabel);

        JLabel userNameLabel = new JLabel();
        userNameLabel.setText("Username");
        userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        userNameLabel.setSize(getWidth() - 2 * 100, 30);
        userNameLabel.setLocation(getWidth() / 7, signInLabel.getY() + signInLabel.getHeight() + 25);
        userNameLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        add(userNameLabel);

        JTextField userNameTextField = new JTextField();
        userNameTextField.setSize(getWidth() - 2 * 100, 30);
        userNameTextField.setLocation(getWidth() / 7, userNameLabel.getY() + userNameLabel.getHeight() + 1);
        userNameTextField.setFont(new Font("Open Sans", Font.PLAIN, 13));
        userNameTextField.setToolTipText("Enter your username");
        add(userNameTextField);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabel.setSize(getWidth() - 2 * 100, 30);
        passwordLabel.setLocation(getWidth() / 7, userNameTextField.getY() + userNameTextField.getHeight() + 1);
        passwordLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.LEFT);
        passwordField.setSize(getWidth() - 2 * 100, 30);
        passwordField.setLocation(getWidth() / 7, passwordLabel.getY() + passwordLabel.getHeight() + 1);
        passwordField.setEchoChar('*');
        passwordField.setFont(new Font("Open Sans", Font.PLAIN, 13));
        passwordField.setToolTipText("Enter your password");
        add(passwordField);

        JButton loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setSize(200, 40);
        //loginButton.setLocation((getWidth() - loginButton.getWidth()) / 8, getHeight() - loginButton.getHeight() * 2);
        loginButton.setLocation((getWidth() - loginButton.getWidth()) / 2, getHeight() - (int) (loginButton.getHeight() * 3.5));
        loginButton.setFocusable(false);
        add(loginButton);

        JButton registerButton = new JButton();
        registerButton.setText("Still not registered? Join the community");
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        registerButton.setSize(2 * loginButton.getWidth(), 40);
        // registerButton.setLocation((getWidth() / 2) + ((getWidth() / 2 - registerButton.getWidth()) / 2), getHeight() - registerButton.getHeight() * 2);
        // mathematically simplified
        // registerButton.setLocation((int) (0.75 * getWidth() - 0.5 * registerButton.getWidth()), getHeight() - registerButton.getHeight() * 2);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (registerButton.getHeight() * 2));
        registerButton.setFocusable(false);
        registerButton.setBackground(null);
        registerButton.setBorder(null);
        add(registerButton);

        loginButton.addActionListener(e -> {
            loginButton.setEnabled(false);

            String username = userNameTextField.getText(), password;
            char[] passwordArray = passwordField.getPassword();
            if (passwordArray != null && !(password = new String(passwordArray)).equals("null") && !password.isEmpty() && username != null && !username.isEmpty()) {
                try {
                    // Test with username = Jan Marsalek & password = dasisteinpasswort
                    boolean successful = controller.playerLogin(username, password);
                    if (successful) {
                        controller.enableMainFrame();
                        loginFrameView.disposeLoginFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, "False credentials, try again");
                    }

                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Enter your credentials");
            }
            loginButton.setEnabled(true);
        });

        registerButton.addActionListener(e -> {
            // user wants to register
            System.out.println("open register panel/frame");
        });

        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButton.setForeground(Color.BLUE);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButton.setForeground(Color.BLACK);
            }
        });
    }


}