package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import huff.HuffEncoder;
import huff.HuffmanCoding;
import huff.HuffmanNode;

public class ImageTrainer {
    private Map<Integer, String> huffmanCodes;

    public ImageTrainer(ImageChooser imageChooser, File path){
        // Make Huffman tree 
        new HuffEncoder();
        HuffmanNode root = HuffEncoder.buildTree(imageChooser.returnColorMap());
        this.huffmanCodes = new HashMap<>();
            
        // Generate binary code from huffmantree
        HuffmanCoding.generateCodes(root, "", huffmanCodes);
        // System.out.println("Huffman Codes: " + huffmanCodes);

        try {
            File savepath = new File(path, imageChooser.getImageFileName() + ".huf");
            savepath.createNewFile();
            // binWriteToHUF(imageChooser.returnColorMap(), savepath); // This is for writing to .huf as binary data
            objWriteToHUF(imageChooser.returnColorMap(), savepath); // This is for writing to .huf as object data
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("errr...");
            e.printStackTrace();
        }
    }

    private void binWriteToHUF(HashMap<Integer, Integer> colorMap, File savepath) {
        try {
            OutputStream out = new FileOutputStream(savepath);
            DataOutputStream dataOutputStream = new DataOutputStream(out);
            //out.write(ByteBuffer.allocate(4).putInt(colorMap.size()).array()); // first 4 bytes store how many key-value pairs exist
            dataOutputStream.writeInt(colorMap.size());
            colorMap.forEach(
                (sRGB, freq) -> {
                    try {
                        //out.write(ByteBuffer.allocate(4).putInt(sRGB).array()); // 4 bytes of sRGB
                        //out.write(ByteBuffer.allocate(4).putInt(freq).array()); // 4 bytes of freq
                        dataOutputStream.writeInt(sRGB);
                        dataOutputStream.writeInt(freq);
                        // System.out.println("sRGB: " + sRGB + "  freq:" + freq);
                    } catch (IOException e) {
                        // Dear god...
                        e.printStackTrace();
                    }
                });
            out.flush();
            out.close();
        } catch (IOException ie) {
            // How many...?
            ie.printStackTrace();
        }
    }

    private void objWriteToHUF(HashMap<Integer, Integer> colorMap, File savepath) {
        try {
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(savepath));
            objOut.writeObject(colorMap);
            objOut.reset();
            objOut.close();
        } catch (IOException ie) {
            // breh
            ie.printStackTrace();
        }
    }

    public Map<Integer, String> returnHuffCodes(){
        return huffmanCodes;
    }
}
