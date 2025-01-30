package util;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageChooser {
    private File file;
    private ImageNew processedImage;
    public ImageChooser(Component parent, File defaultDir){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "bmp", "jpeg");
        JFileChooser fileChooser = new JFileChooser(defaultDir);
        fileChooser.setFileFilter(filter);
        fileChooser.setName("Open New File");
        
        int response = fileChooser.showOpenDialog(parent);

        if(response == JFileChooser.APPROVE_OPTION){
            this.file = fileChooser.getSelectedFile();
            this.processedImage = new ImageNew(file);
        } else {
            JOptionPane.showMessageDialog(parent, "Invalid option. Operation has been cancelled.", 
                                    "Invalid Operation", JOptionPane.ERROR_MESSAGE);
        }

    }
    public BufferedImage returnBufferedImage() throws IOException{
        BufferedImage bufferedImage = ImageIO.read(file);
        return bufferedImage;
    }
    public int[][] returnPixelData(){
        return processedImage.returnPixelData();
    }

    public File returnImageFile(){
        return file;
    }

    public String getImageFileName() {
        return file.getName().substring(0, file.getName().lastIndexOf('.'));
    }

    public HashMap<Integer, Integer> returnColorMap(){
        return processedImage.returnColorMap();
    }

}
