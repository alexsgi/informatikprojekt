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
        //registerFont();
        setLayout(null);
        JLabel lblTitel = new JLabel("StickJumper");
        lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitel.setBounds(0, 96, 1280, 83);
        //lblTitel.setFont(AHARONI_FONT);
        //lblTitel.setFont(lblTitel.getFont().deriveFont(64f));
        // lblTitel.setFont(AHARONI_FONT, Font.PLAIN, 30);
        add(lblTitel);

    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        Image bgImage;
        try {
            bgImage = ImageIO.read(getClass().getResource("/res/mountains-middle.png"));
            graphicsObject.drawImage(bgImage, 0, 0, null);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

    private void registerFont() {
        try {

            Font AHARONI_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    new File(getClass().getResource("/res/aharoni.ttf").toURI()));
            System.err.println(AHARONI_FONT.getName());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            System.err.println(ge.registerFont(AHARONI_FONT));

            /*
             * URL fontUrl = new
             * URL("http://db.onlinewebfonts.com/t/22db60d19480ba0274c9eb6ba877ea9b.ttf");
             * AHARONI_FONT = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
             * GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
             * ge.registerFont(AHARONI_FONT);
             */
        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
        }

    }
}

