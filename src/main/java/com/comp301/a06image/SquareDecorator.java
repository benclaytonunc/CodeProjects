package com.comp301.a06image;


import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareDecorator implements Image{
    private BufferedImage output;
    private int sqSize;
    private int sqX;
    private int sqY;
    private BufferedImage image;
    private Color sqColor;

    public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
        this.image = (BufferedImage) image;
        this.sqSize = squareSize;
        this.sqX = squareX;
        this.sqY = squareY;
        this.sqColor = color;
        if (image == null || squareSize < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (x < 0 || x >= sqSize) {
            return new Color(image.getRGB(x,y));
        }
        if (y < 0 || y >= sqSize) {
            return new Color(image.getRGB(x,y));
        }
        return sqColor;
    }

    @Override
    public int getWidth() {
        return sqSize - sqX;
    }

    @Override
    public int getHeight() {
        return sqSize - sqY;
    }

    @Override
    public int getNumLayers() {
        return 2;
    }
}
