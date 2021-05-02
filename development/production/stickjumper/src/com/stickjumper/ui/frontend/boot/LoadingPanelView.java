package com.stickjumper.ui.frontend.boot;

import com.stickjumper.start.Starter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadingPanelView extends JPanel {

    private JLabel loadingLabel = new JLabel();

    public LoadingPanelView() {
        setLayout(null);
        loadingLabel.setText("Loading ...");
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadingLabel.setBounds(0, 250, 1080, 50);
        loadingLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        // Set text color to white
        loadingLabel.setForeground(Color.WHITE);

        add(loadingLabel);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = Starter.getImage(getClass(), "/images/loading_screen/loading_screen_image.png");
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

}