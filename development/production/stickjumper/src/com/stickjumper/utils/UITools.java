package com.stickjumper.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UITools {

    public static void initUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getImage(Class<?> c, String path) {
        try {
            /*
            InputStream in = c.getResourceAsStream(path);
            if (in == null) return null;
            return ImageIO.read(in);
             */
            //System.err.println(c.getCanonicalName());
            URL url = c.getResource(path);
            if(url == null) return null;
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("The image (%s) was not loaded\n", path);
        }
        return null;
    }

    public static Font registerFont() {
        return new Font("Arial Black", Font.PLAIN, 40);
    }

}
