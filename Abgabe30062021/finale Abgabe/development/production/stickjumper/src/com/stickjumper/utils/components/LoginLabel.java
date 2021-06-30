package com.stickjumper.utils.components;

import com.stickjumper.utils.Settings;

import javax.swing.*;
import java.awt.*;

public class LoginLabel extends AdvancedLabel {

    public static final int HEADER = 0;
    public static final int SUBHEADER = 1;
    public static final int TEXT = 2;
    public static final int WARNING = 3;

    public LoginLabel(int style) {
        super();
        setHorizontalAlignment((style == TEXT) ? SwingConstants.LEFT : SwingConstants.CENTER);
        switch (style) {
            case HEADER -> setFont(Settings.FONT_LOGIN_HEADER);
            case SUBHEADER -> setFont(Settings.FONT_LOGIN_SUBHEADER);
            case TEXT -> setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
            case WARNING -> {
                setFont(Settings.FONT_LABEL_WARNING);
                setForeground(Color.RED);
            }
        }
    }

}
