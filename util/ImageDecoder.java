package util;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import huff.HuffEncoder;
import huff.HuffmanCoding;
import huff.HuffmanNode;

public class ImageDecoder {
    public static BufferedImage decode(File hufPath, File cmpPath) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        BufferedImage decodedImage = null;
        HuffmanNode hufftree;
        Map<String, Integer> huffMap = new HashMap<>();

        try {
            // Decode .huf file
            DataInputStream hufbin = new DataInputStream(new FileInputStream(hufPath));
            int hmsize = hufbin.readInt(); // reads the first 4 bytes to get int of how many key-value pairs there are
            for (int i = 0; i < hmsize; i++) {
                freqMap.put(hufbin.readInt(), hufbin.readInt()); // reads the next ints in pairs to output
            }
            hufbin.close();
            hufftree = HuffEncoder.buildTree(freqMap);
            HuffmanCoding.reverseCodes(hufftree, "", huffMap);

            // Decode .cmpimg file
            DataInputStream imgbin = new DataInputStream(new FileInputStream(cmpPath));
            int image_width = imgbin.readInt(), image_height = imgbin.readInt(); // read the first 8 bytes to get the width and height of image
            char[] hcArray = toBinary(imgbin.readAllBytes()).toCharArray();
            imgbin.close();
            decodedImage = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_ARGB);
            int offset = 0;
            for (int x = 0; x < image_width; x++) {
                for (int y = 0; y < image_height; y++) {
                    StringBuilder hcd = new StringBuilder();
                    hcd.append(hcArray[offset]);
                    offset++;
                    while ( !huffMap.containsKey(hcd.toString()) ) {
                        hcd.append(hcArray[offset]);
                        offset++;
                    }
                    decodedImage.setRGB(x, y, huffMap.get(hcd.toString()));
                }
            }
        } catch (IOException ie) {
            // bro....
            ie.printStackTrace();
        }

        return decodedImage;
    }

    private static String toBinary( byte[] bytes ) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }
}
