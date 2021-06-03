package com.stickjumper.frontend.start.startsidemenu.submenues;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanelView extends JPanel {

    private Controller controller;

    public StatisticsPanelView(Controller controller) {
        super(true);
        setLayout(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);

        this.controller = controller;

        StartSideMenuPanel menuPanel = new StartSideMenuPanel(new StartSideMenuPanel.ButtonCallback() {
            @Override
            public void onStatisticsClicked() {
                // nothing
            }

            @Override
            public void onSettingsClicked() {
                controller.getPanelFrameManager().switchToSettingsPanel();
            }

            @Override
            public void onLoginClicked() {
                if (controller.getSignedInPlayer() == null) {
                    controller.getPanelFrameManager().openLoginFrame();
                } else {
                    controller.getPanelFrameManager().switchToAccountPanel();
                }
            }

            @Override
            public void onHomeClicked() {
                controller.getPanelFrameManager().switchToHome();
            }
        });
        add(menuPanel);

        JLabel lblTitle = new JLabel("STATISTICS");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setSize(getWidth(), 50);
        lblTitle.setLocation(0, 20);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        // send own data to db, refresh list

        JLabel lblHeader = new JLabel();
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setText("Ranking of the best StickJumper players");
        lblHeader.setSize(getWidth(), 50);
        lblHeader.setLocation(0, 150);
        lblHeader.setFont(Settings.FONT_HEADING_SMALL);
        lblHeader.setForeground(Color.decode("#484848"));
        add(lblHeader);

        // need sorted list of 5 (?) best players

    }

}
