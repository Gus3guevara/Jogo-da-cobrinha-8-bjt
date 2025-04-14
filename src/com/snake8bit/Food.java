package com.snake8bit;

import java.awt.Point;
import java.util.Random;

public class Food {
    private Point position;
    private int gridWidth, gridHeight;
    private Random random = new Random();

    public Food(int gridWidth, int gridHeight, Snake snake) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        spawn(snake);
    }

    public void spawn(Snake snake) {
        Point newPos;
        do {
            newPos = new Point(random.nextInt(gridWidth), random.nextInt(gridHeight));
        } while (snake.getBody().contains(newPos));
        position = newPos;
    }

    public Point getPosition() {
        return position;
    }

	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
}