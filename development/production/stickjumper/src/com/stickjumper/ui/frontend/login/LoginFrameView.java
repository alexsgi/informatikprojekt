package com.stickjumper.ui.frontend.login;

import com.stickjumper.ui.frontend.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class LoginFrameView extends JFrame {

    private JButton loginButton = new JButton();

    public LoginFrameView(JPanel contentPane, Controller controller) {
        setResizable(false);
        setTitle("Login");
        setSize(600, 500);
        //setUndecorated(true);
        //int arc = 18;
        //setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
        setLocationRelativeTo(null);
        setContentPane(contentPane);



        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setBounds(0, 150, 200, 50);
        loginButton.setVisible(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.enableMainFrame();
            }
        });
        add(loginButton);
    }

}