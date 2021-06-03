package com.stickjumper.frontend.start.startsidemenu.submenues;

import com.stickjumper.controller.Controller;
import com.stickjumper.frontend.start.startsidemenu.StartSideMenuPanel;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.components.AdvancedButton;
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
        lblPlayerName.setSize(250, 15);
        lblPlayerName.setLocation(menuPanel.getWidth() + 30, 200);
        lblPlayerName.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(lblPlayerName);

        txtPlayerName = new JTextField();
        txtPlayerName.setHighlighter(null);
        txtPlayerName.setEditable(false);
        txtPlayerName.setSize(lblPlayerName.getWidth(), 30);
        txtPlayerName.setLocation(menuPanel.getWidth() + 30, lblPlayerName.getY() + lblPlayerName.getHeight() + 5);
        txtPlayerName.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(txtPlayerName);

        // test of course
        LoginLabel lblPlayerPassword = new LoginLabel(LoginLabel.TEXT);
        lblPlayerPassword.setText("Password (hashed!):");
        lblPlayerPassword.setSize(lblPlayerName.getWidth(), lblPlayerName.getHeight());
        lblPlayerPassword.setLocation(lblPlayerName.getX() + lblPlayerName.getWidth() + 50, lblPlayerName.getY());
        lblPlayerPassword.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(lblPlayerPassword);

        txtPlayerPassword = new JTextField();
        txtPlayerPassword.setHighlighter(null);
        txtPlayerPassword.setEditable(false);
        txtPlayerPassword.setSize(txtPlayerName.getWidth(), txtPlayerName.getHeight());
        txtPlayerPassword.setLocation(txtPlayerName.getX() + txtPlayerName.getWidth() + 50, txtPlayerName.getY());
        txtPlayerPassword.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(txtPlayerPassword);

        LoginLabel lblPlayerHighscore = new LoginLabel(LoginLabel.TEXT);
        lblPlayerHighscore.setText("Highscore:");
        lblPlayerHighscore.setSize(lblPlayerName.getWidth(), lblPlayerName.getHeight());
        lblPlayerHighscore.setLocation(lblPlayerPassword.getX() + lblPlayerPassword.getWidth() + 50, lblPlayerPassword.getY());
        lblPlayerHighscore.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(lblPlayerHighscore);

        txtPlayerHighscore = new JTextField();
        txtPlayerHighscore.setHighlighter(null);
        txtPlayerHighscore.setEditable(false);
        txtPlayerHighscore.setSize(txtPlayerName.getWidth(), txtPlayerName.getHeight());
        txtPlayerHighscore.setLocation(txtPlayerPassword.getX() + txtPlayerPassword.getWidth() + 50, txtPlayerPassword.getY());
        txtPlayerHighscore.setFont(Settings.FONT_LOGIN_FIELDS_LABELS);
        add(txtPlayerHighscore);

        AdvancedButton advancedButton = new AdvancedButton();
        advancedButton.setText("Log out");
        advancedButton.setSize(150, 35);
        advancedButton.setLocation((getWidth() - advancedButton.getWidth()) / 2, getHeight() - advancedButton.getHeight() - 50);
        advancedButton.addActionListener(e -> {
            controller.playerLogout();
            controller.updateHighScore();
            controller.getPanelFrameManager().switchToHome();
        });
        add(advancedButton);

    }

    public void refreshValues() {
        if (controller.getSignedInPlayer() == null) return;
        txtPlayerName.setText(controller.getSignedInPlayer().getPlayerName());
        txtPlayerPassword.setText(controller.getSignedInPlayer().getPlayerPassword());
        txtPlayerHighscore.setText(controller.getSignedInPlayer().getHighScore() + "");
    }
}
