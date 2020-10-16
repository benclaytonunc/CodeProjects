package com.comp301.a06image;


import java.awt.*;

public class SquareDecorator implements Image{
    private Image output;
    private int sqSize;

    public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
        this.sqSize = squareSize;
        if (image == null || squareSize < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return sqSize;
    }

    @Override
    public int getHeight() {
        return sqSize;
    }

    @Override
    public int getNumLayers() {
        return 1;
    }
}
