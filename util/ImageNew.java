package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageNew extends JPanel{
    int image_width, image_height, pixelData[][];
    BufferedImage bufferedImage;
    HashMap<Integer, Integer> colorMap;
    FrequencyCounter freqC;

    public ImageNew(File image){
        try {
            this.bufferedImage = ImageIO.read(image);

            // Get image dimensions
            this.image_width = bufferedImage.getWidth();
            this.image_height = bufferedImage.getHeight();
            this.pixelData = new int[image_width][image_height];

            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    pixelData[x][y] = bufferedImage.getRGB(x, y);
                }
            }

            // Get frequency data of each pixel
            this.freqC = new FrequencyCounter(pixelData, image_width, image_height);
            System.out.println("Pixel Data Encoded!");

            // Get Color map from frequency class
            this.colorMap = freqC.returnColorMap();


        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }

    public int[][] returnPixelData(){
        return pixelData;
    }
    public int[] returnFrequencyData(){
        return freqC.returnFrequencies();
    }

    public HashMap<Integer, Integer> returnColorMap(){
        return freqC.returnColorMap();
    }
}
