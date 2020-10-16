package com.comp301.a06image;

import java.awt.*;


public class SolidColorImage implements Image {
    private Color color;
    private int width;
    private int height;

    public SolidColorImage(int width, int height, Color color) {
        this.color = color;
        this.width = width;
        this.height = height;
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("negative width or height");
        }

    }
    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getNumLayers() {
        return 0;
    }
}
