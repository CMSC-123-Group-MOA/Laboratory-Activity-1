package ui;

import javax.swing.JPanel;

import util.AppVariables;

public class ImagePanel extends JPanel {
    public ImagePanel() {
        super();
        initLayout();
    }

    private void initLayout() {
        setBorder(AppVariables.DEFAULT_BORDER);
    }

    public void renderImage() {
        // TODO: Add renderer implementation here.
    }
}
