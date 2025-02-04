package huff;

import java.io.Serializable;

public class HuffmanNode implements Serializable{
        protected int frequency;
        protected int sRgb;
        protected HuffmanNode left;
        protected HuffmanNode right;
    
        public HuffmanNode(){
            frequency = 0;
            sRgb = 0;
            left = null;
            right = null;
        }
        protected HuffmanNode(int sRgb, int frequency) {
            this.sRgb = sRgb;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
    
}