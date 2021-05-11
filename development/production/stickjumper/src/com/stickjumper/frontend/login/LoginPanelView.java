package com.stickjumper.frontend.login;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginPanelView extends JPanel {

    private JLabel welcomeLabel = new JLabel();
    private JButton loginButton = new JButton();
    private JButton initDB = new JButton();

    public LoginPanelView(Controller controller, LoginFrameView loginFrameView) {
        setLayout(null);
        welcomeLabel.setText("Welcome to our service");
        add(welcomeLabel);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 20, 600, 50);
        welcomeLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));

        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setBounds(0, 150, 200, 50);
        loginButton.setVisible(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.setEnabled(false);
                try {
                    boolean successful = controller.playerLogin("Jan Marsalek", "dasisteinpasswort");
                    if(successful) {
                        controller.enableMainFrame();
                        loginFrameView.disposeLoginFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, "False credentials, try again");
                        loginButton.setEnabled(true);
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        add(loginButton);

        initDB.setText("KeInE aHnUnG");
        initDB.setFont(new Font("Calibri", Font.PLAIN, 15));
        initDB.setBounds(0, 250, 200, 50);
        initDB.setVisible(true);
        initDB.setFocusable(false);
        add(initDB);
    }


}