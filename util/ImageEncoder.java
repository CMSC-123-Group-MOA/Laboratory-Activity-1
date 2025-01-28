package util;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;

import javax.sound.sampled.AudioFormat.Encoding;


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
                System.out.println("Compressing...");
            }
            
            // Save encoded data to file
            //OutputStream imagehuff = new FileOutputStream("Laboratory-Activity-1\\\\Images\\\\Compressed" + image.getName() + ".bin");
            File image1 = new File("Laboratory-Activity-1\\Images\\Compressed" + image.getName() + ".bin");
            FileOutputStream outputStream = new FileOutputStream(image1);
            DataOutputStream imagehuff = new DataOutputStream(outputStream);
            //PrintStream imagehuff = new PrintStream(new File("Laboratory-Activity-1\\Images\\Compressed" + image.getName() + ".txt"));
            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    //imagehuff.write((byte) Integer.parseInt(compressedPixelData[x][y], 2));
                    byte[] byteArray = compressedPixelData[x][y].getBytes(StandardCharsets.UTF_8);
                    for(int i = 0; i < byteArray.length; i++){
                        imagehuff.writeByte(byteArray[i]);
                    }
                    //imagehuff.print(compressedPixelData[x][y]);
                }
                System.out.println("Compressing...");
            }
            imagehuff.close();

            System.out.println("Image encoded successfully");


        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }
    public static boolean[] convertStringToBoolArray(String binaryString) {
        boolean[] boolArray = new boolean[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            boolArray[i] = binaryString.charAt(i) == '1';
        }
        return boolArray;
    }
}
