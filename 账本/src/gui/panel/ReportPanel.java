package gui.panel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ReportPanel extends WorkingPanel {
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

    @Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}
