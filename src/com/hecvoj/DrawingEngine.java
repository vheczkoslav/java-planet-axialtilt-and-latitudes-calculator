package com.hecvoj;

import javax.swing.*;
import java.awt.*;

public class DrawingEngine {

    DrawingEngine(){

    }

    public static void Draw_Axial_Tilt(JPanel jp, double angle, int LocX, int LocY, Graphics g){
        angle = angle * Math.PI / 180;
        g = jp.getGraphics();
        g.setPaintMode();
        g.setColor(Color.white);
        g.fillRect(0,0, 480, 360);
        //--------------------------------------------------------------------
        g.setColor(Color.black);
        g.drawArc(LocX-40, LocY-40, 80, 80, 0, 360);
        //--------------------------------------------------------------------
        int startX1 = 80;
        int startY1 = 80;
        double endX1   = 80 - 50 * Math.sin(angle);
        double endY1   = 80 - 50 * Math.cos(angle);
        int startX2 = 80;
        int startY2 = 81;
        double endX2   = 80 - 50 * -Math.sin(angle);
        double endY2   = 80 - 50 * -Math.cos(angle);
        g.setColor(Color.red);
        g.drawLine(startX1,startY1,(int)endX1,(int)endY1);
        g.setColor(Color.black);
        g.drawLine(startX2,startY2,(int)endX2,(int)endY2);
    }
}
