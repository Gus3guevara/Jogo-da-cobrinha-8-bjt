package com.snake8bit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameEngine extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Snake snake;
    private Food food;
    private Renderer renderer;
    private SoundManager soundManager;

    private int tileSize = 20;
    private int gridWidth = 32, gridHeight = 24;
    private boolean running = true;
    private boolean paused = false;

    public GameEngine() {
        setPreferredSize(new Dimension(gridWidth * tileSize, gridHeight * tileSize));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        snake = new Snake();
        food = new Food(gridWidth, gridHeight, snake);
        renderer = new Renderer(snake, food, tileSize);
        soundManager = new SoundManager();

        timer = new Timer(100, this);
    }

    public void start() {
        soundManager.playBackgroundMusic();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running && !paused) {
            snake.move();
            if (snake.eats(food)) {
                soundManager.playSound("assets/sounds/eat.wav");
                snake.grow();
                food.spawn(snake);
            }
            if (snake.collides(gridWidth, gridHeight)) {
                running = false;
                timer.stop();
                soundManager.playSound("assets/sounds/gameover.wav");
                SaveManager.setData("score", String.valueOf(snake.getBody().size()));
                SaveManager.saveGame();
                new GameOverScreen();
            }
            if (snake.getBody().size() >= gridWidth * gridHeight) {
                running = false;
                timer.stop();
                soundManager.playSound("assets/sounds/win.wav");
                SaveManager.setData("score", String.valueOf(snake.getBody().size()));
                SaveManager.saveGame();
                new WinScreen();
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderer.render((Graphics2D) g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Customizable controls
        String upKey = ControlsConfig.getKey("UP");
        String downKey = ControlsConfig.getKey("DOWN");
        String leftKey = ControlsConfig.getKey("LEFT");
        String rightKey = ControlsConfig.getKey("RIGHT");

        if (upKey != null && key == KeyEvent.getExtendedKeyCodeForChar(upKey.charAt(0))) {
            snake.setDirection("UP");
        } else if (downKey != null && key == KeyEvent.getExtendedKeyCodeForChar(downKey.charAt(0))) {
            snake.setDirection("DOWN");
        } else if (leftKey != null && key == KeyEvent.getExtendedKeyCodeForChar(leftKey.charAt(0))) {
            snake.setDirection("LEFT");
        } else if (rightKey != null && key == KeyEvent.getExtendedKeyCodeForChar(rightKey.charAt(0))) {
            snake.setDirection("RIGHT");
        }

        // Pause functionality
        if (key == KeyEvent.VK_P) {
            togglePause();
        }
    }

    private void togglePause() {
        paused = !paused;
        if (paused) {
            timer.stop();
            new PauseMenu();
        } else {
            timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
