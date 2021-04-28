package com.stickjumper.ui.frontend;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartView extends JPanel {

    private Font AHARONI_FONT;

    public StartView() {
        registerFont();
        setLayout(null);
        JLabel lblTitel = new JLabel("StickJumper");
        lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitel.setBounds(0, 96, 1280, 83);
        lblTitel.setFont(AHARONI_FONT);
        // lblTitel.setFont(lblTitel.getFont().deriveFont(64f));
        add(lblTitel);

    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        Image bgImage;
        try {
            bgImage = ImageIO.read(getClass().getResource("/res/images/mountains-middle.png"));
            graphicsObject.drawImage(bgImage, 0, 0, null);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

    private void registerFont() {
        try {
            Font AHARONI_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    new File(getClass().getResource("/res/fonts/aharoni.ttf").toURI()));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            boolean registerSuccess = ge.registerFont(AHARONI_FONT);
            if(registerSuccess) {
                System.out.println("Schriftart registriert!");
            } else {
                System.err.println("Schriftart konnte nicht registriert werden!");
            }
        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
        }

    }
}