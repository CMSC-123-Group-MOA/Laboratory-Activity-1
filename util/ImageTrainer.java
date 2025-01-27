package util;

import java.util.HashMap;
import java.util.Map;

import huff.HuffEncoder;
import huff.HuffmanCoding;
import huff.bintree.HuffmanNode;

public class ImageTrainer {
    Map<Integer, String> huffmanCodes;


    public ImageTrainer(ImageChooser imageChooser){
        // Make Huffman tree 
        new HuffEncoder();
        HuffmanNode root = HuffEncoder.buildTree(imageChooser.returnFrequencyData());
        this.huffmanCodes = new HashMap<>();
            
        // Generate binary code from huffmantree
        HuffmanCoding.generateCodes(root, "", huffmanCodes);
        System.out.println("Huffman Codes: " + huffmanCodes);
    }

    public Map<Integer, String> returnHuffCodes(){
        return huffmanCodes;
    }
}
