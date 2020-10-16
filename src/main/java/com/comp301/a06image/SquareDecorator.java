package com.comp301.a06image;


import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareDecorator implements Image{
    private BufferedImage output;
    private int sqSize;
    private int sqX;
    private int sqY;
    private Image im;
    private Color sqColor;

    public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
        this.im = image;
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
            return new Color(((BufferedImage) im).getRGB(x,y));
        }
        if (y < 0 || y >= sqSize) {
            return new Color(((BufferedImage) im).getRGB(x,y));
        }
        return sqColor;
    }

    @Override
    public int getWidth() {
        return im.getWidth();
    }

    @Override
    public int getHeight() {
        return im.getHeight();
    }

    @Override
    public int getNumLayers() {
        return 2;
    }
}
