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

public class RegisterPanelView extends JPanel implements ActionListener {

    private Controller controller;
    private LoginFrameView loginFrameView;

    // All buttons
    private AdvancedButton backButton;
    private JButton registerButton;

    // All Text fields
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JPasswordField passwordFieldAgain;


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

        passwordFieldAgain = new JRoundPasswordField(Settings.LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS);
        passwordFieldAgain.setHorizontalAlignment(SwingConstants.LEFT);
        passwordFieldAgain.setSize(getWidth() - 2 * 100, 30);
        passwordFieldAgain.setLocation(getWidth() / 7, passwordLabelAgain.getY() + passwordLabel.getHeight() + 1);
        passwordFieldAgain.setEchoChar('*');
        passwordFieldAgain.setFont(new Font("Open Sans", Font.PLAIN, 13));
        passwordFieldAgain.setToolTipText("Enter your password");
        add(passwordFieldAgain);

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
        switch (e.getActionCommand()) {
            case "registerButton":
                /*
                registerButton.setEnabled(false);
                String username = userNameTextField.getText(), password;
                char[] passwordArray = passwordField.getPassword();
                if (passwordArray != null && !(password = new String(passwordArray)).equals("null") && !password.isEmpty() && username != null && !username.isEmpty()) {
                    try {
                        // Test with username = Jan Marsalek & password = dasisteinpasswort
                        boolean successful = controller.playerLogin(username, password);
                        if (successful) {
                            controller.panelFrameManager.enableMainFrame();
                            controller.panelFrameManager.loginFrameClose();
                        } else {
                            JOptionPane.showMessageDialog(null, "False credentials, try again");
                        }

                    } catch (SQLException throwable) {
                        throwable.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Enter your credentials");
                }
                registerButton.setEnabled(true);
                */
                break;
            case "backButton":
                backButton.setEnabled(false);
                controller.getPanelFrameManager().loginFrameClose();
                break;
        }
    }
}