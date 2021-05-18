package com.stickjumper.utils;

import java.awt.*;

public class Settings {

    // GENERAL
    public static final String APP_ICON = "/images/icons/appicon_5.png";
    public static final int SCREEN_WIDTH = 1280, SCREEN_HEIGHT = 640;
    public static final int LOGIN_SCREEN_WIDTH = 600, LOGIN_SCREEN_HEIGHT = 500;
    // LOADING
    public static final int LOADING_FRAME_CORNER_RADIUS = 18;
    public static final String LOADING_FRAME_BACKGROUND_IMAGE_PATH = "/images/loading_screen/sky.png";
    // LOGIN/REGISTER
    public static final int LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS = 15;

    // FONT SIZES
    public static Font FONT_HEADING_BIG = new Font("Arial Black", Font.PLAIN, 40);
    public static Font FONT_HEADING_SMALL = new Font("Arial Black", Font.PLAIN, 20);
    public static Font FONT_BUTTON = new Font("Calibri", Font.BOLD, 17);
    public static Font FONT_BUTTON_PLAIN = new Font("Calibri", Font.PLAIN, 17);
    public static Font FONT_LABEL = new Font("Calibri", Font.PLAIN, 20);
    public static Font FONT_LABEL_WARNING = new Font("Calibri", Font.PLAIN, 14);
    public static Font FONT_LOGIN_HEADER = new Font("Open Sans", Font.BOLD, 22);
    public static Font FONT_LOGIN_SUBHEADER = new Font("Open Sans", Font.PLAIN, 14);
    public static Font FONT_LOGIN_FIELDS_LABELS = new Font("Open Sans", Font.PLAIN, 13);
    public static Font FONT_LOGIN_BUTTON = new Font("Calibri", Font.PLAIN, 15);
    public static Font FONT_LOGIN_SMALL_BUTTON = new Font("Calibri", Font.PLAIN, 14);

    public static void logData(String data) {
        System.out.println(data);
        // What to do with logs?
    }

}
