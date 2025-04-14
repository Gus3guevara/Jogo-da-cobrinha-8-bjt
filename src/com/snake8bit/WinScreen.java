package com.snake8bit;

import javax.swing.*;
import java.awt.*;

public class WinScreen {
    private JFrame frame;
    private JPanel panel;

    public WinScreen() {
        frame = new JFrame(LocalizationManager.getText("win.title"));
        panel = new JPanel(new BorderLayout());

        JButton restartButton = new JButton(LocalizationManager.getText("win.restart"));
        restartButton.addActionListener(e -> {
            frame.dispose();
            restartGame();
        });

        panel.add(restartButton, BorderLayout.CENTER);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void restartGame() {
        SwingUtilities.invokeLater(() -> {
            GameEngine engine = new GameEngine();
            JFrame gameFrame = new JFrame(LocalizationManager.getText("window.title"));
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setContentPane(engine);
            gameFrame.pack();
            gameFrame.setLocationRelativeTo(null);
            gameFrame.setVisible(true);
            engine.start();
        });
    }
}