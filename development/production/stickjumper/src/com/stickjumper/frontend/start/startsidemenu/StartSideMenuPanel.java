package com.stickjumper.frontend.start.startsidemenu;

import javax.swing.*;
import java.awt.*;

public class StartSideMenuPanel extends JPanel {

    public StartSideMenuPanel(JPanel parent) {
        super(true);
        setLayout(null);
        setSize(parent.getWidth() / 6, parent.getHeight());
        setLocation(0, 0);
        setBackground(new Color(86, 73, 78, 125));
    }

}
