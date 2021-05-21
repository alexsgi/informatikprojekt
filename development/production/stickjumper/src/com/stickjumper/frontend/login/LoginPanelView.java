package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.JRoundPasswordField;
import com.stickjumper.utils.components.JRoundTextField;
import com.stickjumper.utils.components.LoginLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginPanelView extends JPanel implements ActionListener {

    private Controller controller;
    private LoginFrameView loginFrameView;

    // All buttons
    private AdvancedButton backButton, registerButton, loginButton;
    // private JProgressBar progressBar;

    // All Text fields
    private JRoundTextField userNameTextField;
    private JRoundPasswordField passwordField;

    private JLabel warningLabel;
    private LoginLabel welcomeLabel, signInLabel, userNameLabel, passwordLabel;

    public LoginPanelView(Controller controller, LoginFrameView loginFrameView) {
        super(true);
        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());
        setBackground(Settings.LOGIN_BACKGROUND_COLOR);

        this.controller = controller;
        this.loginFrameView = loginFrameView;

        backButton = new AdvancedButton(ImageManager.ICON_BACK_DARK, ImageManager.ICON_BACK);
        backButton.setSize(32, 32);
        backButton.setLocation(5, 5);
        backButton.setID("backButton");
        backButton.addActionListener(this);
        add(backButton);

        welcomeLabel = new LoginLabel(LoginLabel.HEADER);
        welcomeLabel.setText("Welcome back to StickJumper");
        welcomeLabel.setBounds(0, 20, 600, 50);
        add(welcomeLabel);

        signInLabel = new LoginLabel(LoginLabel.SUBHEADER);
        signInLabel.setText("Sign in to play and compete with other players");
        signInLabel.setSize(getWidth(), 30);
        signInLabel.setLocation(0, welcomeLabel.getY() + welcomeLabel.getHeight() + 5);
        add(signInLabel);

        userNameLabel = new LoginLabel(LoginLabel.TEXT);
        userNameLabel.setText("Username");
        userNameLabel.setSize(getWidth() - 2 * 100, 30);
        userNameLabel.setLocation(getWidth() / 7, signInLabel.getY() + signInLabel.getHeight() + 25);
        add(userNameLabel);

        userNameTextField = new JRoundTextField();
        userNameTextField.setSize(getWidth() - 2 * 100, 30);
        userNameTextField.setLocation(getWidth() / 7, userNameLabel.getY() + userNameLabel.getHeight() + 1);
        add(userNameTextField);

        passwordLabel = new LoginLabel(LoginLabel.TEXT);
        passwordLabel.setText("Password");
        passwordLabel.setSize(getWidth() - 2 * 100, 30);
        passwordLabel.setLocation(getWidth() / 7, userNameTextField.getY() + userNameTextField.getHeight() + 1);
        add(passwordLabel);

        passwordField = new JRoundPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.LEFT);
        passwordField.setSize(getWidth() - 2 * 100, 30);
        passwordField.setLocation(getWidth() / 7, passwordLabel.getY() + passwordLabel.getHeight() + 1);
        add(passwordField);

        warningLabel = new LoginLabel(LoginLabel.WARNING);
        warningLabel.setSize(getWidth(), 30);
        warningLabel.setLocation(0, passwordField.getY() + passwordField.getHeight() + 10);
        add(warningLabel);

        loginButton = new AdvancedButton(null);
        loginButton.setText("Login");
        loginButton.setFont(Settings.FONT_LOGIN_BUTTON);
        loginButton.setSize(150, 40);
        loginButton.setLocation((getWidth() - loginButton.getWidth()) / 2, getHeight() - (int) (loginButton.getHeight() * 3.5));
        loginButton.setID("loginButton");
        loginButton.addActionListener(this);
        add(loginButton);

        registerButton = new AdvancedButton(Color.BLUE, Color.BLACK);
        registerButton.setText("Still not registered? Join the community");
        registerButton.setFont(Settings.FONT_LOGIN_SMALL_BUTTON);
        registerButton.setSize(2 * loginButton.getWidth(), 40);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (registerButton.getHeight() * 2));
        registerButton.setID("registerButton");
        registerButton.addActionListener(this);
        add(registerButton);

        /*
        progressBar.setFocusable(false);
        progressBar.setBackground(null);
        progressBar.setOpaque(true);
        progressBar.setBorderPainted(false);
        progressBar.setFocusable(false);
        progressBar.setBorder(null);
        progressBar.setForeground(null);
        progressBar = new JProgressBar();
        progressBar.setSize(50, 50);
        progressBar.setLocation((getWidth() - progressBar.getWidth()) / 2, 300);
        progressBar.setVisible(true);
        progressBar.setMaximum(100);
        progressBar.setMinimum(0);
        progressBar.setIndeterminate(true);
        add(progressBar);
         */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        warningLabel.setText("");
        switch (e.getActionCommand()) {
            case "backButton" -> controller.getPanelFrameManager().closeLoginFrame();
            case "loginButton" -> {
                String username = userNameTextField.getText(), password;
                char[] passwordArray = passwordField.getPassword();
                if (username == null || username.isEmpty()) {
                    warningLabel.setText("Enter an username");
                    userNameTextField.requestFocus();
                    return;
                }
                if (passwordArray == null || (password = new String(passwordArray)).isEmpty()) {
                    warningLabel.setText("Enter a password");
                    passwordField.requestFocus();
                    return;
                }
                loginButton.setEnabled(false);
                // progressBarRun();
                try {
                    boolean successful = controller.playerLogin(username, password);
                    if (successful) {
                        controller.getPanelFrameManager().enableMainFrame();
                        controller.getPanelFrameManager().closeLoginFrame();
                    } else {
                        warningLabel.setText("False credentials");
                    }
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                loginButton.setEnabled(true);
                // progressBar.setVisible(false);
            }
            case "registerButton" -> controller.getPanelFrameManager().switchToRegisterPanel();
        }
    }

    private void progressBarRun() {
            /*
            progressBar.setVisible(true);
            Timer progressBarTimer = new Timer();
            int progressBarSpeed = 20;
            final int[] x = {0};
            progressBarTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    if (x[0] <= 100) {
                        progressBar.setValue(x[0]);
                        x[0]++;
                    }
                }
            }, 0, progressBarSpeed);
             */
    }
}