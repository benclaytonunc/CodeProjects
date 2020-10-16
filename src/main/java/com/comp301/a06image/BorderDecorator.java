package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image{
    private Image im;
    private int thicc;
    private Color bc;
    public BorderDecorator(Image image, int thiccness, Color borderColor) {
        // Constructor code goes here
        this.im = image;
        this.thicc = thiccness;
        this.bc = borderColor;
        if (thiccness < 0 || image == null) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        if (x > getWidth() || y > getHeight()) {
            throw new IllegalArgumentException();
        }
        if (x < thicc) {
            return bc;
        }
        if (y < thicc) {
            return bc;
        }
        if (x >= (getWidth() - thicc)) {
            return bc;
        }
        if (y >= getHeight() - thicc){
            return bc;
        }
        return im.getPixelColor(x,y);
    }

    @Override
    public int getWidth() {
        return (thicc*2) + im.getWidth();
    }

    @Override
    public int getHeight() {
        return (thicc*2) + im.getHeight();
    }

    @Override
    public int getNumLayers() {
        return 1 + im.getNumLayers();
    }
}
