package util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEncoder {
    public ImageEncoder(File image){
        ResourceLoaders loaders = new ResourceLoaders();
        String PATH = image.getAbsolutePath();
        try {
            BufferedImage bufferedImage = ImageIO.read(image);

            // Get image dimensions
            int image_width = bufferedImage.getWidth();
            int image_height = bufferedImage.getHeight();
            int pixelData[][] = new int[image_width][image_height];

            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    pixelData[x][y] = bufferedImage.getRGB(x, y);
                }
            }

            FrequencyCounter freqC = new FrequencyCounter(pixelData, image_width, image_height);
            System.out.println("Pixel Data Encoded!");
        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }
}
