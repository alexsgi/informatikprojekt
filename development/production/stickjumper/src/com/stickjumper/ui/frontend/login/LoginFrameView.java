package com.stickjumper.ui.frontend.login;

import com.stickjumper.ui.frontend.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrameView extends JFrame {

    private JButton loginButton = new JButton();

    public LoginFrameView(JPanel contentPane, Controller controller) {
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        loginButton.setText("Main");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setBounds(0, 150, 200, 50);
        loginButton.setVisible(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.enableMainFrame();
                pullThePlug();
            }
        });
        add(loginButton);
    }

    public void pullThePlug() {
        // this will hide and dispose the frame, so that the application quits by
        // itself if there is nothing else around.
        setVisible(false);
        dispose();

    }
}