package com.snake8bit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsManager {
    private static Properties config = new Properties();

    public static void loadConfig(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSetting(String key) {
        return config.getProperty(key);
    }
}