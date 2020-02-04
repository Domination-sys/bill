package gui.frame;

import gui.panel.MainPanel;
import util.GUIUtil;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();
    static {
        GUIUtil.useLNF();
    }
    public MainFrame(){
        setSize(450,500);
        setTitle("攒钱谈恋爱 1.0");
        setContentPane(MainPanel.instance);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
       new MainFrame();
    }
}
