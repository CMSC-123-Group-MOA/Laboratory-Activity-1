package util;

import java.awt.Container;
import java.io.File;

import javax.swing.JFileChooser;

public class ResourceLoaders {
    public File defaultdir;

    public ResourceLoaders(File defaultdir) {
        this.defaultdir = defaultdir;
    }

    public File chooseFolder(Container parent, String text) {
        JFileChooser choose = new JFileChooser(defaultdir);
        choose.setDialogTitle(text);
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = choose.showOpenDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            return choose.getSelectedFile();
        } else {
            return null;
        }
    }

    public File chooseFile(Container parent, String text) {
        JFileChooser choose = new JFileChooser(defaultdir);
        choose.setDialogTitle(text);
        choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int option = choose.showOpenDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            return choose.getSelectedFile();
        } else {
            return null;
        }
    }
}
