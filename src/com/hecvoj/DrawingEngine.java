package com.hecvoj;

import javax.swing.*;
import java.awt.*;

public class DrawingEngine {

    DrawingEngine(){
        //Constructor not needed for our purposes
    }
    static int sizeOfPlanet = 240;
    public static void Draw_Axial_Tilt(JPanel jp, double angle, int LocX, int LocY, int centerLoc){
        int intAngle = (int)angle; //used for length of lines
        angle = angle * Math.PI / 180; //used for angle of lines
        Graphics g = jp.getGraphics();
        g.setPaintMode();
        g.setColor(Color.white);
        g.fillRect(0,0, 480, 480);
        double Latitude = (sizeOfPlanet/2)/90; //diameter is 240 so hemisphere radius is half of it
        //--------------------------------------------------------------------
        g.setColor(Color.black);
        g.drawArc(LocX-40, LocY-40, sizeOfPlanet, sizeOfPlanet, 0, 360);
        //--------------------------------------------------------------------
        int startX1 = centerLoc; //red - N <-- red is static and therefore always in same position
        int startY1 = centerLoc;
        int startX2 = centerLoc; //blue - S <-- blue is dynamic and therefore change its position
        int startY2 = centerLoc-1;
        //----------------------------------------
        double endX1  = centerLoc - (Latitude*intAngle) * Math.sin(angle); //red - N
        double endY1  = centerLoc - (Latitude*intAngle) * Math.cos(angle);
        double endX2  = centerLoc - 135 * -Math.sin(angle); //blue - S
        double endY2  = centerLoc - 135 * -Math.cos(angle);
        System.out.println("angle int value: " + angle);
        //---------------------------------------------------
        //This block is about calculating tropic and polar poles locations
        double locNorthPolarPoleX = centerLoc - (Latitude*intAngle) * Math.sin(angle); //this is just a center point
        double locNorthPolarPoleY = centerLoc - (Latitude*intAngle) * Math.cos(angle); //this is just a center point
        double locNorthPolarPoleLeftX = locNorthPolarPoleX - (Latitude*intAngle)/2 * Math.sin(angle-Math.PI/2);
        double locNorthPolarPoleLeftY = locNorthPolarPoleY - (Latitude*intAngle)/2 * Math.cos(angle-Math.PI/2);
        double locNorthPolarPoleRightX = locNorthPolarPoleX - (Latitude*intAngle)/2 * Math.sin(angle+Math.PI/2);
        double locNorthPolarPoleRightY = locNorthPolarPoleY + (Latitude*intAngle)/2 * Math.cos(angle+Math.PI/2);
        g.setColor(Color.blue);
        g.drawLine((int)locNorthPolarPoleLeftX,(int)locNorthPolarPoleLeftY,(int)locNorthPolarPoleRightX,(int)locNorthPolarPoleRightY);

        double locSouthPolarPoleX = centerLoc + (Latitude*angle) * -Math.sin(angle); //this is just a center point
        double locSouthPolarPoleY = centerLoc + (Latitude*angle) * -Math.cos(angle); //this is just a center point


        double locNorthTropicPoleX = centerLoc - (Latitude*angle) * Math.sin(angle); //this is just a center point
        double locNorthTropicPoleY = centerLoc - (Latitude*angle) * Math.cos(angle); //this is just a center point
        g.setColor(Color.red);


        double locSouthTropicPoleX = centerLoc + (Latitude*angle) * -Math.sin(angle); //this is just a center point
        double locSouthTropicPoleY = centerLoc + (Latitude*angle) * -Math.cos(angle); //this is just a center point

        //---------------------------------------------------
        g.setColor(Color.red);
        g.drawLine(startX1,startY1,(int)endX1,(int)endY1);
        g.setColor(Color.blue);
        //g.drawLine(startX2,startY2,(int)endX2,(int)endY2);
        System.out.println("Red X: " + startX1 + " Red Y: " + startY1);
        System.out.println("Blue X: " + startX2 + " Blue Y: " + startY2);
    }
}
