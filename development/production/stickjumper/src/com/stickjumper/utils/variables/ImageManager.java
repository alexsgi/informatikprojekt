package com.stickjumper.utils.variables;

import com.stickjumper.utils.UITools;

import java.awt.image.BufferedImage;

public class ImageManager {

    // IMAGES
    public static BufferedImage APP_ICON_IMAGE, BACKGROUND_MAIN, MOVING_BACKGROUND, MOVING_BACKGROUND_MIRRORED;
    public static BufferedImage GAME_ICON_HOME, GAME_ICON_HOME_DARK;
    public static BufferedImage START_ICON_PLAY, START_ICON_PLAY_DARK;
    public static BufferedImage START_MENU_BACKGROUND_DARK;
    public static BufferedImage LOGIN_REGISTER_BACK;

    public static void loadALlImages(Class<?> c) {
        BACKGROUND_MAIN = UITools.getImage(c, "/images/start_view/background/mountains-middle.png");
        MOVING_BACKGROUND = UITools.getImage(c, "/images/moving_background_files/mountains-middle.png");
        MOVING_BACKGROUND_MIRRORED = UITools.getImage(c, "/images/moving_background_files/mountains-middle-mirrored.png");
        GAME_ICON_HOME = UITools.getImage(c, "/images/game_view/icons/home-light.png");
        GAME_ICON_HOME_DARK = UITools.getImage(c, "/images/game_view/icons/home.png");
        START_ICON_PLAY = UITools.getImage(c, "/images/start_view/icons/play.png");
        START_ICON_PLAY_DARK = UITools.getImage(c, "/images/start_view/icons/play-dark.png");
        START_MENU_BACKGROUND_DARK = UITools.getImage(c, "/images/start_view/background/mountains-middle-dark.png");
        LOGIN_REGISTER_BACK = UITools.getImage(c, "/images/login_register/back.png");
    }
    
}
