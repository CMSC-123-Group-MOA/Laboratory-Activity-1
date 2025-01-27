package huff;

import java.util.HashMap;
import java.util.Map;

import huff.bintree.HuffmanNode;

public class HuffmanTree {
        HashMap<Integer, Integer> colorMap;
        Map<Integer, String> huffmanCodes;
        HuffEncoder huff;
        HuffmanNode root;
        
    public HuffmanTree(int[] pixelFrequencies){
        this.huff = new HuffEncoder();
        this.root = HuffEncoder.buildTree(pixelFrequencies);
        this.huffmanCodes = new HashMap<>();
    }
    public HuffmanNode returnRoot(){
        return root;
    }
    public void setColorMap(HashMap<Integer, Integer> colorMap){
        this.colorMap = colorMap;
    }
}
