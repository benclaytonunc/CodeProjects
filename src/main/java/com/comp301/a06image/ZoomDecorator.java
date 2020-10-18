package com.comp301.a06image;

import java.awt.*;
import java.lang.*;

public class ZoomDecorator implements Image {
    private Image im;
    private int multiple;
    public ZoomDecorator(Image image) {
        this(image, 2);
    }

    public ZoomDecorator(Image image, int multiplier) {
        this.im = image;
        this.multiple = multiplier;
        if (image == null) {
            throw new IllegalArgumentException();
        }
        if (multiple <= 0) {
            throw new IllegalArgumentException();
        }

    }


    @Override
    public Color getPixelColor(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        if (x >= im.getWidth() || y >= im.getHeight()) {
            throw new IllegalArgumentException();
        }
        int newX = x / multiple;
        int newY = y / multiple;

        return im.getPixelColor(newX,newY);
    }

    @Override
    public int getWidth() {
        return getWidth()*multiple;
    }

    @Override
    public int getHeight() {
        return getHeight()*multiple;
    }

    @Override
    public int getNumLayers() {
        return 1+im.getNumLayers();
    }
}
