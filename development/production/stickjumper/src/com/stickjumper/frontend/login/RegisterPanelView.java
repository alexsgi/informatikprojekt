package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.JRoundPasswordField;
import com.stickjumper.utils.components.JRoundTextField;
import com.stickjumper.utils.components.LoginLabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterPanelView extends JPanel implements ActionListener {

    private Controller controller;
    private LoginFrameView loginFrameView;

    // All buttons
    private AdvancedButton backButton, registerButton;

    // All Text fields
    private JTextField userNameTextField;
    private JPasswordField passwordField, passwordFieldControl;
    private JLabel warningLabel;
    private LoginLabel welcomeLabel, signInLabel, userNameLabel, passwordLabel, passwordLabelControl;

    public RegisterPanelView(Controller controller, LoginFrameView loginFrameView) {
        super();
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
        welcomeLabel.setText("Welcome to StickJumper");
        welcomeLabel.setSize(600, 50);
        welcomeLabel.setLocation(0, 20);
        add(welcomeLabel);

        signInLabel = new LoginLabel(LoginLabel.SUBHEADER);
        signInLabel.setText("Join the community by creating an account");
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
        userNameTextField.setToolTipText("Enter your username");
        add(userNameTextField);

        passwordLabel = new LoginLabel(LoginLabel.TEXT);
        passwordLabel.setText("Password");
        passwordLabel.setSize(getWidth() - 2 * 100, 30);
        passwordLabel.setLocation(getWidth() / 7, userNameTextField.getY() + userNameTextField.getHeight() + 1);
        add(passwordLabel);

        passwordField = new JRoundPasswordField();
        passwordField.setSize(getWidth() - 2 * 100, 30);
        passwordField.setLocation(getWidth() / 7, passwordLabel.getY() + passwordLabel.getHeight() + 1);
        passwordField.setToolTipText("Enter your password");
        add(passwordField);

        passwordLabelControl = new LoginLabel(LoginLabel.TEXT);
        passwordLabelControl.setText("Repeat password");
        passwordLabelControl.setSize(getWidth() - 2 * 100, 30);
        passwordLabelControl.setLocation(getWidth() / 7, passwordField.getY() + userNameTextField.getHeight() + 1);
        add(passwordLabelControl);

        passwordFieldControl = new JRoundPasswordField();
        passwordFieldControl.setSize(getWidth() - 2 * 100, 30);
        passwordFieldControl.setLocation(getWidth() / 7, passwordLabelControl.getY() + passwordLabel.getHeight() + 1);
        passwordFieldControl.setToolTipText("Enter your password");
        add(passwordFieldControl);

        warningLabel = new LoginLabel(LoginLabel.WARNING);
        warningLabel.setSize(getWidth(), 30);
        warningLabel.setLocation(0, passwordFieldControl.getY() + passwordFieldControl.getHeight() + 10);
        add(warningLabel);

        registerButton = new AdvancedButton(null);
        registerButton.setText("Sign up");
        registerButton.setFont(Settings.FONT_LOGIN_BUTTON);
        registerButton.setSize(150, 40);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (int) (registerButton.getHeight() * 3.5));
        registerButton.setID("registerButton");
        registerButton.addActionListener(this);
        add(registerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        warningLabel.setText("");
        switch (e.getActionCommand()) {
            case "registerButton" -> {
                String username = userNameTextField.getText(), password, passwordControl;
                char[] passwordArray = passwordField.getPassword(), passwordControlArray = passwordFieldControl.getPassword();
                if (username == null || username.isEmpty()) {
                    warningLabel.setText("Choose an username");
                    userNameTextField.requestFocus();
                    return;
                }
                if (passwordArray == null || (password = new String(passwordArray)).isEmpty()) {
                    warningLabel.setText("Set a password");
                    passwordField.requestFocus();
                    return;
                }
                if (passwordControlArray == null || (passwordControl = new String(passwordControlArray)).isEmpty()) {
                    warningLabel.setText("Confirm your password");
                    passwordFieldControl.requestFocus();
                    return;
                }
                if (!password.equals(passwordControl)) {
                    warningLabel.setText("The entered passwords do not match");
                    return;
                }
                registerButton.setEnabled(false);
                try {
                    boolean registrationSuccess = DBConnection.registerPlayer(username, password);
                    if (!registrationSuccess) {
                        warningLabel.setText("Username already taken");
                    } else {
                        // Registration successful
                        controller.setList(DBConnection.getAllPlayers());
                        if (controller.playerLogin(username, password)) {
                            controller.getPanelFrameManager().loginFrameClose();
                        } else {
                            // weird error
                            // send log to server?
                            System.err.println("Weird error (register");
                        }
                    }
                } catch (SQLException throwable) {
                    // Error - internet connection?
                    // TODO: implement server status check (online?), otherwise the program will freeze
                    warningLabel.setText("Internet connection available?");
                    throwable.printStackTrace();
                }
                registerButton.setEnabled(true);
            }
            case "backButton" -> controller.getPanelFrameManager().loginFrameClose();
        }
    }
}