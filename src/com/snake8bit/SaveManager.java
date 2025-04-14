package com.snake8bit;

import java.io.*;
import java.util.Properties;

public class SaveManager {
    private static final String SAVE_PATH = "config/save.properties";
    private static Properties saveData = new Properties();

    public static void loadSave() {
        File saveFile = new File(SAVE_PATH);
        
        // Verifica se o arquivo existe, se não, cria um novo
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile(); // Cria o arquivo se não existir
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // Tenta carregar os dados do arquivo
        try (FileInputStream fis = new FileInputStream(SAVE_PATH)) {
            saveData.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveGame() {
        try (FileOutputStream fos = new FileOutputStream(SAVE_PATH)) {
            saveData.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setData(String key, String value) {
        saveData.setProperty(key, value);
    }

    public static String getData(String key) {
        return saveData.getProperty(key);
    }
}