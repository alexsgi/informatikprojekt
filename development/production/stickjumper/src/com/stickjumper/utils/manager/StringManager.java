package com.stickjumper.utils.manager;

import com.stickjumper.utils.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class StringManager {

    public static final String EN = "en";
    public static final String DE = "de";

    private static HashMap<String, String> strings = new HashMap<>();

    private StringManager() {
    }

    public static void init(String languageCode) {
        // Locale.setDefault(new Locale(languageCode.toLowerCase(),languageCode.toUpperCase()));
        Properties prop = new Properties();
        try (InputStream inputStream = StringManager.class.getResourceAsStream(String.format("/strings/%s.prop", languageCode))) {
            prop.load(inputStream);
            Set<String> keys = prop.stringPropertyNames();
            strings = new HashMap<>();
            for (String key : keys) strings.put(key, prop.getProperty(key));
        } catch (IOException e) {
            Settings.logData("Error loading strings", e);
        }
    }

    public static String getString(String key) {
        return strings.get(key);
    }
}
