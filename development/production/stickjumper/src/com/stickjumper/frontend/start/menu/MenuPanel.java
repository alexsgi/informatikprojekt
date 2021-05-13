package com.stickjumper.frontend.start.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(JPanel parent) {
        setLayout(null);
        setSize(parent.getWidth() / 7, parent.getHeight());
        setLocation(0, 0);
        setBackground(new Color(86, 73, 78, 150));
    }

}
