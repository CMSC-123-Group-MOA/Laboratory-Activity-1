package util;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * FileChooser
 */
public class ImageChooser {
    public ImageChooser(Component parent){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "bmp", "jpeg");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setName("Open New File");
        
        int response = fileChooser.showOpenDialog(parent);

        if(response == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            ImageEncoder encoder = new ImageEncoder(file);
        }

    }
}
