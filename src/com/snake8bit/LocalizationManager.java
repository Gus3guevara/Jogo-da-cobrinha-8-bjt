package com.snake8bit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocalizationManager {
    private static Properties localization = new Properties();

    public static void loadLocalization(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            localization.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getText(String key) {
        return localization.getProperty(key, key);
    }
}