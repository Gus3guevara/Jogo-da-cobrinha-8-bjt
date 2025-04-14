package com.snake8bit;

import javax.swing.*;
import java.awt.*;

public class PauseMenu extends JFrame {
    private JPanel panel;

    public PauseMenu() {
        setTitle(LocalizationManager.getText("pause.title"));
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);
        
        JButton resumeButton = new JButton(LocalizationManager.getText("pause.resume"));
        resumeButton.addActionListener(e -> {
            // Aqui deve ser implementado o retomar do jogo, por exemplo, reativando o timer do GameEngine.
            dispose();
        });
        
        panel.add(resumeButton, BorderLayout.CENTER);
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }
}