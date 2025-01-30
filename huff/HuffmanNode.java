package huff;

public class HuffmanNode{
        protected int frequency;
        protected int sRgb;
        protected HuffmanNode left;
        protected HuffmanNode right;
    
        protected HuffmanNode(int sRgb, int frequency) {
            this.sRgb = sRgb;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
    
}