package com.hecvoj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Interface {
    Graphics2D g2d;
    Graphics g;
    public JFrame frame = new JFrame("Planet latitudes visualizator");
    JButton clickToDraw = new JButton("Click");
    JTextField input= new JTextField(10);
    JLabel hint = new JLabel("Input size of ball");
    JLabel southernPole = new JLabel("Blue is South pole");
    JLabel northernPole = new JLabel("Red is North pole");
    JLabel error = new JLabel("Wrong value");
    public JPanel circlePanelImg = new JPanel();
    Interface(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(960,720);
        frame.setResizable(false);
        frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2,screenSize.height / 2 - frame.getHeight() / 2);
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
                    System.out.println("Input: " + ballRadius);
                    if(ballRadius > 90 || ballRadius < 0){
                        throw new NumberFormatException("Invalid value");
                    }else{
                        DrawingEngine.Draw_Axial_Tilt(circlePanelImg, -ballRadius, 160,160, circlePanelImg.getWidth()/2);
                    }
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

        //I want to be able to type values into input without clicking with mouse on button, so Enter it is
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try{
                        String s = input.getText();
                        Integer ballRadius = Integer.parseInt(s);
                        System.out.println("Input: " + ballRadius);
                        if(ballRadius > 90 || ballRadius < 0){
                            throw new NumberFormatException("Invalid value");
                        }else{
                            DrawingEngine.Draw_Axial_Tilt(circlePanelImg, -ballRadius, 160,160, circlePanelImg.getWidth()/2);
                        }
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
                return false;
            }
        });

        error.setForeground(Color.red);
        error.setBounds(145,60,90,15);
        error.setVisible(false);
        frame.add(error);

        hint.setVisible(true);
        hint.setBounds(145,40,100,15);
        frame.add(hint);

        southernPole.setBounds(40, 180,120,15);
        southernPole.setForeground(Color.blue);
        northernPole.setBounds(40,200,100,15);
        southernPole.setVisible(true);northernPole.setVisible(true);
        northernPole.setForeground(Color.red);
        frame.add(southernPole);
        frame.add(northernPole);

        circlePanelImg.setVisible(true);
        circlePanelImg.setSize(480,480);
        circlePanelImg.setLocation(360,140);
        circlePanelImg.setBackground(Color.WHITE);
        circlePanelImg.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        frame.add(circlePanelImg);

        input.setLocation(260, 34);
        input.setVisible(true);
        input.setSize(175,40);
        frame.add(input);

    }
}
