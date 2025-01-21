import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEncoder {

    public static void main(String[] args) {
        try {
            // Load the image
            BufferedImage image = ImageIO.read(new File("/home/niguel/Documents/SS24-25/CMSC123-lab/Laboratory-Activity-1/Images/ap.PNG"));
            
            int image_width = image.getWidth();
            int image_height = image.getHeight();
            int pixelData[][] = new int[image_width][image_height];

            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    pixelData[x][y] = image.getRGB(x, y);
                }
            }

            System.out.println("Pixel Data Encoded!");
            FrequencyCounter freqC = new FrequencyCounter(pixelData, image_width, image_height);
            
        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }
}
