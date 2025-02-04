package ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import util.ImageChooser;
import util.ImageDecoder;
import util.ImageEncoder;
import util.ImageTrainer;
import util.ResourceLoaders;

public class Controller {
    MainFrame mainFrame;
    ImagePanel imagePanel;
    ImageEncoder imageEncoder;
    ImageDecoder imageDecoder;
    ImageChooser imageChooser;
    ImageTrainer imageTrain;
    File defaultpath, imageFile;
    File hufPath, cmpPath;
    ResourceLoaders rloader;
    int loaded;

    public Controller(MainFrame mainFrame, File defaultpath) {
        this.mainFrame = mainFrame;
        this.defaultpath = defaultpath;
        loaded = 0;
        rloader = new ResourceLoaders(defaultpath);
    }

    public void addIP(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    /**
     * This is for the New Button
     * @throws IOException 
     */
    public void newFile() throws IOException {
        this.imageChooser = new ImageChooser(mainFrame, defaultpath);
        this.imageFile = imageChooser.returnImageFile();
        imagePanel.renderImage(imageChooser.returnBufferedImage());
        mainFrame.repaint();
        loaded = 1;
        JOptionPane.showMessageDialog(mainFrame, "Image Loaded Successfully!", "Operation Success", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("New button pressed");
    }

    /**
     * This is for the Train Button
     */
    public void train() {
        if (this.loaded < 1) {
            JOptionPane.showMessageDialog(mainFrame, "Cannot press this button yet!\nNo file image loaded.", "Cannot Invoke Operation", JOptionPane.ERROR_MESSAGE);
            return;
        }
        File path = rloader.chooseFolder(mainFrame, "Choose Output Directory");
        if (path == null) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid input. Terminating operation...", "Fatal Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.imageTrain = new ImageTrainer(imageChooser, path);
        loaded = 2;
        JOptionPane.showMessageDialog(mainFrame, "Huffman Tree Generated.\nFile has been saved.", "Operation Success", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Train button pressed");
    }

    /**
     * This is for the Compress button
     */
    public void compress() {
        if (loaded != 2) {
            JOptionPane.showMessageDialog(mainFrame, "Cannot press this button yet!\nNo image trained.", "Cannot Invoke Operation", JOptionPane.ERROR_MESSAGE);
            return;
        }
        File path = rloader.chooseFolder(mainFrame, "Choose Output Directory");
        if (path == null) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid input. Terminating operation...", "Fatal Error", JOptionPane.WARNING_MESSAGE);
        } else {
            this.imageEncoder = new ImageEncoder(imageFile, imageChooser, imageTrain, path);
        }
        loaded = 0;
        JOptionPane.showMessageDialog(mainFrame, "Compressed Image Successfully!", "Operation Success", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Compress button pressed");
    }

    /**
     * This is for the Open button
     */
    public void decode() {
        File hufPath = rloader.chooseFile(mainFrame, "Choose the .huf file", "Huffman File", "huf");
        File cmpPath = rloader.chooseFile(mainFrame, "Choose the .cmping file", "Compressed Image File", "cmpimg");
        if (hufPath == null || cmpPath == null) {
            JOptionPane.showMessageDialog(mainFrame, "Some files were not loaded!", "Cannot Invoke Operation", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BufferedImage recodedImage = ImageDecoder.decode(hufPath, cmpPath);
        imagePanel.renderImage(recodedImage);
        mainFrame.repaint();
        loaded = 0;
        JOptionPane.showMessageDialog(mainFrame, "Image Decoded!", "Operation Success", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Open button pressed");
    }

    public void exit() {
        mainFrame.dispose();
    }
}
