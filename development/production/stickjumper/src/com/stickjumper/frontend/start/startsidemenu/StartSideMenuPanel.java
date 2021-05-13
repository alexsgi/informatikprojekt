package com.stickjumper.frontend.start.startsidemenu;

import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartSideMenuPanel extends JPanel {

    public StartSideMenuPanel(JPanel parent) {
        setLayout(null);
        setSize(parent.getWidth() / 7, parent.getHeight());
        setLocation(0, 0);
        setBackground(new Color(86, 73, 78, 125));
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = UITools.getImage(getClass(), "/images/start_view/background/mountains-middle.png");
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

}
