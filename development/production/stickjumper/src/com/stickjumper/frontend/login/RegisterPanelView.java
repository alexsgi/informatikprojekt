package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.JRoundPasswordField;
import com.stickjumper.utils.components.JRoundTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterPanelView extends JPanel implements ActionListener {

    private Controller controller;
    private LoginFrameView loginFrameView;

    // All buttons
    private AdvancedButton backButton;
    private JButton registerButton;

    // All Text fields
    private JTextField userNameTextField;
    private JPasswordField passwordField, passwordFieldControl;
    private JLabel warningLabel;


    public RegisterPanelView(Controller controller, LoginFrameView loginFrameView) {
        this.controller = controller;
        this.loginFrameView = loginFrameView;

        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());

        Color color = new Color(224, 220, 255);
        setBackground(color);

        backButton = new AdvancedButton();
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(32, 32);
        backButton.setLocation(5, 5);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 12));
        backButton.setIcon(ImageManager.LOGIN_REGISTER_BACK);
        backButton.setActionCommand("backButton");
        backButton.addActionListener(this);
        add(backButton);

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to StickJumper");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 20, 600, 50);
        welcomeLabel.setFont(new Font("Open Sans", Font.BOLD, 22));
        add(welcomeLabel);

        JLabel signInLabel = new JLabel();
        signInLabel.setText("Join the community by creating an account");
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

        userNameTextField = new JRoundTextField(Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
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

        passwordField = new JRoundPasswordField(Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
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

        passwordFieldControl = new JRoundPasswordField(Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
        passwordFieldControl.setHorizontalAlignment(SwingConstants.LEFT);
        passwordFieldControl.setSize(getWidth() - 2 * 100, 30);
        passwordFieldControl.setLocation(getWidth() / 7, passwordLabelAgain.getY() + passwordLabel.getHeight() + 1);
        passwordFieldControl.setEchoChar('*');
        passwordFieldControl.setFont(new Font("Open Sans", Font.PLAIN, 13));
        passwordFieldControl.setToolTipText("Enter your password");
        add(passwordFieldControl);

        warningLabel = new JLabel();
        warningLabel.setSize(getWidth(), 30);
        warningLabel.setLocation(0, passwordFieldControl.getY() + passwordFieldControl.getHeight() + 10);
        warningLabel.setFont(Settings.FONT_LABEL_WARNING);
        warningLabel.setForeground(Color.RED);
        warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(warningLabel);

        registerButton = new JButton();
        registerButton.setText("Sign up");
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        registerButton.setSize(150, 40);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (int) (registerButton.getHeight() * 3.5));
        registerButton.setFocusable(false);
        registerButton.setActionCommand("registerButton");
        registerButton.addActionListener(this);
        add(registerButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        warningLabel.setText(""); // set empty
        switch (e.getActionCommand()) {
            case "registerButton":
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
                break;
            case "backButton":
                controller.getPanelFrameManager().loginFrameClose();
                break;
        }
    }
}