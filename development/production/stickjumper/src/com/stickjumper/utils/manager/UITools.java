package com.stickjumper.utils.manager;

import com.stickjumper.utils.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UITools {

    public static void initUI() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        } catch (Throwable e) {
            Settings.logData("Error loading L&F", e);
        }
    }

    public static BufferedImage getImage(Class<?> c, String path) {
        try {
            InputStream in = c.getResourceAsStream(path);
            if (in == null) return null;
            return ImageIO.read(in);
        } catch (IOException e) {
            Settings.logData(String.format("The image (%s) was not loaded", path), e);
        }
        return null;
    }
}
