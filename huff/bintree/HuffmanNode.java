package huff.bintree;

public class HuffmanNode{
        public int frequency;
        public int sRgb;
        public HuffmanNode left;
        public HuffmanNode right;
    
        public HuffmanNode(int sRgb, int frequency) {
            this.sRgb = sRgb;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
    
}