package huff;

import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
        private HashMap<Integer, Integer> colorMap;
        private Map<Integer, String> huffmanCodes;
        private HuffEncoder huff;
        private HuffmanNode root;
        
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
