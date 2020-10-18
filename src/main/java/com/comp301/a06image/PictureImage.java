package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {
    private BufferedImage image;
    int width;
    int height;
    int colorInt;
    public PictureImage(String pathname) throws IOException {
        image = ImageIO.read(new File(pathname));
        this.width = image.getWidth();
        this.height = image.getHeight();

       // this.pathname = new String(getWidth(), getHeight(), getRGB());
    }



    @Override
    public Color getPixelColor(int x, int y) {
        if (x < 0 || x >= width) {
            throw new IllegalArgumentException("Invalid width");
        }
        if (y < 0 || y >= height) {
            throw new IllegalArgumentException("Invalid height");
        }
        return new Color(image.getRGB(x, y));
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getNumLayers() {
        return 1;
    }
}
