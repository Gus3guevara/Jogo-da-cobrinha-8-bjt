package com.snake8bit;

import java.awt.Point;
import java.awt.image.BufferedImageOp;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Point> body;
    private String direction = "RIGHT";

    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(5, 5));
    }

    public void move() {
        Point head = new Point(body.getFirst());
        switch (direction) {
            case "UP": head.y--; break;
            case "DOWN": head.y++; break;
            case "LEFT": head.x--; break;
            case "RIGHT": head.x++; break;
        }
        body.addFirst(head);
        body.removeLast();
    }

    public void grow() {
        Point tail = body.getLast();
        body.addLast(new Point(tail));
    }

    public boolean collides(int gridWidth, int gridHeight) {
        Point head = body.getFirst();
        if (head.x < 0 || head.y < 0 || head.x >= gridWidth || head.y >= gridHeight) return true;
        return body.stream().skip(1).anyMatch(p -> p.equals(head));
    }

    public boolean eats(Food food) {
        return body.getFirst().equals(food.getPosition());
    }

    public void setDirection(String dir) {
        if (!isOpposite(dir)) {
            direction = dir;
        }
    }

    private boolean isOpposite(String dir) {
        return (direction.equals("UP") && dir.equals("DOWN")) ||
               (direction.equals("DOWN") && dir.equals("UP")) ||
               (direction.equals("LEFT") && dir.equals("RIGHT")) ||
               (direction.equals("RIGHT") && dir.equals("LEFT"));
    }

    public List<Point> getBody() {
        return body;
    }

	public BufferedImageOp getX() {
		// TODO Auto-generated method stub
		return null;
	}
}