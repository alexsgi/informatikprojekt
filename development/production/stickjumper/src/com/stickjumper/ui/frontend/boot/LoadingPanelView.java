package com.stickjumper.ui.frontend.boot;

import javax.swing.*;
import java.awt.*;

public class LoadingPanelView extends JPanel {

    private JLabel welcomeLabel = new JLabel();

    public LoadingPanelView() {
        welcomeLabel.setText("Loading ...");
        add(welcomeLabel);
        welcomeLabel.setBounds(540, 150, 200, 50);
        welcomeLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));

    }

}