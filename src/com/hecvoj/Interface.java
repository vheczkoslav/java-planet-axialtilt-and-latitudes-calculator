package com.hecvoj;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Interface {
    Graphics2D g2d;
    Graphics g;
    public JFrame frame = new JFrame();
    JButton clickToDraw = new JButton("Click");
    JTextField input= new JTextField(10);
    JLabel hint = new JLabel("Input size of ball");
    JLabel southernPole = new JLabel("Black is South pole");
    JLabel northernPole = new JLabel("Red is North pole");
    JLabel error = new JLabel("Wrong value");
    public JPanel circlePanelImg = new JPanel();
    Interface(){
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(480,360);
        frame.setResizable(false);
        frame.setLocation(20,20);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        clickToDraw.setVisible(true);
        clickToDraw.setLocation(40, 30);
        clickToDraw.setSize(100,50);
        clickToDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String s = input.getText();
                    Integer ballRadius = Integer.parseInt(s);
                    //DrawingEngine.currentRadius = ballRadius;
                    DrawingEngine.Draw_Axial_Tilt(circlePanelImg, -ballRadius, 80,80,g);
                    System.out.println(ballRadius);
                }
                catch(NumberFormatException ex){
                    error.setVisible(true);
                        TimerTask task = new TimerTask() {
                            public void run() {
                                error.setVisible(false);
                            }
                        };
                        Timer timer = new Timer("Timer");
                        long delay = 1500L;
                        timer.schedule(task, delay);
                    System.out.println("Wrong");
                }

            }
        });
        frame.add(clickToDraw);

        error.setForeground(Color.red);
        error.setBounds(145,60,90,15);
        error.setVisible(false);
        frame.add(error);

        hint.setVisible(true);
        hint.setBounds(145,40,100,15);
        frame.add(hint);

        southernPole.setBounds(40, 180,120,15);
        northernPole.setBounds(40,200,100,15);
        southernPole.setVisible(true);northernPole.setVisible(true);
        northernPole.setForeground(Color.red);
        frame.add(southernPole);
        frame.add(northernPole);

        circlePanelImg.setVisible(true);
        circlePanelImg.setSize(160,160);
        circlePanelImg.setLocation(180,140);
        circlePanelImg.setBackground(Color.WHITE);
        circlePanelImg.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        frame.add(circlePanelImg);

        input.setLocation(260, 34);
        input.setVisible(true);
        input.setSize(175,40);
        frame.add(input);

        //CustomJFrame cjf = new CustomJFrame("Test",200,150);
    }
}
