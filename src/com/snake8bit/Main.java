package com.snake8bit;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Carrega configurações e localizações
        SettingsManager.loadConfig("config/config.properties");
        LocalizationManager.loadLocalization("config/localization_en.properties"); // ou localization_pt.properties
        ControlsConfig.loadControls();
        SaveManager.loadSave();
        
        // Inicia o game na EDT
        SwingUtilities.invokeLater(() -> {
            GameEngine engine = new GameEngine();
            JFrame frame = new JFrame(LocalizationManager.getText("window.title"));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(engine);
            Image icon = Toolkit.getDefaultToolkit().getImage(
                    Main.class.getClassLoader().getResource("assets/images/snake_icon.png"));
            frame.setIconImage(icon);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            engine.start();
        });
    }
}