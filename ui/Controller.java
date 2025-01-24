package ui;

import java.io.File;

import util.ImageChooser;
import util.ImageEncoder;

public class Controller {
    MainFrame mainFrame;
    ImagePanel imagePanel;
    ImageEncoder imageEncoder;
    File imageFile;

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void addIP(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    /**
     * This is for the New Button
     */
    public void newFile() {
        new ImageChooser(mainFrame);
        System.out.println("New button pressed");
    }

    /**
     * This is for the Train Button
     */
    public void train() {
        System.out.println("Train button pressed");
    }

    /**
     * This is for the Compress button
     */
    public void compress() {
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
