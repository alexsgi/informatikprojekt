package com.stickjumper.utils.components;

import com.stickjumper.utils.manager.StringManager;

import javax.swing.*;
import java.util.ArrayList;

public class AdvancedLabel extends JLabel {

    private static final ArrayList<AdvancedLabel> list = new ArrayList<>();
    private String key, value;
    private boolean callFormat = false;

    public AdvancedLabel() {
        super();
        list.add(this);
    }

    public static void refresh() {
        for (AdvancedLabel a : list) {
            if (a.getKey() != null) {
                if (a.isCallFormat()) {
                    a.setKeyTextFormat(a.getKey(), a.getValue());
                } else {
                    a.setKeyText(a.getKey(), a.getValue());
                }
            }
        }
    }

    private boolean isCallFormat() {
        return callFormat;
    }

    public void setKeyText(String key) {
        this.key = key;
        setText((key == null || key.equals("")) ? "" : StringManager.getString(key));
    }

    public void setKeyText(String key, String value) {
        this.key = key;
        this.value = value;
        setText(StringManager.getString(key) + ((value != null) ? value : ""));
    }

    public void appendValue(String value) {
        if (key != null) setKeyText(key, value);
    }

    public void setNumberText(int number) {
        setText(number + "");
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKeyTextFormat(String key, String value) {
        this.key = key;
        this.value = value;
        callFormat = true;
        setText((key == null) ? "" : String.format(StringManager.getString(key), value));
    }

}
