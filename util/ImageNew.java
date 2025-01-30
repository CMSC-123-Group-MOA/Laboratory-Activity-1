package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageNew extends JPanel{
    private int image_width, image_height, pixelData[][];
    private BufferedImage bufferedImage;
    private HashMap<Integer, Integer> colorMap;

    public ImageNew(File image){
        try {
            this.bufferedImage = ImageIO.read(image);

            // Get image dimensions
            this.image_width = bufferedImage.getWidth();
            this.image_height = bufferedImage.getHeight();
            // declare colormap and count frequencies
            colorMap = new HashMap<>();
            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    colorMap.put(bufferedImage.getRGB(x, y), colorMap.getOrDefault(bufferedImage.getRGB(x, y), 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }

    public int[][] returnPixelData(){
        return pixelData;
    }

    public HashMap<Integer, Integer> returnColorMap(){
        return colorMap;
    }
}
