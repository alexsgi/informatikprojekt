package com.stickjumper.utils.components;

import com.stickjumper.utils.Settings;

import javax.swing.*;

public class LoginLabel extends JLabel {

    public static final int HEADER = 0;
    public static final int SUBHEADER = 1;
    public static final int TEXT = 2;

    public LoginLabel(int style) {
        super();
        switch (style) {
            case HEADER -> setFont(Settings.FONT_LOGIN_HEADER);
            case SUBHEADER -> setFont(Settings.FONT_LOGIN_SUBHEADER);
            case TEXT -> setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        }
    }

}
