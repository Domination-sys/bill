package test;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class t2_环形进度条 {
    public static void main(String[] args) {
        GUIUtil.useLNF();
        JPanel p = new JPanel();
        CircleProgressBar c = new CircleProgressBar();
        c.setBackgroundColor(ColorUtil.blueColor);
        c.setProgress(0);
        JButton b = new JButton("点击");
        p.setLayout(new BorderLayout());
        p.add(c,BorderLayout.CENTER);
        p.add(b,BorderLayout.SOUTH);
        GUIUtil.showPanel(p);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SwingWorker(){
                    @Override
                    protected Object doInBackground() throws Exception {
                        for(int i=1;i<=100;i++){
                            c.setProgress(i);
                            c.setForegroundColor(ColorUtil.getByPercentage(i));
                            Thread.sleep(100);
                        }
                        return null;
                    }
                }.execute();
            }
        });


    }
}
