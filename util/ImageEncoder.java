package util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;


public class ImageEncoder {
    public ImageEncoder(File image, ImageChooser imageChooser, ImageTrainer imageTrain, File savepath){
        try {
            HashMap<Integer, Integer> colorMap = imageChooser.returnColorMap();
            int image_height = imageChooser.returnBufferedImage().getHeight();
            int image_width = imageChooser.returnBufferedImage().getWidth();
            Map<Integer, String> huffmanCodes = imageTrain.returnHuffCodes();
            
            
            // Encode each pixel as huffman code
            StringBuilder str_pxl_data = new StringBuilder();

            colorMap.forEach((sRGB, freq) ->
                    {
                        str_pxl_data.append(huffmanCodes.get(sRGB));
                    });
            String compressedPixelData = str_pxl_data.toString();
            
            // Save encoded data to file
            File binpath = File.createTempFile("compressed_" + image.getName(), ".bin", savepath); // this just saves it to the chosen filedir

            BitSet bits = new BitSet(compressedPixelData.length());
            int bitcounter = 0;
            for(Character c : compressedPixelData.toCharArray()) {
                if(c.equals('1')) {
                    bits.set(bitcounter);
                }
                bitcounter++;
            }

            byte[] width = ByteBuffer.allocate(4).putInt(image_width).array(); // First 4 bytes is  width
            byte[] height = ByteBuffer.allocate(4).putInt(image_height).array(); // next 4 bytes is  height
            byte[] bytes = new byte[(bits.length() + 7) / 8]; // then huffman coding
            bytes = bits.toByteArray();
            OutputStream ostream = new FileOutputStream(binpath);
            ostream.write(width);
            ostream.write(height);
            ostream.write(bytes);
            ostream.close();

            System.out.println("Image encoded successfully");


        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }
}
