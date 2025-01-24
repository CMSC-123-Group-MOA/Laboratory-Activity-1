package huff.bintree;

public class LeafNode extends Node {
    private final int srgbVal;

    public LeafNode(int srgbVal, int frequency) {
        super(frequency);
        this.srgbVal = srgbVal;
    }

    public int getSRGBval() {
        return srgbVal;
    }
}
