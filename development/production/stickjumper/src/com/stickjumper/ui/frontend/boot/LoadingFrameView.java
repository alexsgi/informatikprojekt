package com.stickjumper.ui.frontend.boot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadingFrameView extends JFrame {

    public LoadingFrameView(JPanel contentPane) {
        setResizable(false);
        setUndecorated(true);
        setSize(1080, 300);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        setIconImage(getIcon());
    }

    private BufferedImage getIcon() {
        try {
            InputStream in = getClass().getResourceAsStream("/images/icons/appicon_5.png");
            if (in == null) return null;
            return ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("The image was not loaded");
        }
        return null;
    }

}