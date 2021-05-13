package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RegisterPanelView extends JPanel {

    public RegisterPanelView(Controller controller, LoginFrameView loginFrameView) {
        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());

        Color color = new Color(224, 220, 255);
        setBackground(color);

        JButton backButton = new JButton();
        backButton.setText("Back");
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setBounds(5, 0, 200, 30);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 12));
        add(backButton);
        //backButton.setBackground(null);
        //backButton.setOpaque(true);
        //backButton.setBorderPainted(false);
        //backButton.setFocusable(false);
        //backButton.setBorder(null);
        BufferedImage image = UITools.getImage(getClass(), "/images/login_register/back.png");
        if(image != null) {
            System.err.println(image.getWidth() + " x " + image.getHeight());
            ImageIcon icon = new ImageIcon(image);
            backButton.setIcon(icon);
        }

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to StickJumper");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 20, 600, 50);
        welcomeLabel.setFont(new Font("Open Sans", Font.BOLD, 22));
        add(welcomeLabel);

        JLabel signInLabel = new JLabel();
        signInLabel.setText("Create new account to play and compete with other players");
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

        JLabel passwordLabelAgain = new JLabel();
        passwordLabelAgain.setText("Repeat password");
        passwordLabelAgain.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabelAgain.setSize(getWidth() - 2 * 100, 30);
        passwordLabelAgain.setLocation(getWidth() / 7, passwordField.getY() + userNameTextField.getHeight() + 1);
        passwordLabelAgain.setFont(new Font("Open Sans", Font.PLAIN, 13));
        add(passwordLabelAgain);

        JPasswordField passwordFieldAgain = new JPasswordField();
        passwordFieldAgain.setHorizontalAlignment(SwingConstants.LEFT);
        passwordFieldAgain.setSize(getWidth() - 2 * 100, 30);
        passwordFieldAgain.setLocation(getWidth() / 7, passwordLabelAgain.getY() + passwordLabel.getHeight() + 1);
        passwordFieldAgain.setEchoChar('*');
        passwordFieldAgain.setFont(new Font("Open Sans", Font.PLAIN, 13));
        passwordFieldAgain.setToolTipText("Enter your password");
        add(passwordFieldAgain);

        JButton registerButton = new JButton();
        registerButton.setText("Create new account");
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        registerButton.setSize(200, 40);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (int) (registerButton.getHeight() * 3.5));
        registerButton.setFocusable(false);
        add(registerButton);

        /*
        registerButton.addActionListener(e -> {
            registerButton.setEnabled(false);

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
         */

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setForeground(Color.BLUE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setForeground(Color.BLACK);
            }
        });

        backButton.addActionListener(e -> {
            backButton.setEnabled(false);
            loginFrameView.disposeLoginFrame();

        });
    }


}