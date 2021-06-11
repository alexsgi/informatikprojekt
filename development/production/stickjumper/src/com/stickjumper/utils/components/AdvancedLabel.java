package com.stickjumper.utils.components;

import com.stickjumper.utils.manager.StringManager;

import javax.swing.*;
import java.util.ArrayList;

public class AdvancedLabel extends JLabel {

    private static final ArrayList<AdvancedLabel> list = new ArrayList<>();
    private String key;

    public AdvancedLabel() {
        super();
        list.add(this);
    }

    public void setKeyText(String key) {
        this.key = key;
        setText(StringManager.getString(key));
    }

    public void refresh() {
        if (key != null) setText(StringManager.getString(key));
    }

}
