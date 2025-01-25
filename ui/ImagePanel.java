package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import util.AppVariables;

public class ImagePanel extends JPanel {
    BufferedImage image;
    public ImagePanel() {
        super();
        initLayout();
    }

    private void initLayout() {
        setBorder(AppVariables.DEFAULT_BORDER);
    }

    public void renderImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        System.out.println("Repainted!");
    }
}
