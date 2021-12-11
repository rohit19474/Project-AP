package com.example.willherofxfinal;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import static java.lang.Thread.sleep;

public class HelloController {

    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    public void up(ActionEvent e) throws InterruptedException {
        //System.out.println("UP");
        myCircle.setCenterY(y-=5);
        }

    public void down(ActionEvent e){
        //System.out.println("DOWN");
        myCircle.setCenterY(y+=5);
    }
    public void left(ActionEvent e){
        //System.out.println("LEFT");
        myCircle.setCenterX(x-=5);
    }
    public void right(ActionEvent e){
        //System.out.println("RIGHT");
        myCircle.setCenterX(x+=5);
    }
}