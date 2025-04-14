package com.snake8bit;

import java.io.*;
import java.util.*;

public class ControlsConfig {
    private static final String PATH = "config/controls.properties";
    private static Properties keys = new Properties();

    public static void loadControls() {
        try (FileInputStream fis = new FileInputStream(PATH)) {
            keys.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveControls() {
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            keys.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getKey(String action) {
        return keys.getProperty(action);
    }

    public static void setKey(String action, String key) {
        keys.setProperty(action, key);
    }
}