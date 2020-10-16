package com.comp301.a06image;

import java.awt.*;

public class CircleDecorator implements Image {
    private double d;
    private int rad;
    private int cenX;
    private int cenY;
    private Color cirColor;
    private Image im;

    public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
        // Constructor code goes here
        this.rad = radius;
        this.cenX = cx;
        this.cenY = cy;
        this.cirColor = color;
        this.im = image;
        if (rad < 0 || (image == null)) {
            throw new IllegalArgumentException("wrong args");
        }

    }

    @Override
    public Color getPixelColor(int x, int y) {
        d = Math.sqrt(Math.pow((x - cenX), 2)+(Math.pow((y - cenY), 2)));
        if (d < rad) {
            im.getPixelColor(x, y);
        }
        return cirColor;
    }

    @Override
    public int getWidth() {
        return rad*2;
    }

    @Override
    public int getHeight() {
        return rad*2;
    }

    @Override
    public int getNumLayers() {
        return 2;
    }
}
