package dev.v4jp.cebooklub.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ImageUtils {

    public static String getDominantColor(String imageUrl) throws IOException {
        URI uri = null;
        try {
            uri = new URI(imageUrl);

            BufferedImage image = ImageIO.read(uri.toURL());

            int width = image.getWidth();
            int height = image.getHeight();

            long sumRed = 0;
            long sumGreen = 0;
            long sumBlue = 0;
            long pixelCount = 0;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color pixelColor = new Color(image.getRGB(x, y));
                    sumRed += pixelColor.getRed();
                    sumGreen += pixelColor.getGreen();
                    sumBlue += pixelColor.getBlue();
                    pixelCount++;
                }
            }

            int avgRed = (int) (sumRed / pixelCount);
            int avgGreen = (int) (sumGreen / pixelCount);
            int avgBlue = (int) (sumBlue / pixelCount);

            Color averageColor = new Color(avgRed, avgGreen, avgBlue);
            return String.format("#%02x%02x%02x", averageColor.getRed(), averageColor.getGreen(), averageColor.getBlue());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}