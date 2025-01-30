package huff;

import java.util.Map;

public class HuffmanCoding {
    public static void generateCodes(HuffmanNode root, String code, Map<Integer, String> huffmanCodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.sRgb, code);
        }

        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    public static void reverseCodes(HuffmanNode root, String code, Map<String, Integer> huffmanCodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCodes.put(code, root.sRgb);
        }

        reverseCodes(root.left, code + "0", huffmanCodes);
        reverseCodes(root.right, code + "1", huffmanCodes);
    }

    // public static Integer decodeIndiv(HuffmanNode node, char[] hufcode, int movesRemaining) {
    //     if (node == null) {
    //         return null;
    //     }

    //     if (node.left == null && node.right == null) {
    //         return node.sRgb;
    //     }

        
    // }
}

