package util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBCUtils {
    GridBagConstraints gbc;

    public GBCUtils(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public void setGBC(int gridx, int gridy, Insets insets, int anchor){
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = insets;
        gbc.anchor = anchor;
    }

    public void setGBC(int gridx, int gridy, Insets insets){
        setGBC(gridx, gridy, insets, gbc.anchor);
    }

    public void setGBC(int gridx, int gridy){
        setGBC(gridx, gridy, gbc.insets, gbc.anchor);
    }

    public void addX(){
        gbc.gridx++;
    }

    public void addY() {
        gbc.gridy++;
    }
}
