package util;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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
            // freqMap = decodeBinHuf(hufPath); // decode based on bin method
            
            // freqMap = decodeObjHuf(hufPath); // decoe based on obj method
            // hufftree = HuffEncoder.buildTree(freqMap);
            hufftree = decodeTreeHuf(hufPath);
            HuffmanCoding.reverseCodes(hufftree, "", huffMap);

            // Decode .cmpimg file
            DataInputStream imgbin = new DataInputStream(new FileInputStream(cmpPath));
            int image_width = imgbin.readInt(), image_height = imgbin.readInt(); // read the first 8 bytes to get the width and height of image
            //char[] hcArray = toBinary(imgbin.readAllBytes()).toCharArray();

            // char[] hcArray = new BigInteger(imgbin.readAllBytes()).toString(2).toCharArray(); // use bigint class to do it
            char[] hcArray = bytesToBinString(imgbin.readAllBytes()).toCharArray();
            System.err.println("Decoded Binary String Length: " + hcArray.length);
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
            System.out.println("this is from imagedecoder:");
            // System.out.println(hcArray);
            System.out.println(hcArray.length - offset);

        } catch (IOException ie) {
            // bro....
            ie.printStackTrace();
        }

        return decodedImage;
    }

    private static HashMap<Integer, Integer> decodeBinHuf(File hufPath) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        try {
            DataInputStream hufbin = new DataInputStream(new FileInputStream(hufPath));
            int hmsize = hufbin.readInt(); // reads the first 4 bytes to get int of how many key-value pairs there are
            for (int i = 0; i < hmsize; i++) {
                freqMap.put(hufbin.readInt(), hufbin.readInt()); // reads the next ints in pairs to output
            }
            hufbin.close();
        } catch (IOException e) {
            // hmm
            e.printStackTrace();
        }
        return freqMap;
    }

    @SuppressWarnings("unchecked")
    private static HashMap<Integer, Integer> decodeObjHuf(File hufpath) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        try {
            ObjectInputStream hufbin = new ObjectInputStream(new FileInputStream(hufpath));
            freqMap = (HashMap<Integer, Integer>) hufbin.readObject();
            hufbin.close();
        } catch (IOException ie) {
            // uhhhh
            ie.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            // uh oh
            cnfe.printStackTrace();
        }
        return freqMap;
    }

    private static HuffmanNode decodeTreeHuf(File hufpath) {
        HuffmanNode root = new HuffmanNode();
        try {
            ObjectInputStream hufbin = new ObjectInputStream(new FileInputStream(hufpath));
            root = (HuffmanNode) hufbin.readObject();
            hufbin.close();
        } catch (IOException ie) {
            // uhhhh
            ie.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            // uh oh
            cnfe.printStackTrace();
        }
        return root;
    }

    private static String bytesToBinString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }

}
