package com.stickjumper.ui.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MainFrameView extends JFrame {

    public MainFrameView(JPanel contentPane) {
        setResizable(false);
        setTitle("StickJumper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 640);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setIconImage(getIcon());
    }

    private BufferedImage getIcon() {
        try {
            InputStream in = getClass().getResourceAsStream("/images/icons/appicon_5.png");
            if(in == null) return null;
            return ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("The image was not loaded");
        }
        return null;
    }
}
