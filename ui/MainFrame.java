package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.Border;

import util.AppVariables;

public class MainFrame extends JFrame {
    JPanel buttonsPanel = new JPanel();
    JButton add = new JButton();
    JButton compress = new JButton();
    JButton decompress = new JButton();
    JButton quit = new JButton();
    GridBagConstraints gbc = new GridBagConstraints();

    public MainFrame() {
        initLayout();
        addButtons();
    }

    private void initLayout() {
        setTitle(AppVariables.TITLE);
        getContentPane().setPreferredSize(new Dimension(1000, 800));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
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

    public void start() {
        pack();
        setVisible(true);
    }
}
