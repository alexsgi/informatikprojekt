package com.stickjumper.utils.manager;

import com.stickjumper.utils.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UITools {

    public static void initUI() {
        try {
            String osName = System.getProperty("os.name");
            if (osName.contains("Windows")) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } else if (osName.contains("Mac")) {
                ImageManager.APP_ICON_IMAGE_BIG = UITools.getImage(UITools.class, Settings.APP_ICON_BIG);
                final Taskbar taskbar = Taskbar.getTaskbar();
                taskbar.setIconImage(ImageManager.APP_ICON_IMAGE_BIG);
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
