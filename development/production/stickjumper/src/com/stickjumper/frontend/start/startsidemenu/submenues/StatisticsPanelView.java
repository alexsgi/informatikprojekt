package com.stickjumper.frontend.start.startsidemenu.submenues;

import com.stickjumper.controller.Controller;
import com.stickjumper.data.Player;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedLabel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class StatisticsPanelView extends JPanel {

    private Controller controller;
    private JLabel[][] labelArray = new JLabel[5][2];
    private AdvancedLabel playerNotice;

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
                refresh();
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

        AdvancedLabel lblTitle = new AdvancedLabel();
        lblTitle.setKeyText("menu.statistics.title");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setSize(getWidth(), 50);
        lblTitle.setLocation(0, 20);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        AdvancedLabel lblHeader = new AdvancedLabel();
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setKeyText("menu.statistics.rankingheader");
        lblHeader.setSize(getWidth(), 50);
        lblHeader.setLocation(0, 150);
        lblHeader.setFont(Settings.FONT_HEADING_SMALL);
        lblHeader.setForeground(Color.decode("#484848"));
        add(lblHeader);

        // automatically best 5 players
        for (int i = 0; i < labelArray.length; i++) {
            for (int j = 0; j < labelArray[i].length; j++) {
                labelArray[i][j] = new JLabel();
                labelArray[i][j].setFont(Settings.FONT_LOGIN_HEADER);
                labelArray[i][j].setSize(250, 30);
                labelArray[i][j].setLocation((getWidth() - labelArray[i][j].getWidth()) / 2 + j * (labelArray[i][j].getWidth() + 150) - 100, 300 + i * 40);
                // labelArray[i][j].setForeground(Color.decode("#484848"));
                add(labelArray[i][j]);
            }
        }

        playerNotice = new AdvancedLabel();
        playerNotice.setSize(getWidth(), 30);
        playerNotice.setHorizontalAlignment(SwingConstants.CENTER);
        playerNotice.setLocation(0, getHeight() - playerNotice.getHeight() * 4);
        playerNotice.setFont(Settings.FONT_LABEL);
        add(playerNotice);
    }

    public void refresh() {
        playerNotice.setKeyText(null);
        for (JLabel[] jLabels : labelArray) {
            for (JLabel jLabel : jLabels) {
                jLabel.setText("");
            }
        }
        try {
            if (controller.getSignedInPlayer() != null) {
                DBConnection.updateHighScore(controller.getSignedInPlayer());
            }
            controller.setList(DBConnection.getAllPlayers());
        } catch (SQLException throwables) {
            Settings.logData("Error writing/reading all players (refresh [statistics])", throwables);
        }
        ArrayList<Player> list = controller.getPlayerList();
        Collections.sort(list);
        for (int i = 0; i < labelArray.length; i++) {
            if (i < list.size()) {
                if (list.get(i) != null) {
                    labelArray[i][0].setText((i + 1) + ". " + list.get(i).getPlayerName());
                    labelArray[i][1].setText(list.get(i).getHighScore() + "");
                }
            }
        }
        if (controller.getSignedInPlayer() != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPlayerName().equals(controller.getSignedInPlayer().getPlayerName())) {
                    playerNotice.setKeyTextFormat("menu.statistics.placenotice", String.valueOf(i + 1));
                }
            }
        }
    }

}
