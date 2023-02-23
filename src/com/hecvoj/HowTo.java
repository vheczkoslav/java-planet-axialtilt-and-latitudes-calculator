package com.hecvoj;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class HowTo{
    JFrame HowTo = new JFrame("How to use this program");
    HowTo() {
        HowTo.setSize(1200, 800);
        HowTo.setLocation(50, 50);
        HowTo.setLayout(null);
        HowTo.setVisible(true);
        HowTo.setResizable(false);
        HowTo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        drawInfo();

        HowTo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Interface i = new Interface();
                e.getWindow().dispose();
            }
        });

        HowTo.addWindowStateListener(e -> {
            if(e.getNewState() == Frame.ICONIFIED){
                System.out.println("Frame has been minimalised");
                HowTo.setState(Frame.NORMAL);
            }
        });
    }

    private void drawInfo() {
        JLabel mainInfo = new JLabel("This program is for visual interpretation of planet latitudes based on axial tilt");
        mainInfo.setFont(new Font("Calibri", Font.BOLD, 20));
        mainInfo.setBounds(220,0,700,40);
        mainInfo.setForeground(Color.red);
        mainInfo.setVisible(true);
        HowTo.add(mainInfo);
    }
}
