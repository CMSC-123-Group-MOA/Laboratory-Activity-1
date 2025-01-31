package util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Map;


public class ImageEncoder {
    public ImageEncoder(File image, ImageChooser imageChooser, ImageTrainer imageTrain, File savepath){
        try {
            BufferedImage img = imageChooser.returnBufferedImage();
            int image_height = img.getHeight();
            int image_width = img.getWidth();
            Map<Integer, String> huffmanCodes = imageTrain.returnHuffCodes();
            
            // Encode each pixel as huffman code
            StringBuilder str_pxl_data = new StringBuilder();
            for (int i = 0; i < image_width; i++) {
                for (int j = 0; j < image_height; j++) {
                    str_pxl_data.append(huffmanCodes.get(img.getRGB(i, j)));
                }
            }
            String compressedPixelData = str_pxl_data.toString();
            
            // Save encoded data to file
            File binpath = new File(savepath, imageChooser.getImageFileName() + ".cmpimg"); // this is the file itself
            binpath.createNewFile();
            // BitSet bits = new BitSet(compressedPixelData.length());
            // int bitcounter = 0;
            //for(Character c : compressedPixelData.toCharArray()) {
            //    if(c.equals('1')) {
            //        bits.set(bitcounter);
            //    }
            //    bitcounter++;
            //}

            byte[] width = ByteBuffer.allocate(4).putInt(image_width).array(); // First 4 bytes is  width
            byte[] height = ByteBuffer.allocate(4).putInt(image_height).array(); // next 4 bytes is  height
            //byte[] bytes = new byte[(bits.length() + 7) / 8]; // then huffman coding
            byte[] bytes = new BigInteger(compressedPixelData, 2).toByteArray();
            //bytes = bits.toByteArray();
            OutputStream ostream = new FileOutputStream(binpath);
            ostream.write(width);
            ostream.write(height);
            ostream.write(bytes);
            ostream.close();

            System.out.println("This is from image encoder:");
            System.out.println("Image encoded successfully");
            // System.out.println(compressedPixelData);


        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }

}
