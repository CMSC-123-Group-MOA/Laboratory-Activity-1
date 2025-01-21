import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEncoder {

    public static void main(String[] args) {
        ImageEncoder ie = new ImageEncoder();
        ClassLoader classLoader = ie.getClass().getClassLoader();
        try {
            BufferedImage image = ImageIO.read(classLoader.getResourceAsStream("Images/ap.PNG"));

            // Get image dimensions
            int width = image.getWidth();
            int height = image.getHeight();
            int pixelData[][] = new int[width][height];

            // Loop through each pixel
            // for (int y = 0; y < height; y++) {
            //     for (int x = 0; x < width; x++) {
            //         // Get RGB value of the pixel
            //         pixelData[x][y] = image.getRGB(x, y);
            //     }
            // }
            System.out.println("Pixel Data Encoded!");
            // Print the encoded pixel data
            // for (int y = 0; y < height; y++) {
            //     for (int x = 0; x < width; x++) {
            //         System.out.print(pixelData[x][y] + " ");
            //     }
            //     System.out.println();
            // }

            FrequencyCounter freqC = new FrequencyCounter(pixelData, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}