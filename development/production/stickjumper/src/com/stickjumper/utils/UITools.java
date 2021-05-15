package com.stickjumper.utils;

import com.stickjumper.frontend.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

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
            InputStream in = c.getResourceAsStream(path);
            if (in == null) return null;
            return ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("The image (%s) was not loaded\n", path);
        }
        return null;
    }

    public static void loadALlImages(Class<?> c) {
        Settings.BACKGROUND_MAIN = getImage(c, "");
        Settings.MOVING_BACKGROUND = getImage(c, "/images/moving_background_files/mountains-middle.png");
        Settings.MOVING_BACKGROUND_MIRRORED = getImage(c, "/images/moving_background_files/mountains-middle-mirrored.png");
        Settings.GAME_ICON_HOME = getImage(c, "/images/game_view/icons/home-light.png");
        Settings.GAME_ICON_HOME_DARK = getImage(c, "/images/game_view/icons/home.png");
        Settings.START_ICON_PLAY = getImage(c, "/images/start_view/icons/play.png");
        Settings.START_ICON_PLAY_DARK = getImage(c, "/images/start_view/icons/play-dark.png");
        Settings.START_MENU_BACKGROUND_DARK = getImage(c, "/images/start_view/background/mountains-middle-dark.png");
        Settings.LOGIN_REGISTER_BACK = getImage(c, "/images/login_register/back.png");
    }

}
