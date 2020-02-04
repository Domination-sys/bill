package gui.panel;

import javax.swing.*;

import entity.Record;
import gui.listener.LoginListener;
import util.ColorUtil;
import util.GUIUtil;

import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }

    public static LoginPanel instance = new LoginPanel();

    JLabel lUserName = new JLabel("Mysql用户名");
    public JTextField tfUserName = new JTextField("");

    JLabel lPassword = new JLabel("Mysql密码");
    public JTextField tfPassword = new JTextField("");

    JLabel lDBname = new JLabel("Database名称");
    public JTextField tfDBname = new JTextField("");

    public JButton bSubmit = new JButton("提交");



    public LoginPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lUserName,lPassword,lDBname);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);

        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        JPanel pRemind = new JPanel();
        int gap =20;
        pInput.setLayout(new GridLayout(6,1,gap,gap));

        pInput.add(lUserName);
        pInput.add(tfUserName);
        pInput.add(lPassword);
        pInput.add(tfPassword);
        pInput.add(lDBname);
        pInput.add(tfDBname);
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);


        pSubmit.add(bSubmit);
        this.add(pSubmit,BorderLayout.CENTER);

        this.addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(LoginPanel.instance);
    }

    @Override
    public void updateData() {
    }

    @Override
    public void addListener() {
        bSubmit.addActionListener(new LoginListener());
    }
}