package com.hecvoj;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class HowTo{
    JFrame HowTo = new JFrame("How to use this program");
    HowTo(){
        HowTo.setSize(1200,800);
        HowTo.setLocation(50,50);
        HowTo.setVisible(true);
        HowTo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        drawInfo();

        HowTo.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Interface i = new Interface();
                e.getWindow().dispose();
            }
        });
    }

    private void drawInfo() {
        JLabel mainInfo = new JLabel("This window is WIP. Please close to move to the main program :)");
        mainInfo.setFont(new Font("Calibri", Font.BOLD, 30));
        //mainInfo.setBounds(0,0,90,60);
        mainInfo.setVisible(true);
        HowTo.add(mainInfo);
    }
}
