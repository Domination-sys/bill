package gui.frame;

import gui.listener.FirstListener;
import gui.panel.MainPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class FirstFrame extends JFrame {
    public static FirstFrame instance = new FirstFrame();
    public JButton bSubmit = new JButton("login");
    JLabel lLoginName = new JLabel("     loginName:    ");
    public JTextField tfLoginName = new JTextField("");
    JLabel lPassword = new JLabel("      password:    ");
    public JTextField tfPassword = new JTextField("");
    JLabel lDatabaseName = new JLabel("databaseName:  ");
    public JTextField tfDatabaseName = new JTextField("");

    static {
        GUIUtil.useLNF();
    }
    public FirstFrame(){
        setSize(300,200);
        setLayout(new FlowLayout());

        bSubmit.addActionListener(new FirstListener());

        tfLoginName.setText("");
        tfLoginName.setPreferredSize(new Dimension(100, 25));
        tfPassword.setText("");
        tfPassword.setPreferredSize(new Dimension(100, 25));
        tfDatabaseName.setPreferredSize(new Dimension(100, 25));

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        p1.add(lLoginName);
        p1.add(tfLoginName);
        p2.add(lPassword);
        p2.add(tfPassword);
        p3.add(lDatabaseName);
        p3.add(tfDatabaseName);
        p4.add(bSubmit);
        setLayout(new GridLayout(4,1));
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        setTitle("请登录您的数据库");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}
