package com.stickjumper.utils.components;

import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.StringManager;

import javax.swing.*;
import java.util.ArrayList;

public class AdvancedToggleButton extends JToggleButton {

    private static final ArrayList<AdvancedToggleButton> list = new ArrayList<>();
    private String key;

    public AdvancedToggleButton(boolean selected) {
        super();
        setFocusable(false);
        setSelected(selected);
        setFont(Settings.FONT_BUTTON_PLAIN_SMALL);
        list.add(this);
    }

    public static void refresh() {
        for (AdvancedToggleButton b : list) {
            if (b.getKey() != null) {
                b.setKeyText(b.getKey());
            }
        }
    }

    public void setKeyText(String key) {
        this.key = key;
        setText((key == null || key.equals("")) ? "" : StringManager.getString(key));
    }

    public String getKey() {
        return key;
    }

}
