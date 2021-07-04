package com.stickjumper.utils.network;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConnectionTester {

    public static void checkConnection() throws IOException {
        HttpsURLConnection connection = (HttpsURLConnection) new URL("https://google.de/").openConnection();
        connection.setConnectTimeout(2000);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        in.close();
        connection.disconnect();
    }

}
