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
        if (x < 0 || y < 0 || x >= (im.getWidth() + 2*thicc) || y >= (im.getHeight() + 2*thicc)) {
            throw new IllegalArgumentException();
        }

        if (x < thicc || (x >= (im.getWidth() + thicc) && x < (im.getWidth() + 2 * thicc) )) {
            return bc;
        }
        if (y < thicc || (y >= (im.getHeight() + thicc) && x < (im.getHeight() + 2 * thicc))) {
            return bc;
        }
        return im.getPixelColor(x - thicc,y - thicc);
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
