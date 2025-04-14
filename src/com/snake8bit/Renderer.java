package com.snake8bit;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Renderer {
    private Snake snake;
    private Food food;
    private int tileSize;
    private BufferedImage snakeImage;
    private BufferedImage foodImage;

    public Renderer(Snake snake, Food food, int tileSize) {
        this.snake = snake;
        this.food = food;
        this.tileSize = tileSize;

        // Tentar carregar as imagens
        loadImages();
    }

    private void loadImages() {
        try {
            snakeImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("assets/images/snake_pixel_art.png"));
            foodImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("assets/images/food.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
            // Usar uma cor padrão se a imagem não for encontrada
            createDefaultImages();
        }
    }

    private void createDefaultImages() {
        // Imagem padrão da cobra
        snakeImage = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
        Graphics g = snakeImage.getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, tileSize, tileSize);
        g.dispose();

        // Imagem padrão da comida
        foodImage = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
        g = foodImage.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(0, 0, tileSize, tileSize);
        g.dispose();
    }

    public void render(Graphics2D g) {
        // Desenhar fundo
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, tileSize * 32, tileSize * 24);

        // Desenhar comida
        Point foodPos = food.getPosition();
        if (foodPos != null) {
            g.drawImage(foodImage, foodPos.x * tileSize, foodPos.y * tileSize, tileSize, tileSize, null);
        }

        // Desenhar cobra
        for (Point p : snake.getBody()) {
            g.drawImage(snakeImage, p.x * tileSize, p.y * tileSize, tileSize, tileSize, null);
        }

        // HUD internacionalizado
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(LocalizationManager.getText("hud.player") + ": Jogador", 10, 20);
        g.drawString(LocalizationManager.getText("hud.score") + ": " + snake.getBody().size(), 10, 40);
        g.drawString(LocalizationManager.getText("hud.difficulty") + ": " + SettingsManager.getSetting("difficulty"), 10, 60);
    }
}