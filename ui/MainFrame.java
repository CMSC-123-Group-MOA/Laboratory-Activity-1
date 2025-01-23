package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

import util.*;

public class MainFrame extends JFrame {
    JPanel buttonsPanel = new JPanel();
    JPanel imagePanel = new JPanel();
    JButton add = new JButton();
    JButton compress = new JButton();
    JButton decompress = new JButton();
    JButton quit = new JButton();
    GridBagConstraints gbc = new GridBagConstraints();
    
    public MainFrame() {
        initLayout();
        addButtons();
        addButtonListeners();
        System.out.println();
    }

    private void initLayout() {
        Border lineborder = BorderFactory.createLineBorder(Color.BLACK, 3);
        setTitle(AppVariables.TITLE);
        getContentPane().setPreferredSize(new Dimension(1000, 800));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        imagePanel.setBorder(lineborder);
        buttonsPanel.setBorder(lineborder);
        add(imagePanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    private void addButtons() {
        buttonDesign(add, "ADD IMAGE");
        buttonDesign(compress, "COMPRESS");
        buttonDesign(decompress, "DECOMPRESS");
        buttonDesign(quit, "QUIT");


        buttonsPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 40);
        buttonsPanel.add(add, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 40, 40);
        buttonsPanel.add(compress, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 40, 40);
        buttonsPanel.add(decompress, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonsPanel.add(quit, gbc);
    }

    private void buttonDesign(JButton button, String buttonName) {
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setPreferredSize(new Dimension(150, 50));
        button.setBackground(Color.WHITE);
        button.setText(buttonName);
        button.setForeground(Color.BLACK);
    }

    private void addButtonListeners(){
        MouseAdapter addListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                new ImageChooser(buttonsPanel);
                System.out.println("add button pressed");
            }
        };

        MouseAdapter compressListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                System.out.println("compress button pressed");
            }
        };

        MouseAdapter decompressListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                System.out.println("decompress button pressed");
            }
        };

        MouseAdapter quitListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                dispose();
            }
        };

        add.addMouseListener(addListener);
        compress.addMouseListener(compressListener);
        decompress.addMouseListener(decompressListener);
        quit.addMouseListener(quitListener);
    }
    public void start() {
        pack();
        setVisible(true);
    }
}
