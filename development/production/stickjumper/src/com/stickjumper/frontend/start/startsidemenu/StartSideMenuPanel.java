package com.stickjumper.frontend.start.startsidemenu;

import com.stickjumper.frontend.Settings;

import javax.swing.*;
import java.awt.*;

public class StartSideMenuPanel extends JPanel {

    public StartSideMenuPanel(JPanel parent) {
        setLayout(null);
        setSize(parent.getWidth() / 6, parent.getHeight());
        setLocation(0, 0);
        // setBackground(new Color(86, 73, 78, 125));
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        /*
        BufferedImage image = UITools.getImage(getClass(), "/images/start_view/background/mountains-middle-dark.png");
        if (image == null) {
            System.out.println("No pic");
            return;
        }
         */
        graphicsObject.drawImage(Settings.START_MENU_BACKGROUND_DARK, 0, 0, null);
    }
}
