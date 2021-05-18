package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
import com.stickjumper.utils.components.JRoundPasswordField;
import com.stickjumper.utils.components.JRoundTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class LoginPanelView extends JPanel implements ActionListener, MouseListener {

    private Controller controller;
    private LoginFrameView loginFrameView;

    // All buttons
    private AdvancedButton backButton, registerButton;
    private JButton loginButton;

    // All Text fields
    private JTextField userNameTextField;
    private JPasswordField passwordField;

    private JLabel warningLabel;

    public LoginPanelView(Controller controller, LoginFrameView loginFrameView) {
        setLayout(null);
        setSize(loginFrameView.getWidth(), loginFrameView.getHeight());

        this.controller = controller;
        this.loginFrameView = loginFrameView;

        Color color = new Color(224, 255, 255);
        setBackground(color);

        backButton = new AdvancedButton();
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setSize(32, 32);
        backButton.setLocation(5, 5);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 12));
        backButton.setActionCommand("backButton");
        backButton.setName("backButton");
        backButton.addActionListener(this);
        backButton.addMouseListener(this);
        backButton.setIcon(ImageManager.LOGIN_REGISTER_BACK);
        add(backButton);

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome back to StickJumper");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 20, 600, 50);
        welcomeLabel.setFont(Settings.FONT_LOGIN_HEADER);
        add(welcomeLabel);

        JLabel signInLabel = new JLabel();
        signInLabel.setText("Sign in to play and compete with other players");
        signInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signInLabel.setSize(getWidth(), 30);
        signInLabel.setLocation(0, welcomeLabel.getY() + welcomeLabel.getHeight() + 5);
        signInLabel.setFont(Settings.FONT_LOGIN_SUBHEADER);
        add(signInLabel);

        JLabel userNameLabel = new JLabel();
        userNameLabel.setText("Username");
        userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        userNameLabel.setSize(getWidth() - 2 * 100, 30);
        userNameLabel.setLocation(getWidth() / 7, signInLabel.getY() + signInLabel.getHeight() + 25);
        userNameLabel.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(userNameLabel);

        userNameTextField = new JRoundTextField(Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
        userNameTextField.setSize(getWidth() - 2 * 100, 30);
        userNameTextField.setLocation(getWidth() / 7, userNameLabel.getY() + userNameLabel.getHeight() + 1);
        userNameTextField.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        userNameTextField.setToolTipText("Enter your username");
        add(userNameTextField);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabel.setSize(getWidth() - 2 * 100, 30);
        passwordLabel.setLocation(getWidth() / 7, userNameTextField.getY() + userNameTextField.getHeight() + 1);
        passwordLabel.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(passwordLabel);

        passwordField = new JRoundPasswordField(Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
        passwordField.setHorizontalAlignment(SwingConstants.LEFT);
        passwordField.setSize(getWidth() - 2 * 100, 30);
        passwordField.setLocation(getWidth() / 7, passwordLabel.getY() + passwordLabel.getHeight() + 1);
        passwordField.setEchoChar('*');
        passwordField.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        passwordField.setToolTipText("Enter your password");
        add(passwordField);

        warningLabel = new JLabel("LOL");
        warningLabel.setSize(getWidth(), 30);
        warningLabel.setLocation(0, passwordField.getY() + passwordField.getHeight() + 10);
        warningLabel.setFont(Settings.FONT_LABEL_WARNING);
        warningLabel.setForeground(Color.RED);
        warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(warningLabel);

        loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setFont(Settings.FONT_LOGIN_BUTTON);
        loginButton.setSize(150, 40);
        loginButton.setLocation((getWidth() - loginButton.getWidth()) / 2, getHeight() - (int) (loginButton.getHeight() * 3.5));
        loginButton.setFocusable(false);
        loginButton.setActionCommand("loginButton");
        loginButton.setName("loginButton");
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        add(loginButton);

        registerButton = new AdvancedButton();
        registerButton.setText("Still not registered? Join the community");
        registerButton.setFont(Settings.FONT_LOGIN_SMALL_BUTTON);
        registerButton.setSize(2 * loginButton.getWidth(), 40);
        registerButton.setLocation((getWidth() - registerButton.getWidth()) / 2, getHeight() - (registerButton.getHeight() * 2));
        registerButton.setActionCommand("registerButton");
        registerButton.setName("registerButton");
        registerButton.addActionListener(this);
        registerButton.addMouseListener(this);
        add(registerButton);
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "backButton":
                // redundant?
                break;
            case "loginButton":
                // redundant?
                break;
            case "registerButton":
                registerButton.setForeground(Color.BLUE);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "backButton":
                // redundant?
                break;
            case "loginButton":
                // redundant?
                break;
            case "registerButton":
                registerButton.setForeground(Color.BLACK);
                break;
        }
    }
}