package com.stickjumper.utils;

import java.awt.*;

public class Settings {

    // GENERAL
    private static final boolean debugMode = true;
    public static final String APP_ICON = "/images/icons/appicon_4.png";
    public static final int SCREEN_WIDTH = 1280, SCREEN_HEIGHT = 640;
    public static final int LOGIN_SCREEN_WIDTH = 600, LOGIN_SCREEN_HEIGHT = 500;
    // LOADING
    public static final int LOADING_FRAME_CORNER_RADIUS = 18;
    public static final String LOADING_FRAME_BACKGROUND_IMAGE_PATH = "/images/loading_screen/sky.png";
    // LOGIN/REGISTER
    public static final int LOGIN_VIEW_TEXTFIELD_CORNER_RADIUS = 15;
    public static final Color LOGIN_BACKGROUND_COLOR = Color.decode("#F7F7FF");
    // START
    public static final int START_SPACE_BUTTONS = 20;
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

    // seaLevel and y-position of GameCharacter for initializations in SceneryController
    public static int seaLevel = 100;
    public static int xPositionGameCharacter = 320;

    public static void logData(String data) {
        if (isDebugMode()) System.out.println(data);
        // What to do with logs?
    }

    public static void logData(String data, Exception e) {
        if (isDebugMode()) System.out.println(data);
        // What to do with logs?
        System.err.println(e.getMessage());
        e.printStackTrace();
    }

    public static void logData(String data, Throwable e) {
        if (isDebugMode()) System.out.println(data);
        // What to do with logs?
        System.err.println(e.getMessage());
        e.printStackTrace();
    }

    public static void logDataOneLine(String data) {
        if (isDebugMode()) System.out.print(data);
        // What to do with logs?
    }

    public static boolean isDebugMode() {
        return debugMode;
    }

}
