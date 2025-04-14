package com.snake8bit;

import javax.swing.*;
import java.awt.*;

public class GameOverScreen {
    private JFrame frame;
    private JPanel panel;

    public GameOverScreen() {
        frame = new JFrame(LocalizationManager.getText("gameover.title"));
        panel = new JPanel(new BorderLayout());

        JButton restartButton = new JButton(LocalizationManager.getText("gameover.restart"));
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