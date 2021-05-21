package com.stickjumper.start;

import com.stickjumper.data.database.DBConnection;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        long fullStart, fullEnd;
        fullStart = System.currentTimeMillis();
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        long s1, s2, s3, start, e1, e2, e3, end;
        s1 = System.currentTimeMillis();
        int serverResponseCode = ConnectionTester.checkConnection();
        e1 = System.currentTimeMillis();
        Settings.logData("Network operation took " + (e1 - s1) + " ms");
        boolean connectionAvailable = serverResponseCode == ConnectionTester.CONNECTION_OK;
        if (!connectionAvailable) {
            // TODO: check before login, register and update highscore (db)
            JOptionPane.showMessageDialog(null, "Can not connect to the server -\ninternet connection available?");
            System.exit(1);
        }
        start = System.currentTimeMillis();
        ImageManager.loadALlImages(loadingFrameView.getClass());
        end = System.currentTimeMillis();
        Settings.logData("Image loading took " + (end - start) + " ms");

        s3 = System.currentTimeMillis();
        SoundManager.loadAllClips();
        e3 = System.currentTimeMillis();
        Settings.logData("Sounds loading took " + (e3 - s3) + " ms");

        // Make all internet boot operations (db connection, ...)
        s2 = System.currentTimeMillis();
        DBConnection.init();
        e2 = System.currentTimeMillis();
        Settings.logData("DB connection took " + (e2 - s2) + " ms");
        // Create main frame
        MainFrameView mainFrameView = new MainFrameView();
        mainFrameView.addPlayerListToController(DBConnection.getAllPlayers());

        // Close loading screen
        loadingFrameView.dispose();
        mainFrameView.setVisible(true);
        fullEnd = System.currentTimeMillis();
        Settings.logData("Time taken for full boot: " + (fullEnd - fullStart) + " ms");
    }

}