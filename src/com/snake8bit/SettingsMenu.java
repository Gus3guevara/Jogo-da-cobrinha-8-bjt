package com.snake8bit;

import javax.swing.*;
import java.awt.*;

public class SettingsMenu extends JFrame {
    private JPanel panel;

    public SettingsMenu() {
        setTitle(LocalizationManager.getText("settings.title"));
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        // Exemplo de slider para volume
        JLabel volumeLabel = new JLabel(LocalizationManager.getText("settings.volumeMusic"));
        volumeLabel.setForeground(Color.WHITE);
        gbc.gridy = 0;
        panel.add(volumeLabel, gbc);

        JSlider volumeSlider = new JSlider(0, 100, 50);
        gbc.gridy++;
        panel.add(volumeSlider, gbc);
        
        // Botão de voltar
        JButton backButton = new JButton(LocalizationManager.getText("settings.back"));
        backButton.addActionListener(e -> dispose());
        gbc.gridy++;
        panel.add(backButton, gbc);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }
}
