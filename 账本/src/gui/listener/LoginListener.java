package gui.listener;

import entity.Login;
import gui.frame.FirstFrame;
import gui.frame.MainFrame;
import gui.panel.LoginPanel;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import service.FirstService;
import util.DBUtil;
import util.FileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        LoginPanel p = LoginPanel.instance;
        Login login = new Login();
        login.loginName = p.tfUserName.getText();
        if (0 == login.loginName.length()) {
            JOptionPane.showMessageDialog(p, "用户名不能为空");
            return;
        }
        login.password = p.tfPassword.getText();
        if (0 == login.password.length()) {
            JOptionPane.showMessageDialog(p, "密码不能为空");
            return;
        }
        login.databaseName = p.tfDBname.getText();
        if (0 == login.databaseName.length()) {
            JOptionPane.showMessageDialog(p, "数据库名称不能为空");
            return;
        }
        if (FirstService.isConnect(login)) {
            FirstService.createTable();
            String message = "连接成功，\n" +
                    "设定信息已更新\n" +
                    "可到【设置】中查看登陆信息。\n\n已自动为您建表";
            JOptionPane.showMessageDialog(p, message);
            FileUtil.writeSetting(login);
            MainFrame.instance.repaint();
            MainFrame.instance.setVisible(true);
            MainPanel.instance.workingPanel.show(SpendPanel.instance);
        }else {
            JOptionPane.showMessageDialog(p, "连接失败，请重新输入您的信息");
        }
    }

}
