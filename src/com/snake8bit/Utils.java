package com.snake8bit;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Utils {
    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontRenderContext frc = ((Graphics2D) g).getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(text, frc);
        int x = (int) (rect.x + (rect.width - bounds.getWidth()) / 2);
        int y = (int) (rect.y + (rect.height - bounds.getHeight()) / 2 - bounds.getY());
        g.setFont(font);
        g.drawString(text, x, y);
    }
}