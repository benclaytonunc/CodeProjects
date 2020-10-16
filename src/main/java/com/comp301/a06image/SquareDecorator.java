package com.comp301.a06image;


import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareDecorator implements Image{
    private BufferedImage output;
    private int sqSize;
    private int sqX;
    private int sqY;

    public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
        this.sqSize = squareSize;
        this.sqX = squareX;
        this.sqY = squareY;
        if (image == null || squareSize < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (x < 0 || x >= sqSize) {
            throw new IllegalArgumentException("Invalid width");
        }
        if (y < 0 || y >= sqSize) {
            throw new IllegalArgumentException("Invalid height");
        }
        return new Color(output.getRGB(x, y));
    }

    @Override
    public int getWidth() {
        return sqX;
    }

    @Override
    public int getHeight() {
        return sqY;
    }

    @Override
    public int getNumLayers() {
        return 2;
    }
}
