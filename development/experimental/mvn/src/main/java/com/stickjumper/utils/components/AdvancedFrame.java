package com.stickjumper.utils.components;

import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.manager.StringManager;

import javax.swing.*;
import java.util.ArrayList;

public class AdvancedFrame extends JFrame {

    private static ArrayList<AdvancedFrame> list = new ArrayList<>();
    private String key;

    public AdvancedFrame() {
        super();
        setResizable(false);
        setIconImage(ImageManager.APP_ICON_IMAGE);
        list.add(this);
    }

    public static void refresh() {
        for (AdvancedFrame a : list) {
            if (a.getKey() != null) {
                a.setKeyTitle(a.getKey());
            }
        }
    }

    public void setKeyTitle(String key) {
        this.key = key;
        setTitle((key == null || key.equals("")) ? "" : StringManager.getString(key));
    }

    public String getKey() {
        return key;
    }
}
