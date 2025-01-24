package util;
import java.util.HashMap;
import java.util.Map;

import huff.HuffEncoder;
import huff.HuffmanCoding;
import huff.bintree.HuffmanNode;

public class FrequencyCounter {
    HashMap<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
    int frequencyCount[];
    int colorCount;
    public FrequencyCounter(int[][] data, int width, int height){
        colorCount = 0;
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if(colorMap.get(data[x][y]) == null){
                    colorMap.put(data[x][y], colorCount);
                    colorCount++;
                }
            }
            System.out.println("hi");
        }
        System.out.println("done input");
        System.out.println("Mapping of colors: " + colorMap);
        frequencyCount = new int[colorMap.size()];

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                frequencyCount[colorMap.getOrDefault(data[x][y], 0)]++;  
            } 
            System.out.println("hello");
        }
        System.out.println(" done1");
        System.out.println("Number of Colors: " + colorMap.size());
        for(int i = 0; i < frequencyCount.length; i++){
            System.out.println("Color Key: " + i + " Frequency: " + frequencyCount[i]);
        }
        
        HuffEncoder huff = new HuffEncoder();
        HuffmanNode root = HuffEncoder.buildTree(frequencyCount);
        Map<Integer, String> huffmanCodes = new HashMap<>();
        HuffmanCoding.generateCodes(root, "", huffmanCodes);

        System.out.println("Huffman Codes: " + huffmanCodes);
    }    
}
