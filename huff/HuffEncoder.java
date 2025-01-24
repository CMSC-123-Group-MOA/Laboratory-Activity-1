package huff;

import java.util.Comparator;
import java.util.PriorityQueue;

import huff.bintree.HuffmanNode;

public class HuffEncoder {
    public static HuffmanNode buildTree(int[] pixelFrequencies){
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        for (char i = 0; i < pixelFrequencies.length; i++) {
            if (pixelFrequencies[i] > 0) {
                priorityQueue.add(new HuffmanNode(i, pixelFrequencies[i]));
            }
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            priorityQueue.add(parent);
        }

        return priorityQueue.poll();

    }
}
