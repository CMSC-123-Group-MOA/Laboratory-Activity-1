package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import util.AppVariables;

public class ImagePanel extends JPanel {
    Image scaledImage;
    public ImagePanel() {
        super();
        initLayout();
    }

    private void initLayout() {
        setBorder(AppVariables.DEFAULT_BORDER);
    }

    public void renderImage(BufferedImage image) {
        Image temp = image;
        this.scaledImage = temp.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, null);
        System.out.println("Repainted!");
    }
}
