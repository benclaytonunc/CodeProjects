package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;
import javafx.application.Application;

public class Main {

  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    // TODO use this method for testing your decorators
    PictureImage kmp = new PictureImage("img/kmp.jpg");
    Color red = new Color(255, 0, 0);
    Color orange = new Color(200, 80, 10);
    Color yellow = new Color(255, 255, 0);

    Color blue = new Color(0, 0, 255);

    Image im = new PictureImage("img/kmp.jpg");
    Image ogBorder = new BorderDecorator(im, 5, red);
    Image secondBorder = new BorderDecorator(ogBorder, 50, blue);
    Image addACircle = new CircleDecorator(secondBorder, 50, 50, 40, yellow);
    Image addASquare = new SquareDecorator(addACircle, 100, 100, 40, orange);
    Image end = new ZoomDecorator(addASquare);
    return end;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   */
  public static void main(String[] args) throws IOException {
    Application.launch(ImageDisplay.class, args);

  }
}
