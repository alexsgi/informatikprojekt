package com.stickjumper.ui.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class StartView extends JPanel {

    private Font AHARONI_FONT = registerFont();

    public StartView() {
        setLayout(null);
        JLabel lblTitle = new JLabel("StickJumper");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(AHARONI_FONT);
        add(lblTitle);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        try {
            URL url = getClass().getResource("/images/start_view/background/mountains-middle.png");
            if(url == null) return;
            Image bgImage = ImageIO.read(url);
            graphicsObject.drawImage(bgImage, 0, 0, null);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

    private Font registerFont() {
        return new Font("Arial Black", Font.PLAIN, 40);
    }
}