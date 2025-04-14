package com.snake8bit;

import javax.swing.*;
import java.awt.*;

public class MenuUI {
    private JFrame frame;
    private JPanel panel;
    private SoundManager soundManager;

    public MenuUI() {
        soundManager = new SoundManager();
        frame = new JFrame(LocalizationManager.getText("menu.title"));
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        JButton startButton = new JButton(LocalizationManager.getText("menu.start"));
        startButton.addActionListener(e -> {
            soundManager.playSound("assets/sounds/button_click.wav");
            frame.dispose();
            // Aqui, inicie o GameEngine ou chame Main.main(new String[0])
            SwingUtilities.invokeLater(() -> {
                GameEngine engine = new GameEngine();
                JFrame gameFrame = new JFrame(LocalizationManager.getText("window.title"));
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setContentPane(engine);
                Image icon = Toolkit.getDefaultToolkit().getImage(
                        Main.class.getClassLoader().getResource("assets/images/snake_icon.png"));
                gameFrame.setIconImage(icon);
                gameFrame.pack();
                gameFrame.setLocationRelativeTo(null);
                gameFrame.setVisible(true);
                engine.start();
            });
        });
        gbc.gridy = 0;
        panel.add(startButton, gbc);

        JButton settingsButton = new JButton(LocalizationManager.getText("menu.settings"));
        settingsButton.addActionListener(e -> {
            soundManager.playSound("assets/sounds/button_click.wav");
            new SettingsMenu().setVisible(true);
        });
        gbc.gridy = 1;
        panel.add(settingsButton, gbc);

        JButton exitButton = new JButton(LocalizationManager.getText("menu.exit"));
        exitButton.addActionListener(e -> System.exit(0));
        gbc.gridy = 2;
        panel.add(exitButton, gbc);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}