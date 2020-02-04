package gui.listener;

import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;
        if(!GUIUtil.checkNumber(p.tfBudget,"本月预算"))
            return;
        ConfigService cs= new ConfigService();
        cs.update(ConfigService.budget,p.tfBudget.getText());
        JOptionPane.showMessageDialog(p, "设置修改成功");
        p.update();
        MainPanel.instance.workingPanel.show(ConfigPanel.instance);

    }
}
