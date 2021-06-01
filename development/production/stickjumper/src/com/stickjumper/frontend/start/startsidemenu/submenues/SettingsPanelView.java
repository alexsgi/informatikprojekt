package com.stickjumper.frontend.start.startsidemenu.submenues;

import com.stickjumper.utils.Settings;

import javax.swing.*;

public class SettingsPanelView extends JPanel {

    public SettingsPanelView() {
        super(true);
        setLayout(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
    }

}
