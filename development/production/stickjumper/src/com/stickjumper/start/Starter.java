package com.stickjumper.start;

import com.stickjumper.controller.scenerycontrolling.SceneryRandomGenerator;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.*;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Starter {


    public static void main(String[] args) throws SQLException, UnsupportedAudioFileException, IOException {
        long fullStart, fullEnd;
        fullStart = System.currentTimeMillis();
        // Load Windows UI config
        UITools.initUI();

        // Prepare and start loading screen
        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        long s1, s2, s3, s4, start, e1, e2, e3, e4, end;
        s3 = System.currentTimeMillis();
        SoundManager.loadAllClips();
        SoundManager.bootSoundManager();
        e3 = System.currentTimeMillis();
        Settings.logData("Sounds loading took " + (e3 - s3) + " ms");

        s1 = System.currentTimeMillis();
        int serverResponseCode = ConnectionTester.checkConnection();
        e1 = System.currentTimeMillis();
        Settings.logData("Network operation took " + (e1 - s1) + " ms");
        boolean connectionAvailable = serverResponseCode == ConnectionTester.CONNECTION_OK;
        if (!connectionAvailable) {
            // TODO: check before login, register and update highscore (db)
            JOptionPane.showMessageDialog(null, """
                    Can not connect to the server -
                    internet connection available?
                    You can still play without an connection""");
            System.exit(-2);
        }

        start = System.currentTimeMillis();
        ImageManager.loadALlImages(loadingFrameView.getClass());
        end = System.currentTimeMillis();
        Settings.logData("Image loading took " + (end - start) + " ms");

        // First Random Generation
        s4 = System.currentTimeMillis();
        SceneryRandomGenerator sceneryRandomGenerator = new SceneryRandomGenerator();
        e4 = System.currentTimeMillis();
        Settings.logData("Loading first game took " + (e4 - s4) + " ms");

        // Make all internet boot operations (db connection, ...)
        s2 = System.currentTimeMillis();
        DBConnection.init();
        e2 = System.currentTimeMillis();
        Settings.logData("DB connection took " + (e2 - s2) + " ms");
        // Create main frame
        MainFrameView mainFrameView = new MainFrameView(sceneryRandomGenerator);
        mainFrameView.addPlayerListToController(DBConnection.getAllPlayers());

        // Close loading screen
        loadingFrameView.dispose();
        mainFrameView.setVisible(true);
        fullEnd = System.currentTimeMillis();
        Settings.logData("Time taken for full boot: " + (fullEnd - fullStart) + " ms");
    }

}