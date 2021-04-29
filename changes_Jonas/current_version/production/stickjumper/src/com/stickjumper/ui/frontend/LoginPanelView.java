package com.stickjumper.ui.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginPanelView  extends JPanel {

    private TextField welcomeTextField = new TextField();
    public LoginPanelView() {
        welcomeTextField.setText("Welcome to our service");
        add(welcomeTextField);
        welcomeTextField.setBounds(20, 20, 200, 50);
        welcomeTextField.setFont(new Font("Arial Black", Font.PLAIN, 30));
    }

}