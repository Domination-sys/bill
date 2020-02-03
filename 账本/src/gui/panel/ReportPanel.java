package gui.panel;

import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    public static ReportPanel instance = new ReportPanel();
    static {
        GUIUtil.useLNF();
    }
    public JLabel l = new JLabel();

    public ReportPanel(){
        this.setLayout(new BorderLayout());
        Image i = ChartUtil.getImage(350,200);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        add(l);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }
}
