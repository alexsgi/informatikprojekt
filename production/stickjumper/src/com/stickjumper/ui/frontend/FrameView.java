package com.stickjumper.ui.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class FrameView extends JFrame {

    public FrameView(JPanel contentPane) {
        setResizable(false);
        setTitle("StickJumper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 640);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        BufferedImage icon = getIcon();
        setIconImage(icon);

    }

    private BufferedImage getIcon() {
        try {
            InputStream in = getClass().getResourceAsStream("/images/icons/appicon_5.png");
            return ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
            System.exit(1);
        }
        return null;
    }

}
