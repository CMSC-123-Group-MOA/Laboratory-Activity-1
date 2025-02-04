package ui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.*;

import util.*;

public class MainFrame extends JFrame {
    ButtonPanel buttonsPanel;
    ImagePanel imagePanel;
    Controller controller;
    
    public MainFrame(File currpath) {
        controller = new Controller(this, currpath);
        initLayout();
        
        buttonsPanel = new ButtonPanel(controller);
        imagePanel = new ImagePanel();
        controller.addIP(imagePanel);

        addPanels();
        System.out.println();
    }

    private void initLayout() {
        setTitle(AppVariables.TITLE);
        getContentPane().setPreferredSize(AppVariables.DEFAULT_DIMENSION);
        // setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void addPanels() {
        add(imagePanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    public void start() {
        pack();
        setVisible(true);
    }
}
