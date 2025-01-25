package util;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


public class ImageEncoder {
    public ImageEncoder(File image, ImageChooser imageChooser, ImageTrainer imageTrain){
        try {
            HashMap<Integer, Integer> colorMap = imageChooser.returnColorMap();
            int image_height = imageChooser.returnBufferedImage().getHeight();
            int image_width = imageChooser.returnBufferedImage().getWidth();
            Map<Integer, String> huffmanCodes = imageTrain.returnHuffCodes();
            int[][] pixelData = imageChooser.returnPixelData();
            
            
            // Encode each pixel as huffman code
            String compressedPixelData[][] = new String[image_width][image_height];
            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    int colorKey = colorMap.getOrDefault(pixelData[x][y], 0);
                    compressedPixelData[x][y] = huffmanCodes.get(colorKey);
                }
            }
            
            // Save encoded data to file
            PrintStream imagehuff = new PrintStream(new File("Laboratory-Activity-1\\Images\\Compressed" + image.getName() + ".txt"));
            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    imagehuff.print(compressedPixelData[x][y] + " ");
                }
                imagehuff.println();
            }
            imagehuff.close();

            System.out.println("Image encoded successfully");
            // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("encoded_image.txt"));
            // oos.writeObject(compressedPixelData);   
            // oos.close();


        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }
}
