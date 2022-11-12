package com.hecvoj;

import org.testng.annotations.Test;

import javax.swing.*;

public class CustomJFrame {
    static JFrame frame = new JFrame();
    CustomJFrame(String title, int width, int height){
        frame.setTitle(title);
        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setLocation(0,0);
    }
}
