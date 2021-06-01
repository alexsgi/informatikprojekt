package com.stickjumper.frontend.start.startsidemenu;

import com.stickjumper.utils.Settings;

import javax.swing.*;
import java.awt.*;

public class StartSideMenuPanel extends JPanel {

    public StartSideMenuPanel() {
        super(true);
        setLayout(null);
        setSize(Settings.SCREEN_WIDTH / 6, Settings.SCREEN_HEIGHT);
        setLocation(0, 0);
        setOpaque(true);
        setBackground(new Color(86, 73, 78, 125));
    }

}
