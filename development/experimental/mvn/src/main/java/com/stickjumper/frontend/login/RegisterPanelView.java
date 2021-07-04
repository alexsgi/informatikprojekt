package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.JRoundPasswordField;
import com.stickjumper.utils.components.JRoundTextField;
import com.stickjumper.utils.components.LoginLabel;
import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.security.PasswordHasher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterPanelView extends JPanel implements ActionListener {

    private final Controller controller;

    private final AdvancedButton registerButton;
    private final JTextField userNameTextField;
    private final JPasswordField passwordField, passwordFieldControl;
    private final LoginLabel warningLabel;

    public RegisterPanelView(Controller controller, LoginFrameView loginFrameView) {
        super(true);
        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());
        setBackground(Settings.LOGIN_BACKGROUND_COLOR);

        this.controller = controller;

        AdvancedButton backButton = new AdvancedButton(ImageManager.ICON_BACK, ImageManager.ICON_BACK);
        backButton.setSize(32, 32);
        backButton.setLocation(5, 5);
        backButton.setID("backButton");
        backButton.addActionListener(this);
        add(backButton);

        LoginLabel welcomeLabel = new LoginLabel(LoginLabel.HEADER);
        welcomeLabel.setKeyText("login.register.welcome");
        welcomeLabel.setSize(600, 50);
        welcomeLabel.setLocation(0, 20);
        add(welcomeLabel);

        LoginLabel signInLabel = new LoginLabel(LoginLabel.SUBHEADER);
        signInLabel.setKeyText("login.register.joinrequest");
        signInLabel.setSize(getWidth(), 30);
        signInLabel.setLocation(0, welcomeLabel.getY() + welcomeLabel.getHeight() + 5);
        add(signInLabel);

        LoginLabel userNameLabel = new LoginLabel(LoginLabel.TEXT);
        userNameLabel.setKeyText("login.register.username");
        userNameLabel.setSize(getWidth() - 2 * 100, 30);
        userNameLabel.setLocation(getWidth() / 7, signInLabel.getY() + signInLabel.getHeight() + 25);
        add(userNameLabel);

        userNameTextField = new JRoundTextField();
        userNameTextField.setSize(getWidth() - 2 * 100, 30);
        userNameTextField.setLocation(getWidth() / 7, userNameLabel.getY() + userNameLabel.getHeight() + 1);
        add(userNameTextField);

        LoginLabel passwordLabel = new LoginLabel(LoginLabel.TEXT);
        passwordLabel.setKeyText("login.register.password");
        passwordLabel.setSize(getWidth() - 2 * 100, 30);
        passwordLabel.setLocation(getWidth() / 7, userNameTextField.getY() + userNameTextField.getHeight() + 1);
        add(passwordLabel);

        passwordField = new JRoundPasswordField();
        passwordField.setSize(getWidth() - 2 * 100, 30);
        passwordField.setLocation(getWidth() / 7, passwordLabel.getY() + passwordLabel.getHeight() + 1);
        add(passwordField);

        LoginLabel passwordLabelControl = new LoginLabel(LoginLabel.TEXT);
        passwordLabelControl.setKeyText("login.register.repeatpassword");
        passwordLabelControl.setSize(getWidth() - 2 * 100, 30);
        passwordLabelControl.setLocation(getWidth() / 7, passwordField.getY() + userNameTextField.getHeight() + 1);
        add(passwordLabelControl);

        passwordFieldControl = new JRoundPasswordField();
        passwordFieldControl.setSize(getWidth() - 2 * 100, 30);
        passwordFieldControl.setLocation(getWidth() / 7, passwordLabelControl.getY() + passwordLabel.getHeight() + 1);
        add(passwordFieldControl);

        warningLabel = new LoginLabel(LoginLabel.WARNING);
        warningLabel.setSize(getWidth(), 30);
        warningLabel.setLocation(0, passwordFieldControl.getY() + passwordFieldControl.getHeight() + 10);
        add(warningLabel);

        registerButton = new AdvancedButton();
        registerButton.setKeyText("login.register.button.signup");
        registerButton.setFont(Settings.FONT_LOGIN_BUTTON);
        registerButton.setSize(150, 40);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (int) (registerButton.getHeight() * 3.5));
        registerButton.setID("registerButton");
        registerButton.addActionListener(this);
        add(registerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        warningLabel.setKeyText(null);
        switch (e.getActionCommand()) {
            case "registerButton" -> {
                String username = userNameTextField.getText(), password, passwordControl;
                char[] passwordArray = passwordField.getPassword(), passwordControlArray = passwordFieldControl.getPassword();
                if (username == null || username.isEmpty()) {
                    warningLabel.setKeyText("login.register.warning.username");
                    userNameTextField.requestFocus();
                    return;
                }
                if (passwordArray == null || (password = new String(passwordArray)).isEmpty()) {
                    warningLabel.setKeyText("login.register.warning.password");
                    passwordField.requestFocus();
                    return;
                }
                if (passwordControlArray == null || (passwordControl = new String(passwordControlArray)).isEmpty()) {
                    warningLabel.setKeyText("login.register.warning.confirmpassword");
                    passwordFieldControl.requestFocus();
                    return;
                }
                if (!password.equals(passwordControl)) {
                    warningLabel.setKeyText("login.register.warning.nomatchpasswords");
                    return;
                }
                registerButton.setEnabled(false);
                String hashed = PasswordHasher.hash(password);
                if (hashed == null) {
                    Settings.logData("Error hashing password (register)");
                    System.exit(2);
                }
                try {
                    boolean registrationSuccess = DBConnection.registerPlayer(username, hashed);
                    if (!registrationSuccess) {
                        warningLabel.setKeyText("login.register.warning.alreadytaken");
                    } else {
                        // Registration successful
                        userNameTextField.setText("");
                        passwordField.setText("");
                        passwordFieldControl.setText("");
                        controller.setList(DBConnection.getAllPlayers());
                        if (controller.playerLogin(username, hashed)) {
                            controller.getPanelFrameManager().closeLoginFrame();
                            controller.getPanelFrameManager().refreshStartGreeting();
                        } else {
                            // weird error - won't happen
                            Settings.logData("Weird error (register)");
                        }
                    }
                } catch (SQLException throwable) {
                    warningLabel.setKeyText("login.register.warning.inetconnunavailable");
                    Settings.logData("SQLException during register", throwable);
                }
                registerButton.setEnabled(true);
            }
            case "backButton" -> controller.getPanelFrameManager().switchToLoginPanel();
        }
    }
}