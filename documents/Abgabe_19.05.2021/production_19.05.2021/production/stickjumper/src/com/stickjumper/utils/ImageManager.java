package com.stickjumper.utils;

import java.awt.image.BufferedImage;

public class ImageManager {

    private static final int sizeTolerance = 5;
    // IMAGES
    public static BufferedImage APP_ICON_IMAGE, BACKGROUND_MAIN, MOVING_BACKGROUND, MOVING_BACKGROUND_MIRRORED;
    public static BufferedImage GAME_ICON_HOME, GAME_ICON_HOME_DARK;
    public static BufferedImage START_ICON_PLAY, START_ICON_PLAY_DARK;
    public static BufferedImage START_MENU_BACKGROUND_DARK;
    public static BufferedImage ICON_BACK, ICON_BACK_DARK;
    public static BufferedImage PLAYER_SKIN_1;
    public static BufferedImage COIN_SKIN;
    public static BufferedImage ENEMY_SKIN, STEADY_OBSTACLE_SKIN;
    public static BufferedImage ICON_INTERNET_AVAILABLE, ICON_INTERNET_UNAVAILABLE;

    public static void loadALlImages(Class<?> c) {
        BACKGROUND_MAIN = UITools.getImage(c, "/images/start_view/background/mountains-middle.png");
        MOVING_BACKGROUND = UITools.getImage(c, "/images/moving_background_files/mountains-middle.png");
        MOVING_BACKGROUND_MIRRORED = UITools.getImage(c, "/images/moving_background_files/mountains-middle-mirrored.png");
        GAME_ICON_HOME = UITools.getImage(c, "/images/game_view/icons/home-light.png");
        GAME_ICON_HOME_DARK = UITools.getImage(c, "/images/game_view/icons/home_white.png");
        START_ICON_PLAY = UITools.getImage(c, "/images/start_view/icons/play.png");
        START_ICON_PLAY_DARK = UITools.getImage(c, "/images/start_view/icons/play-dark.png");
        START_MENU_BACKGROUND_DARK = UITools.getImage(c, "/images/start_view/background/mountains-middle-dark.png");
        ICON_BACK = UITools.getImage(c, "/images/icons/back.png");
        ICON_BACK_DARK = UITools.getImage(c, "/images/icons/back_dark.png");
        PLAYER_SKIN_1 = UITools.getImage(c, "/images/elements/skins/skin_1.png");
        COIN_SKIN = UITools.getImage(c, "/images/elements/coin/coin.png");
        ENEMY_SKIN = UITools.getImage(c, "/images/elements/obstacles/enemy_skin.png");
        STEADY_OBSTACLE_SKIN = UITools.getImage(c, "/images/elements/obstacles/steady_obstacle_skin.png");
        ICON_INTERNET_AVAILABLE = UITools.getImage(c, "/images/start_view/icons/internet_available.png");
        ICON_INTERNET_UNAVAILABLE = UITools.getImage(c, "/images/start_view/icons/internet_unavailable.png");
    }

    public static int getSizeTolerance() {
        return sizeTolerance;
    }

}
