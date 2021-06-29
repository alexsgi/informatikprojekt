package com.stickjumper.utils.manager;

import java.awt.image.BufferedImage;

public class ImageManager {

    // IMAGES
    public static BufferedImage APP_ICON_IMAGE, APP_ICON_IMAGE_BIG, BACKGROUND_MAIN, MOVING_BACKGROUND, MOVING_BACKGROUND_MIRRORED;
    public static BufferedImage GAME_ICON_HOME_ACCENT, GAME_ICON_HOME, START_ICON_HOME;
    public static BufferedImage START_ICON_PLAY, START_ICON_PLAY_ACCENT;
    public static BufferedImage START_MENU_BACKGROUND_DARK;
    public static BufferedImage ICON_BACK, ICON_BACK_DARK;
    public static BufferedImage PLAYER_SKIN_1, PLAYER_SKIN_2, PLAYER_SKIN_3;
    public static BufferedImage COIN_SKIN, COIN_SKIN_10, COIN_SKIN_20, COIN_SKIN_30, COIN_SKIN_40, COIN_SKIN_50;
    public static BufferedImage ENEMY_SKIN, STEADY_OBSTACLE_SKIN;
    public static BufferedImage ICON_INTERNET_AVAILABLE, ICON_INTERNET_UNAVAILABLE;

    public static void loadALlImages(Class<?> c) {
        BACKGROUND_MAIN = UITools.getImage(c, "/images/start_view/background/mountains-middle.png");
        MOVING_BACKGROUND = UITools.getImage(c, "/images/moving_background_files/mountains-middle.png");
        MOVING_BACKGROUND_MIRRORED = UITools.getImage(c, "/images/moving_background_files/mountains-middle-mirrored.png");
        GAME_ICON_HOME_ACCENT = UITools.getImage(c, "/images/game_view/icons/home-light.png");
        GAME_ICON_HOME = UITools.getImage(c, "/images/game_view/icons/home.png");
        START_ICON_HOME = UITools.getImage(c, "/images/game_view/icons/home_white.png");
        START_ICON_PLAY = UITools.getImage(c, "/images/start_view/icons/play.png");
        START_ICON_PLAY_ACCENT = UITools.getImage(c, "/images/start_view/icons/play-dark.png");
        START_MENU_BACKGROUND_DARK = UITools.getImage(c, "/images/start_view/background/mountains-middle-dark.png");
        ICON_BACK = UITools.getImage(c, "/images/icons/back_dark.png");
        ICON_BACK_DARK = UITools.getImage(c, "/images/icons/back_dark.png");
        PLAYER_SKIN_1 = UITools.getImage(c, "/images/elements/skins/skin_1.png");
        PLAYER_SKIN_2 = UITools.getImage(c, "/images/elements/skins/skin_2.png");
        PLAYER_SKIN_3 = UITools.getImage(c, "/images/elements/skins/skin_3.png");
        COIN_SKIN = UITools.getImage(c, "/images/elements/coin/coin_1.png");
        ENEMY_SKIN = UITools.getImage(c, "/images/elements/obstacles/enemy_skin.png");
        STEADY_OBSTACLE_SKIN = UITools.getImage(c, "/images/elements/obstacles/steady_obstacle_skin.png");
        ICON_INTERNET_AVAILABLE = UITools.getImage(c, "/images/start_view/icons/internet_available.png");
        ICON_INTERNET_UNAVAILABLE = UITools.getImage(c, "/images/start_view/icons/internet_unavailable.png");
        COIN_SKIN_10 = UITools.getImage(c, "/images/elements/coin/coin_10.png");
        COIN_SKIN_20 = UITools.getImage(c, "/images/elements/coin/coin_20.png");
        COIN_SKIN_30 = UITools.getImage(c, "/images/elements/coin/coin_30.png");
        COIN_SKIN_40 = UITools.getImage(c, "/images/elements/coin/coin_40.png");
        COIN_SKIN_50 = UITools.getImage(c, "/images/elements/coin/coin_50.png");
    }

}
