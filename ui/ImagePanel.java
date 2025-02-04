package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import util.AppVariables;
import java.math.BigDecimal;

public class ImagePanel extends JPanel {
    Image scaledImage;
    int x = 0, y = 0;
    public ImagePanel() {
        super();
        initLayout();
    }

    private void initLayout() {
        setBorder(AppVariables.DEFAULT_BORDER);
    }

    public void renderImage(BufferedImage image) {
        Image temp = image;
        float height = image.getHeight();
        float width = image.getWidth();
        System.out.println("Width: " + width + " Height: " + height);

        if(height >= width){
            System.out.println("Scaled to height");
            System.out.println("Height of Panel " +  getHeight());
            double scaleFactor = getHeight() / height;
            int scaledWidth = (int) (width * scaleFactor);
            System.out.println("Scaled to width : " + scaleFactor + " scaledHeight: " + scaledWidth);
            this.scaledImage = temp.getScaledInstance(scaledWidth, getHeight(), Image.SCALE_SMOOTH);
            this.x = (getHeight() - scaledWidth)/2;
        } else{
            System.out.println("Scaled to width");
            System.out.println("Width of Panel " +  getWidth());
            double scaleFactor = getWidth() / width;
            int scaledHeight = (int) (height * scaleFactor);
            System.out.println("Scaled to width : " + scaleFactor + " scaledHeight: " + scaledHeight);
            this.scaledImage = temp.getScaledInstance(getWidth(), scaledHeight, Image.SCALE_SMOOTH);

            this.y = (getHeight() - scaledHeight)/2;
        }

        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(scaledImage, x, y, null);
        System.out.println("Repainted!");
    }
}
