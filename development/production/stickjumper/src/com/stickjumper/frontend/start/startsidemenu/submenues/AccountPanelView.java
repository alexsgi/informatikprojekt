package com.stickjumper.frontend.start.startsidemenu.submenues;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.LoginLabel;

import javax.swing.*;
import java.awt.*;

public class AccountPanelView extends JPanel {

    JTextField txtPlayerName, txtPlayerPassword, txtPlayerHighscore;
    private Controller controller;

    public AccountPanelView(Controller controller) {
        super(true);
        setLayout(null);
        setOpaque(false);
        setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);

        this.controller = controller;

        StartSideMenuPanel menuPanel = new StartSideMenuPanel(new StartSideMenuPanel.ButtonCallback() {
            @Override
            public void onStatisticsClicked() {
                controller.getPanelFrameManager().switchToStatisticsPanel();
            }

            @Override
            public void onSettingsClicked() {
                controller.getPanelFrameManager().switchToSettingsPanel();
            }

            @Override
            public void onLoginClicked() {
                // nothing
            }

            @Override
            public void onHomeClicked() {
                controller.getPanelFrameManager().switchToHome();
            }
        });
        add(menuPanel);

        JLabel lblTitle = new JLabel("ACCOUNT");
        lblTitle.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        lblTitle.setSize(getWidth(), 50);
        lblTitle.setLocation(600, 20);
        lblTitle.setFont(Settings.FONT_HEADING_BIG);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        LoginLabel lblPlayerName = new LoginLabel(LoginLabel.TEXT);
        lblPlayerName.setText("Player name:");
        lblPlayerName.setSize(200, 30);
        lblPlayerName.setLocation(menuPanel.getWidth() + 30, 100);
        lblPlayerName.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(lblPlayerName);

        txtPlayerName = new JTextField();
        txtPlayerName.setHighlighter(null);
        txtPlayerName.setEditable(false);
        txtPlayerName.setSize(200, 30);
        txtPlayerName.setLocation(menuPanel.getWidth() + 30, 130);
        txtPlayerName.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(txtPlayerName);

        LoginLabel lblPlayerPassword = new LoginLabel(LoginLabel.TEXT);
        lblPlayerPassword.setText("Password (luckily hashed):");
        lblPlayerPassword.setSize(200, 30);
        lblPlayerPassword.setLocation(menuPanel.getWidth() + 30, 160);
        lblPlayerPassword.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(lblPlayerPassword);

        txtPlayerPassword = new JTextField();
        txtPlayerPassword.setHighlighter(null);
        txtPlayerPassword.setEditable(false);
        txtPlayerPassword.setSize(200, 30);
        txtPlayerPassword.setLocation(menuPanel.getWidth() + 30, 190);
        txtPlayerPassword.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(txtPlayerPassword);

        LoginLabel lblPlayerHighscore = new LoginLabel(LoginLabel.TEXT);
        lblPlayerHighscore.setText("Highscore:");
        lblPlayerHighscore.setSize(200, 30);
        lblPlayerHighscore.setLocation(menuPanel.getWidth() + 30, 220);
        lblPlayerHighscore.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(lblPlayerHighscore);

        txtPlayerHighscore = new JTextField();
        txtPlayerHighscore.setHighlighter(null);
        txtPlayerHighscore.setEditable(false);
        txtPlayerHighscore.setSize(200, 30);
        txtPlayerHighscore.setLocation(menuPanel.getWidth() + 30, 250);
        txtPlayerHighscore.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(txtPlayerHighscore);
    }

    public void refreshValues() {
        if (controller.getSignedInPlayer() == null) return;
        txtPlayerName.setText(controller.getSignedInPlayer().getPlayerName());
        txtPlayerPassword.setText(controller.getSignedInPlayer().getPlayerPassword());
        txtPlayerHighscore.setText(controller.getSignedInPlayer().getHighScore() + "");
    }
}
