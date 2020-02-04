package gui.panel;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Login;
import gui.listener.ConfigListener;
import service.ConfigService;
import service.LoginService;
import util.ColorUtil;
import util.DBUtil;
import util.FileUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("本月预算(￥):          ");
    public JTextField tfBudget = new JTextField(" ");
    JButton bSubmit = new JButton("更新");
    Login login = DBUtil.login;
    public JLabel lMyBudgt = new JLabel("本月的预算为:"+new ConfigService().get(ConfigService.budget));
    JLabel lMysql = new JLabel("Mysql安装目录:"+ LoginService.getMysql()+"\n\n");
    JLabel lUserName = new JLabel("连接mysql的用户名为:"+ login.loginName+"\n\n");
    JLabel lPassword = new JLabel("连接mysql的密码为:"+ login.password+"\n\n");
    JLabel lDatabaseName = new JLabel("连接的数据库为:"+ login.databaseName+"\n\n");
    JLabel lSettingPath = new JLabel("设定文件:"+ FileUtil.path);
    JPanel pInput =new JPanel();
    public JPanel pRemind = new JPanel();




    public ConfigPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);

        tfBudget.setPreferredSize(new Dimension(100, 25));
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(bSubmit);
        pRemind.setLayout(new GridLayout(6,1,10,10));
        pRemind.add(lMyBudgt);
        pRemind.add(lSettingPath);
        pRemind.add(lUserName);
        pRemind.add(lPassword);
        pRemind.add(lDatabaseName);
        pRemind.add(lMysql);
        setLayout(new GridLayout(2,1,1,1));
        add(pInput);
        add(pRemind);
        addListener();
    }
    public void update(){
        lMyBudgt.setText("本月的预算为:"+new ConfigService().get(ConfigService.budget));
        pRemind.remove(0);
        pRemind.add(lMyBudgt,0);
        remove(pRemind);
        add(pRemind);
        repaint();
    }

    public static void main(String[] args)
    {
        GUIUtil.showPanel(ConfigPanel.instance);
    }

    @Override
    public void updateData() {
        lMyBudgt = new JLabel("本月的预算为:"+new ConfigService().get(ConfigService.budget));
    }

    @Override
    public void addListener() {
        ActionListener l = new ConfigListener();
        bSubmit.addActionListener(l);
    }
}