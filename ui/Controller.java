package ui;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import util.ImageChooser;
import util.ImageEncoder;
import util.ImageTrainer;
import util.ResourceLoaders;

public class Controller {
    MainFrame mainFrame;
    ImagePanel imagePanel;
    ImageEncoder imageEncoder;
    ImageChooser imageChooser;
    ImageTrainer imageTrain;
    File defaultpath, imageFile;
    ResourceLoaders rloader;

    public Controller(MainFrame mainFrame, File defaultpath) {
        this.mainFrame = mainFrame;
        this.defaultpath = defaultpath;
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
        System.out.println("New button pressed");
    }

    /**
     * This is for the Train Button
     */
    public void train() {
        this.imageTrain = new ImageTrainer(imageChooser);
        System.out.println("Train button pressed");
    }

    /**
     * This is for the Compress button
     */
    public void compress() {
        File path = rloader.chooseFolder(mainFrame);
        if (path == null) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid input. Terminating operation...", "Fatal Error", JOptionPane.WARNING_MESSAGE);
        } else {
            this.imageEncoder = new ImageEncoder(imageFile, imageChooser, imageTrain, path);
        }
        
        System.out.println("Compress button pressed");
    }

    /**
     * This is for the Open button
     */
    public void decode() {
        System.out.println("Open button pressed");
    }

    public void exit() {
        mainFrame.dispose();
    }
}
