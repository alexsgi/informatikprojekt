package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.JRoundPasswordField;
import com.stickjumper.utils.components.JRoundTextField;
import com.stickjumper.utils.components.LoginLabel;
import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.security.PasswordHasher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginPanelView extends JPanel implements ActionListener {

    private final Controller controller;

    private final AdvancedButton loginButton;

    private final JRoundTextField userNameTextField;
    private final JRoundPasswordField passwordField;

    private final LoginLabel warningLabel;

    public LoginPanelView(Controller controller, LoginFrameView loginFrameView) {
        super(true);
        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());
        setBackground(Settings.LOGIN_BACKGROUND_COLOR);

        this.controller = controller;

        // All buttons
        AdvancedButton backButton = new AdvancedButton(ImageManager.ICON_BACK_DARK, ImageManager.ICON_BACK);
        backButton.setSize(32, 32);
        backButton.setLocation(5, 5);
        backButton.setID("backButton");
        backButton.addActionListener(this);
        add(backButton);

        LoginLabel welcomeLabel = new LoginLabel(LoginLabel.HEADER);
        welcomeLabel.setKeyText("login.panel.welcome");
        welcomeLabel.setBounds(0, 20, 600, 50);
        add(welcomeLabel);

        LoginLabel signInLabel = new LoginLabel(LoginLabel.SUBHEADER);
        signInLabel.setKeyText("login.panel.signinheader");
        signInLabel.setSize(getWidth(), 30);
        signInLabel.setLocation(0, welcomeLabel.getY() + welcomeLabel.getHeight() + 5);
        add(signInLabel);

        LoginLabel userNameLabel = new LoginLabel(LoginLabel.TEXT);
        userNameLabel.setKeyText("login.panel.username");
        userNameLabel.setSize(getWidth() - 2 * 100, 30);
        userNameLabel.setLocation(getWidth() / 7, signInLabel.getY() + signInLabel.getHeight() + 25);
        add(userNameLabel);

        userNameTextField = new JRoundTextField();
        userNameTextField.setSize(getWidth() - 2 * 100, 30);
        userNameTextField.setLocation(getWidth() / 7, userNameLabel.getY() + userNameLabel.getHeight() + 1);
        add(userNameTextField);

        LoginLabel passwordLabel = new LoginLabel(LoginLabel.TEXT);
        passwordLabel.setKeyText("login.panel.password");
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

        loginButton = new AdvancedButton();
        loginButton.setKeyText("login.panel.button.login");
        loginButton.setFont(Settings.FONT_LOGIN_BUTTON);
        loginButton.setSize(150, 40);
        loginButton.setLocation((getWidth() - loginButton.getWidth()) / 2, getHeight() - (int) (loginButton.getHeight() * 3.5));
        loginButton.setID("loginButton");
        loginButton.addActionListener(this);
        add(loginButton);

        AdvancedButton registerButton = new AdvancedButton(Color.BLUE, Color.BLACK);
        registerButton.setKeyText("login.panel.button.register");
        registerButton.setFont(Settings.FONT_LOGIN_SMALL_BUTTON);
        registerButton.setSize(getWidth(), 40);
        registerButton.setHorizontalAlignment(SwingConstants.CENTER);
        registerButton.setLocation(0, getHeight() - (registerButton.getHeight() * 2));
        registerButton.setID("registerButton");
        registerButton.addActionListener(this);
        add(registerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        warningLabel.setKeyText(null);
        switch (e.getActionCommand()) {
            case "backButton" -> controller.getPanelFrameManager().closeLoginFrame();
            case "loginButton" -> {
                String username = userNameTextField.getText(), password;
                char[] passwordArray = passwordField.getPassword();
                if (username == null || username.isEmpty()) {
                    warningLabel.setKeyText("login.panel.warning.username");
                    userNameTextField.requestFocus();
                    return;
                }
                if (passwordArray == null || (password = new String(passwordArray)).isEmpty()) {
                    warningLabel.setKeyText("login.panel.warning.password");
                    passwordField.requestFocus();
                    return;
                }
                loginButton.setEnabled(false);

                String hashed = PasswordHasher.hash(password);
                if (hashed == null) {
                    Settings.logData("Error hashing password (login)");
                    System.exit(-1);
                }
                try {
                    boolean successful = controller.playerLogin(username, hashed);
                    passwordField.setText("");
                    if (successful) {
                        userNameTextField.setText("");
                        controller.getPanelFrameManager().enableMainFrame();
                        controller.getPanelFrameManager().closeLoginFrame();
                        controller.getPanelFrameManager().refreshStartGreeting();
                    } else {
                        warningLabel.setKeyText("login.panel.warning.falsecredentials");
                    }
                } catch (SQLException ex) {
                    Settings.logData("SQLException (login)", ex);
                }
                loginButton.setEnabled(true);
            }
            case "registerButton" -> controller.getPanelFrameManager().switchToRegisterPanel();
        }
    }
}