package util;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
/**
 * FileChooser
 */
public class ImageChooser {
    public ImageChooser(Component parent){
        JFileChooser fileChooser = new JFileChooser();
        
        int response = fileChooser.showOpenDialog(parent);

        if(response == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            ImageEncoder encoder = new ImageEncoder(file);
        }

    }
}
