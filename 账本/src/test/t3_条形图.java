package test;

import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class t3_条形图 {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        Image img = ChartUtil.getImage(400, 300);
        Icon icon = new ImageIcon(img);
        l.setIcon(icon);
        p.add(l);
        GUIUtil.showPanel(p);
    }
}
