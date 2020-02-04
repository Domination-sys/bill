package startup;

import gui.frame.FirstFrame;
import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import service.FirstService;
import util.DBUtil;
import util.GUIUtil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIUtil.useLNF();
        if(!FirstService.isLanded())
            FirstFrame.instance.setVisible(true);
        else {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    MainFrame.instance.setVisible(true);
                    MainPanel.instance.workingPanel.show(SpendPanel.instance);
                }
            });
        }
    }
}
