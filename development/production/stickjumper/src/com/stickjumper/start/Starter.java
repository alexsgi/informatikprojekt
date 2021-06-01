package com.stickjumper.start;

import com.stickjumper.controller.scenerycontrolling.SceneryRandomGenerator;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.*;
import com.stickjumper.utils.manager.ImageManager;
import com.stickjumper.utils.manager.SoundManager;
import com.stickjumper.utils.manager.UITools;
import com.stickjumper.utils.network.ConnectionTester;

import javax.swing.*;
import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException {
        for (String s : args) {
            switch (s) {
                case "debug" -> Settings.activateDebugMode();
            }
        }
        UITools.initUI();

        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        SoundManager.loadAllClips();
        SoundManager.bootSoundManager();

        int serverResponseCode = ConnectionTester.checkConnection();

        if (serverResponseCode != ConnectionTester.CONNECTION_OK) {
            // TODO: check before login, register and update highscore (db)
            JOptionPane.showMessageDialog(null, """
                    Can not connect to the server -
                    internet connection available?
                    You can still play without an connection""");
            System.exit(-2);
        }

        ImageManager.loadALlImages(loadingFrameView.getClass());

        SceneryRandomGenerator sceneryRandomGenerator = new SceneryRandomGenerator();

        DBConnection.init();

        MainFrameView mainFrameView = new MainFrameView(sceneryRandomGenerator);
        mainFrameView.addPlayerListToController(DBConnection.getAllPlayers());

        loadingFrameView.dispose();
        mainFrameView.setVisible(true);
    }

}