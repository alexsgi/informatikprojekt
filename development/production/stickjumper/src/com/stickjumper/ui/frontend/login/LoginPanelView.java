package com.stickjumper.ui.frontend.login;

import javax.swing.*;
import java.awt.*;

public class LoginPanelView extends JPanel {

    private JLabel welcomeLabel = new JLabel();
    
    public LoginPanelView() {
        setLayout(null);
        welcomeLabel.setText("Welcome to our service");
        add(welcomeLabel);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 20, 600, 50);
        welcomeLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
    }

}