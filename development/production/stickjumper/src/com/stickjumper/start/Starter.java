package com.stickjumper.start;

import com.stickjumper.controller.scenerycontrolling.GameRandomGenerator;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.manager.SoundManager;
import com.stickjumper.utils.manager.StringManager;
import com.stickjumper.utils.manager.UITools;
import com.stickjumper.utils.network.ConnectionTester;
import fastmail.FastMail;

import javax.swing.*;
import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException {
        for (String s : args) {
            if ("debug".equals(s)) {
                Settings.activateDebugMode();
                System.err.println("WARNING: debug mode active");
            }
        }
        UITools.initUI();

        StringManager.init(StringManager.DE);

        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        SoundManager.loadAllClips();
        SoundManager.bootSoundManager();

        int serverResponseCode = ConnectionTester.checkConnection();

        if (serverResponseCode != ConnectionTester.CONNECTION_OK) {
            // TODO: check before login, register and update highscore (db)
            JOptionPane.showMessageDialog(null, StringManager.getString("starter.db.connection.error"));
        }

        ImageManager.loadALlImages(loadingFrameView.getClass());

        GameRandomGenerator sceneryRandomGenerator = new GameRandomGenerator();

        FastMail.init(Settings.E_HOST, Settings.E_USERNAME, Settings.E_PASSWORD);
        DBConnection.init();

        MainFrameView mainFrameView = new MainFrameView(sceneryRandomGenerator, DBConnection.getAllPlayers());
        // mainFrameView.automaticLogin();

        loadingFrameView.dispose();
        mainFrameView.setVisible(true);
    }

}