package util;

import java.awt.Container;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        return chooseFile(parent, text, "", "");
    }

    public File chooseFile(Container parent, String text, String filterDescription, String extFilters) {
        JFileChooser choose = new JFileChooser(defaultdir);
        if (!filterDescription.isEmpty() && !extFilters.isEmpty()) {
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter(filterDescription, extFilters);
            choose.setFileFilter(fileFilter);
        }
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
