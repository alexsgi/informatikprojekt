package com.stickjumper.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConnectionTester {

    public static final int CONNECTION_ERROR = 0;
    public static final int CONNECTION_OK = 1;
    public static final int CONNECTION_MAINTENANCE = 2;
    public static final int CONNECTION_UNDEFINED_ERROR = 3;
    private static final String SERVER_STATUS_URL = "https://stickjumper.ddns.net/status.php";

    public static int checkConnection() {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URL(SERVER_STATUS_URL).openConnection();
            connection.setConnectTimeout(100);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String response;
            while ((response = in.readLine()) != null)
                responseBuilder.append(response).append("\n");
            in.close();
            connection.disconnect();
            response = responseBuilder.toString();
            String[] responseParts = response.split(":");
            if (responseParts.length != 2) return CONNECTION_UNDEFINED_ERROR;
            // which java version needed?
            return switch (responseParts[1].trim()) {
                case "ok" -> CONNECTION_OK;
                case "maintenance" -> CONNECTION_MAINTENANCE;
                default -> CONNECTION_UNDEFINED_ERROR;
            };
        } catch (IOException e) {
            return CONNECTION_ERROR;
        }
    }

}
