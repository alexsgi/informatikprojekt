package com.stickjumper.frontend;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Settings {

    // GENERAL
    public static final String APP_ICON = "/images/icons/appicon_5.png";
    public static final int SCREEN_WIDTH = 1280, SCREEN_HEIGHT = 640;
    // LOADING
    public static final int LOADING_FRAME_CORNER_RADIUS = 18;
    public static final String LOADING_FRAME_BACKGROUND_IMAGE_PATH = "/images/loading_screen/sky.png";
    // LOGIN/REGISTER
    public static final int LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS = 15;
    public static final String LOGIN_VIEW_LOGIN_BUTTON_ACTION_NAME = "LOGIN";
    public static final String LOGIN_VIEW_REGISTER_BUTTON_ACTION_NAME = "REGISTER";
    public static final String LOGIN_VIEW_BACK_BUTTON_ACTION_NAME = "BACK";
    // START
    public static final String START_VIEW_LOGIN_BUTTON_ACTION_NAME = LOGIN_VIEW_LOGIN_BUTTON_ACTION_NAME;
    public static final String START_VIEW_SETTINGS_BUTTON_ACTION_NAME = "SETTINGS";
    public static final String START_VIEW_PLAY_BUTTON_ACTION_NAME = "PLAY";
    // GAME
    public static final String GAME_VIEW_BACK_BUTTON_ACTION_NAME = LOGIN_VIEW_BACK_BUTTON_ACTION_NAME;
    public static final String GAME_VIEW_START_BUTTON_ACTION_NAME = "START";
    public static final String GAME_VIEW_STOP_BUTTON_ACTION_NAME = "STOP";
    // FONT SIZES
    public static Font FONT_HEADING_BIG = new Font("Arial Black", Font.PLAIN, 40);
    public static Font FONT_HEADING_SMALL = new Font("Arial Black", Font.PLAIN, 20);
    public static Font FONT_BUTTON = new Font("Calibri", Font.BOLD, 17);
    public static Font FONT_BUTTON_PLAIN = new Font("Calibri", Font.PLAIN, 17);
    public static Font FONT_LABEL = new Font("Calibri", Font.PLAIN, 20);
    public static Font FONT_LOGIN_HEADER = new Font("Open Sans", Font.BOLD, 22);
    public static Font FONT_LOGIN_SUBHEADER = new Font("Open Sans", Font.PLAIN, 14);
    public static Font FONT_LOGIN_FIELDS_LABELS = new Font("Open Sans", Font.PLAIN, 13);
    public static Font FONT_LOGIN_BUTTON = new Font("Calibri", Font.PLAIN, 15);
    public static Font FONT_LOGIN_SMALL_BUTTON = new Font("Calibri", Font.PLAIN, 14);
    // IMAGES
    public static BufferedImage APP_ICON_IMAGE, BACKGROUND_MAIN, MOVING_BACKGROUND, MOVING_BACKGROUND_MIRRORED;
    public static BufferedImage GAME_ICON_HOME, GAME_ICON_HOME_DARK;
    public static BufferedImage START_ICON_PLAY, START_ICON_PLAY_DARK;
    public static BufferedImage START_MENU_BACKGROUND_DARK;
    public static BufferedImage LOGIN_REGISTER_BACK;

}
