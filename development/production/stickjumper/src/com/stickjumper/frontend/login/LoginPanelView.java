package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.Settings;
import com.stickjumper.utils.UITools;
import com.stickjumper.utils.components.JRoundPasswordField;
import com.stickjumper.utils.components.JRoundTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

public class LoginPanelView extends JPanel implements ActionListener {

    Controller controller;
    LoginFrameView loginFrameView;

    // All buttons
    JButton backButton = new JButton();
    JButton loginButton = new JButton();
    JButton registerButton = new JButton();

    // All Text fields
    JTextField userNameTextField;
    JPasswordField passwordField;

    public LoginPanelView(Controller controller, LoginFrameView loginFrameView) {
        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());

        this.controller = controller;
        this.loginFrameView = loginFrameView;

        Color color = new Color(224, 255, 255);
        setBackground(color);

        BufferedImage backImage = UITools.getImage(getClass(), "/images/login_register/back.png");
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(32, 32);
        backButton.setLocation(5, 5);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 12));
        backButton.setBackground(null);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setBorder(null);
        backButton.setActionCommand("backButton");
        backButton.addActionListener(this);
        if (backImage != null) backButton.setIcon(new ImageIcon(backImage));
        add(backButton);

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome back to StickJumper");
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

        userNameTextField = new JRoundTextField(Settings.LOGIN_TEXTFIELD_CORNER_RADIUS);
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

        passwordField = new JRoundPasswordField(Settings.LOGIN_TEXTFIELD_CORNER_RADIUS);
        passwordField.setHorizontalAlignment(SwingConstants.LEFT);
        passwordField.setSize(getWidth() - 2 * 100, 30);
        passwordField.setLocation(getWidth() / 7, passwordLabel.getY() + passwordLabel.getHeight() + 1);
        passwordField.setEchoChar('*');
        passwordField.setFont(new Font("Open Sans", Font.PLAIN, 13));
        passwordField.setToolTipText("Enter your password");
        add(passwordField);


        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setSize(150, 40);
        loginButton.setLocation((getWidth() - loginButton.getWidth()) / 2, getHeight() - (int) (loginButton.getHeight() * 3.5));
        loginButton.setFocusable(false);
        loginButton.setActionCommand("loginButton");
        loginButton.addActionListener(this);
        add(loginButton);

        registerButton.setText("Still not registered? Join the community");
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        registerButton.setSize(2 * loginButton.getWidth(), 40);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (registerButton.getHeight() * 2));
        registerButton.setBackground(null);
        registerButton.setOpaque(true);
        registerButton.setBorderPainted(false);
        registerButton.setFocusable(false);
        registerButton.setBorder(null);
        registerButton.setActionCommand("registerButton");
        registerButton.addActionListener(this);
        add(registerButton);

        addAllMouseListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "backButton":
                backButton.setEnabled(false);
                controller.getPanelFrameManager().loginFrameClose();
                break;

            case "loginButton":
                loginButton.setEnabled(false);

                String username = userNameTextField.getText(), password;
                char[] passwordArray = passwordField.getPassword();
                if (passwordArray != null && !(password = new String(passwordArray)).equals("null") && !password.isEmpty() && username != null && !username.isEmpty()) {
                    try {
                        // Test with username = Jan Marsalek & password = dasisteinpasswort
                        boolean successful = controller.playerLogin(username, password);
                        if (successful) {
                            controller.getPanelFrameManager().enableMainFrame();
                            controller.getPanelFrameManager().loginFrameClose();
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
                break;

            case "registerButton":
                controller.getPanelFrameManager().loginPanelToRegisterPanel();
                break;


        }
    }

    private void addAllMouseListeners() {
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButton.setForeground(Color.BLUE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButton.setForeground(Color.BLACK);
            }
        });

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setForeground(Color.BLUE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setForeground(Color.BLACK);
            }
        });

    }

}