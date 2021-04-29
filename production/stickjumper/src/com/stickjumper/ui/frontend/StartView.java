package com.stickjumper.ui.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StartView extends JPanel {

    private Font AHARONI_FONT = registerFont();

    public StartView() {
        setLayout(null);
        JLabel lblTitel = new JLabel("StickJumper");
        lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitel.setBounds(0, 96, 1280, 83);
        lblTitel.setFont(AHARONI_FONT);
        add(lblTitel);

        fontTest();
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        try {
            Image bgImage = ImageIO.read(getClass().getResource("/images/start_view/background/mountains-middle.png"));
            graphicsObject.drawImage(bgImage, 0, 0, null);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

    private Font registerFont() {
       /*
       try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/res/fonts/aharoni.ttf"));

            boolean registerSuccess = GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            if (registerSuccess) {
                System.out.println("Schriftart registriert!");
                return font;
            } else {
                System.err.println("Schriftart konnte nicht registriert werden!");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        */
        return new Font("Arial Black", Font.PLAIN, 40);
    }

    private void fontTest() {
        String[] fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String s : fonts) {
            System.out.println(s);
        }
    }
}