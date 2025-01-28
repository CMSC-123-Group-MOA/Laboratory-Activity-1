package util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;


public class ImageEncoder {
    public ImageEncoder(File image, ImageChooser imageChooser, ImageTrainer imageTrain, File path){
        try {
            HashMap<Integer, Integer> colorMap = imageChooser.returnColorMap();
            int image_height = imageChooser.returnBufferedImage().getHeight();
            int image_width = imageChooser.returnBufferedImage().getWidth();
            Map<Integer, String> huffmanCodes = imageTrain.returnHuffCodes();
            int[][] pixelData = imageChooser.returnPixelData();
            
            
            // Encode each pixel as huffman code
            StringBuilder str_pxl_data = new StringBuilder();
            for (int y = 0; y < image_height; y++) {
                for (int x = 0; x < image_width; x++) {
                    int colorKey = colorMap.getOrDefault(pixelData[x][y], 0);
                    str_pxl_data.append(huffmanCodes.get(colorKey));
                }
            }
            String compressedPixelData = str_pxl_data.toString();
            
            // Save encoded data to file
            File binpath = File.createTempFile("compressed_" + image.getName(), ".bin", path); // this just saves it to the chosen filedir
            
            // PrintStream imagehuff = new PrintStream(imgpath);
            // for (int y = 0; y < image_height; y++) {
            //     for (int x = 0; x < image_width; x++) {
            //         imagehuff.print(compressedPixelData[x][y] + " ");
            //     }
            //     imagehuff.println();
            // }
            // imagehuff.close();

            BitSet bits = new BitSet(compressedPixelData.length());
            int bitcounter = 0;
            for(Character c : compressedPixelData.toCharArray()) {
                if(c.equals('1')) {
                    bits.set(bitcounter);
                }
                bitcounter++;
            }

            byte[] bytes = new byte[(bits.length() + 7) / 8];
            bytes = bits.toByteArray();
            OutputStream ostream = new FileOutputStream(binpath);
            ostream.write(bytes);
            ostream.close();

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
