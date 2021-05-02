package com.stickjumper.ui.frontend.login;

import javax.swing.*;
import java.awt.*;

public class LoginPanelView extends JPanel {

    private JLabel welcomeLabel = new JLabel();
    
    public LoginPanelView() {
        welcomeLabel.setText("Welcome to our service");
        add(welcomeLabel);
        welcomeLabel.setBounds(20, 20, 200, 50);
        welcomeLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
    }

}