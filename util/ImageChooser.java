package util;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FileChooser
 */
public class ImageChooser {
    File file;
    ImageNew processedImage;
    public ImageChooser(Component parent){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "bmp", "jpeg");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setName("Open New File");
        
        int response = fileChooser.showOpenDialog(parent);

        if(response == JFileChooser.APPROVE_OPTION){
            this.file = fileChooser.getSelectedFile();
            this.processedImage = new ImageNew(file);
        }

    }
    public BufferedImage returnBufferedImage() throws IOException{
        BufferedImage bufferedImage = ImageIO.read(file);
        return bufferedImage;
    }
    public int[][] returnPixelData(){
        return processedImage.returnPixelData();
    }
    public int[] returnFrequencyData(){
        return processedImage.returnFrequencyData();
    }
    public File returnImageFile(){
        return file;
    }
    public HashMap<Integer, Integer> returnColorMap(){
        return processedImage.returnColorMap();
    }

}
