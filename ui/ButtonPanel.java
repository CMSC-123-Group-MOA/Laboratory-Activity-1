package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import util.AppVariables;
import util.GBCUtils;

public class ButtonPanel extends JPanel{
    JButton add = new JButton();
    JButton train = new JButton();
    JButton compress = new JButton();
    JButton decode = new JButton();
    JButton quit = new JButton();
    GridBagConstraints gbc = new GridBagConstraints();
    GBCUtils gbcu = new GBCUtils(gbc);
    Controller controller;

    public ButtonPanel(Controller controller) {
        this.controller = controller;
        initLayout();
        addButtons();
        addButtonListeners();
    }

    private void initLayout() {
        setBorder(AppVariables.DEFAULT_BORDER);
    }

    private void addButtons() {
        buttonDesign(add, "NEW");
        buttonDesign(train, "TRAIN");
        buttonDesign(compress, "COMPRESS");
        buttonDesign(decode, "OPEN");
        buttonDesign(quit, "QUIT");


        setLayout(new GridBagLayout());
        gbcu.setGBC(0, 0, new Insets(0, 40, 40, 40));
        add(add, gbc);
        gbcu.addY();
        add(train, gbc);
        gbcu.addY();
        add(compress, gbc);
        gbcu.addY();
        add(decode, gbc);
        gbcu.addY();
        add(quit, gbc);
    }

    private void buttonDesign(JButton button, String buttonName) {
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setPreferredSize(AppVariables.BUTTON_DIMENSION);
        button.setBackground(Color.WHITE);
        button.setText(buttonName);
        button.setForeground(Color.BLACK);
    }

    private void addButtonListeners(){
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                try {
                    controller.newFile();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        train.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                controller.train();
            }
        });
        compress.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                controller.compress();
            }
        });
        decode.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                controller.decode();
            }
        });
        quit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                controller.exit();
            }
        });
    }
}
