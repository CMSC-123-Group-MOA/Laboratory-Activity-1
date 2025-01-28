package util;

import java.awt.Container;
import java.io.File;
import java.io.InputStream;

import javax.swing.JFileChooser;

public class ResourceLoaders {
    public ClassLoader classLoader = getClass().getClassLoader();

    /**
     * Loads a given resource using the relative path. Returns an InputStream.
     * @param relativePath - the relative path, uses forward slash.
     * @return {@code InputStream} based on the relative path given
     */
    public InputStream loadResource(String relativePath) {
        return classLoader.getResourceAsStream(relativePath);
    }

    public File chooseFolder(Container parent) {
        JFileChooser choose = new JFileChooser();
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = choose.showOpenDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            return choose.getSelectedFile();
        } else {
            return null;
        }
    }
}
