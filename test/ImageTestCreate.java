import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Random;

public class ImageTestCreate {

    public static void main(String[] args) {
        // Print the current working directory for debugging
        System.out.println("Current directory: " + System.getProperty("user.dir"));

        // Create a 4x4 image with different colors
        int width = 600;
        int height = 600;
        Random rand = new Random();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  // Use RGB format for simplicity

        // Set some pixels to test with different colors
       for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int red = rand.nextInt(256);   // Random red value between 0 and 255
                int green = rand.nextInt(256); // Random green value between 0 and 255
                int blue = rand.nextInt(256);  // Random blue value between 0 and 255

                // Set the pixel with the random color
                Color randomColor = new Color(red, green, blue);
                image.setRGB(x, y, randomColor.getRGB());                
            }
        }


        // Try writing the image to an explicit file path
        File outputFile = new File("test_image.bmp");

        try {
            // Check if the file already exists, and delete it if necessary
            if (outputFile.exists()) {
                outputFile.delete();
            }

            // Write the image to the BMP file
            boolean written = ImageIO.write(image, "BMP", outputFile);
            if (written) {
                System.out.println("BMP image saved as test_image.bmp");
            } else {
                System.out.println("Failed to save BMP image.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error saving the image.");
        }
    }
}

