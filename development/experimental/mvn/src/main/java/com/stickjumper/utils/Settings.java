package com.stickjumper.utils;

import com.stickjumper.utils.manager.StringManager;

import javax.swing.*;
import java.awt.*;

public class Settings {

    public static final String APP_NAME = "StickJumper";
    public static final String APP_VERSION = "v1.2";
    public static final String APP_ICON = "/images/icons/appicon_4.png", APP_ICON_BIG = "/images/icons/appicon.png";
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
    public static final Font FONT_HEADING_GAME_OVER = new Font("Open Sans", Font.PLAIN, 100);
    public static final Font FONT_HEADING_BIG = new Font("Open Sans", Font.PLAIN, 40);
    public static final Font FONT_HEADING_BIG_BOLD = new Font("Open Sans", Font.BOLD, 40);
    public static final Font FONT_HEADING_SMALL = new Font("Open Sans", Font.PLAIN, 20);
    public static final Font FONT_LOADING_HEADING_SMALL = new Font("Open Sans", Font.PLAIN, 15);
    public static final Font FONT_HEADING_GAME_HIGHSCORE = new Font("Open Sans", Font.BOLD, 30);
    public static final Font FONT_BUTTON = new Font("Open Sans", Font.BOLD, 17);
    public static final Font FONT_BUTTON_PLAIN = new Font("Open Sans", Font.PLAIN, 17);
    public static final Font FONT_BUTTON_PLAIN_SMALL = new Font("Open Sans", Font.PLAIN, 14);
    public static final Font FONT_LABEL_BOLD_SMALL = new Font("Open Sans", Font.BOLD, 14);
    public static final Font FONT_LABEL = new Font("Open Sans", Font.PLAIN, 20);
    public static final Font FONT_LABEL_WARNING = new Font("Open Sans", Font.PLAIN, 14);
    public static final Font FONT_LOGIN_HEADER = new Font("Open Sans", Font.BOLD, 22);
    public static final Font FONT_LOGIN_SUBHEADER = new Font("Open Sans", Font.PLAIN, 14);
    public static final Font FONT_LOGIN_FIELDS_LABELS = new Font("Open Sans", Font.PLAIN, 13);
    public static final Font FONT_LOGIN_BUTTON = new Font("Open Sans", Font.PLAIN, 15);
    public static final Font FONT_LOGIN_SMALL_BUTTON = new Font("Open Sans", Font.PLAIN, 14);

    // SEA_LEVEL and x-position of GameCharacter for initializations in GameController
    public static final int SEA_LEVEL = 130;
    public static final int X_POSITION_GAME_CHARACTER = 320;
    // speed control (the higher the number, the slower the movement)
    public static final int BACKGROUND_SPEED = 15;
    public static final int FOREGROUND_SPEED = 4;
    // the higher this number is, the larger is the space above the obstacle, that will cause a game over when passed
    public static final int GAME_OVER_SENSITIVITY_AFTER_OBJECT = -110;
    public static final int GAME_OVER_SENSITIVITY_BEFORE_OBJECT = -5;
    public static final int JUMP_HEIGHT = 22;
    public static final int JUMP_PERIOD = 17;
    public static final int JUMP_TOLERANCE_FOR_DELAY = JUMP_HEIGHT / 3;
    public static final int JUMP_SECOND_TOLERANCE_FOR_DELAY = (JUMP_HEIGHT / 3) * 2;
    public static final int SCORE_TO_WIN = 2000;
    private static final int JUMP_PERIOD_DELAY = 12;
    public static final int JUMP_PERIOD_FOR_HOLDING_SPACE = JUMP_PERIOD + JUMP_PERIOD_DELAY;
    // set to false when click 10x on high score label
    public static boolean STEADY_OBSTACLES_LETHAL = true;
    // SOUND
    public static boolean SOUND_EFFECTS_ON = true;
    public static boolean GAME_OVER_MUSIC_ON = true;
    // GENERAL
    private static boolean DEBUG_MODE = false;

    public static void logData(String data) {
        if (isDebugMode()) System.out.println(data);
    }

    public static void logData(String data, Throwable e) {
        if (isDebugMode()) {
            System.out.println(data);
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, StringManager.getString("error.message") + " " + data);
    }

    public static boolean isDebugMode() {
        return DEBUG_MODE;
    }

    public static void activateDebugMode() {
        DEBUG_MODE = true;
    }
}
