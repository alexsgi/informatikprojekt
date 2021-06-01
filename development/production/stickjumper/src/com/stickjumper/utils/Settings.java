package com.stickjumper.utils;

import com.stickjumper.data.gameelements.GameCharacter;

import java.awt.*;

public class Settings {

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
    public static final Font FONT_HEADING_BIG = new Font("Arial Black", Font.PLAIN, 40);
    public static final Font FONT_HEADING_GAME_OVER = new Font("Arial Black", Font.PLAIN, 100);
    public static final Font FONT_HEADING_SMALL = new Font("Arial Black", Font.PLAIN, 20);
    public static final Font FONT_HEADING_GAME_HIGHSCORE = new Font("Open Sans", Font.BOLD, 30);
    public static final Font FONT_BUTTON = new Font("Calibri", Font.BOLD, 17);
    public static final Font FONT_BUTTON_PLAIN = new Font("Calibri", Font.PLAIN, 17);
    public static final Font FONT_LABEL = new Font("Calibri", Font.PLAIN, 20);
    public static final Font FONT_LABEL_WARNING = new Font("Calibri", Font.PLAIN, 14);
    public static final Font FONT_LOGIN_HEADER = new Font("Open Sans", Font.BOLD, 22);
    public static final Font FONT_LOGIN_SUBHEADER = new Font("Open Sans", Font.PLAIN, 14);
    public static final Font FONT_LOGIN_FIELDS_LABELS = new Font("Open Sans", Font.PLAIN, 13);
    public static final Font FONT_LOGIN_BUTTON = new Font("Calibri", Font.PLAIN, 15);
    public static final Font FONT_LOGIN_SMALL_BUTTON = new Font("Calibri", Font.PLAIN, 14);

    // seaLevel and y-position of GameCharacter for initializations in SceneryController
    public static final int seaLevel = 100;
    public static final int xPositionGameCharacter = 320;
    // speed control (the higher the number, the slower the movement)
    public static final int backgroundSpeed = 15;
    public static final int foregroundSpeed = 4;
    // the higher this number is, the larger is the space above the obstacle, that will cause a game over when passed
    public static final int gameOverSensitivity = 100;
    // if this variable will be set true, when the random generator works properly
    public static final boolean steadyObstaclesCauseGameOver = false ;
    public static final int JUMP_HEIGHT = 22;
    public static final int JUMP_PERIOD = 17;
    public static final int JUMP_DELAY_FOR_HOLDING_SPACE = 1; // not needed in current method
    public static final int JUMP_TOLERANCE_FOR_DELAY = JUMP_HEIGHT / 3;
    public static final int JUMP_SECOND_TOLERANCE_FOR_DELAY = (JUMP_HEIGHT / 3) * 2;
    private static final int JUMP_PERIOD_DELAY = 12;
    public static final int JUMP_PERIOD_FOR_HOLDING_SPACE = JUMP_PERIOD + JUMP_PERIOD_DELAY;
    // TODO sound settings!
    // GENERAL
    private static boolean debugMode = false;
    // jump variable
    public static boolean DELAY_JUMP_WHEN_HOLDING_KEY = true; // not final, might be changed in the real settings in the real game //TODO
    // SOUND
    public static boolean SOUND_EFFECTS_ON = true;
    public static boolean GAME_OVER_MUSIC_ON = false;

    public static void logData(String data) {
        if (isDebugMode()) System.out.println(data);
    }

    public static void logData(String data, Exception e) {
        if (isDebugMode()) System.out.println(data);
        System.err.println(e.getMessage());
        e.printStackTrace();
    }

    public static void logData(String data, Throwable e) {
        if (isDebugMode()) System.out.println(data);
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

    public static void activateDebugMode() {
        debugMode = true;
    }
}
