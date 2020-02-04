package gui.listener;

import entity.Login;
import gui.frame.FirstFrame;
import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import service.FirstService;
import util.FileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FirstFrame f = FirstFrame.instance;
        JButton b = (JButton) e.getSource();
        Login login = new Login();
        if(f.bSubmit==b) {
            login.loginName = f.tfLoginName.getText();
            if (0 == login.loginName.length()) {
                JOptionPane.showMessageDialog(f, "用户名不能为空");
                return;
            }
            login.password = f.tfPassword.getText();
            if (0 == login.password.length()) {
                JOptionPane.showMessageDialog(f, "密码不能为空");
                return;
            }
            login.databaseName = f.tfDatabaseName.getText();
            if (0 == login.databaseName.length()) {
                JOptionPane.showMessageDialog(f, "数据库名称不能为空");
                return;
            }
            if(FirstService.isConnect(login)){
                String message = "连接成功，\n" +
                        "设定档已保存至"+FileUtil.path+"，\n" +
                        "可到【设置】中查看登陆信息。\n\n已自动为您建表";
                JOptionPane.showMessageDialog(f, message);
                FileUtil.writeSetting(login);
                FirstService.createTable();
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
                FirstFrame.instance.dispose();
            }
            else {
                String s = "登陆失败，请核对以下内容\n" +
                        "1.请先确认电脑已安装mysql服务。\n" +
                        "2.连接mysql的用户名和密码无误\n" +
                        "3.若mysql中无database，请先手动创建database\n";
                JOptionPane.showMessageDialog(f, s);
            }
        }
    }
}
