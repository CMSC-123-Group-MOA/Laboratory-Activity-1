import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageTestCreate {

    public static void main(String[] args) {
        // Print the current working directory for debugging
        System.out.println("Current directory: " + System.getProperty("user.dir"));

        // Create a 4x4 image with different colors
        int width = 4;
        int height = 4;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  // Use RGB format for simplicity

        // Set some pixels to test with different colors
        image.setRGB(0, 0, Color.RED.getRGB());
        image.setRGB(1, 0, Color.GREEN.getRGB());
        image.setRGB(2, 0, Color.BLUE.getRGB());
        image.setRGB(3, 0, Color.YELLOW.getRGB());

        image.setRGB(0, 1, Color.CYAN.getRGB());
        image.setRGB(1, 1, Color.MAGENTA.getRGB());
        image.setRGB(2, 1, Color.ORANGE.getRGB());
        image.setRGB(3, 1, Color.PINK.getRGB());

        image.setRGB(0, 2, Color.BLACK.getRGB());
        image.setRGB(1, 2, Color.WHITE.getRGB());
        image.setRGB(2, 2, Color.GRAY.getRGB());
        image.setRGB(3, 2, Color.LIGHT_GRAY.getRGB());

        image.setRGB(0, 3, Color.DARK_GRAY.getRGB());
        image.setRGB(1, 3, Color.RED.getRGB());
        image.setRGB(2, 3, Color.GREEN.getRGB());
        image.setRGB(3, 3, Color.BLUE.getRGB());

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

