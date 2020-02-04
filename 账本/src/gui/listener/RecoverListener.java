package gui.listener;

import gui.panel.RecoverPanel;
import util.MysqlUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecoverPanel p = RecoverPanel.instance;
        JButton b = (JButton)e.getSource();
        if(p.bBackup==b){
            JFileChooser fc = new JFileChooser();
            fc.setSelectedFile(new File("bill.sql"));
            fc.setFileFilter(new FileFilter() {
                @Override
                public String getDescription() {
                    return ".sql";
                }
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".sql");
                }
            });
            int returnVal =  fc.showSaveDialog(p);
            File file = fc.getSelectedFile();
            System.out.println(file);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                //如果保存的文件名没有以.sql结尾，自动加上.sql
                System.out.println(file);
                if(!file.getName().toLowerCase().endsWith(".sql"))
                    file = new File(file.getParent(),file.getName()+".sql");
                System.out.println(file);

                try {
                    MysqlUtil.backup(file.getAbsolutePath());
                    JOptionPane.showMessageDialog(p, "备份成功,备份文件位于:\r\n"+file.getAbsolutePath());
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(p, "备份失败\r\n,错误:\r\n"+e1.getMessage());
                }
            }
        }
        if(b==p.bRestore){
            JFileChooser fc = new JFileChooser();
            fc.setSelectedFile(new File("bill.sql"));
            fc.setFileFilter(new FileFilter() {
                @Override
                public String getDescription() {
                    return ".sql";
                }
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".sql");
                }
            });

            int returnVal =  fc.showOpenDialog(p);
            File file = fc.getSelectedFile();
            System.out.println(file);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    MysqlUtil.restore(file.getAbsolutePath());
//              MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
                    JOptionPane.showMessageDialog(p, "恢复成功");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(p, "恢复失败\r\n,错误:\r\n"+e1.getMessage());
                }

            }
        }

    }
}
