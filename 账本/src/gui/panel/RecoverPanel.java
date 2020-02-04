package gui.panel;

import javax.swing.*;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

import java.awt.*;
import java.awt.event.ActionListener;

public class RecoverPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    public static RecoverPanel instance = new RecoverPanel();

    public JButton bBackup =new JButton("备份");
    JLabel blank = new JLabel("               ");
    public JButton bRestore =new JButton("恢复");
    JPanel p = new JPanel();
    JPanel pp = new JPanel();

    public RecoverPanel() {

        GUIUtil.setColor(ColorUtil.blueColor, bBackup,bRestore);
        p.setSize(200,200);
        p.add(bBackup);
        p.add(blank);
        p.add(bRestore);
        setLayout(new GridLayout(3,1));
        add(pp);
        add(p);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void updateData() {
    }

    @Override
    public void addListener() {
        ActionListener l = new RecoverListener();
        bBackup.addActionListener(l);
        bRestore.addActionListener(l);
    }
}