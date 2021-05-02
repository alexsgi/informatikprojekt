package com.stickjumper.ui.frontend.boot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

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
        try {
            URL url = getClass().getResource("/images/loading_screen/loading_screen_image.png");
            if (url == null) return;
            Image bgImage = ImageIO.read(url);
            graphicsObject.drawImage(bgImage, 0, 0, null);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

}