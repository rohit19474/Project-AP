package com.example.willherofxfinal;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.WeakHashMap;


public class controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private AnchorPane anchorPane;

    @FXML
    private Button UP;
    @FXML
    private ImageView heroimg;
    @FXML
    private ImageView isl1;
    @FXML
    private Button pause1;
    @FXML
    private Button newUP;
    @FXML
    private Button test;
    @FXML
    private Button right;
    @FXML
    private Button test1;
    @FXML
    private Pane pausemenu;
    TranslateTransition t1;
    TranslateTransition t11;



    public void switchtoMenu(ActionEvent event) throws IOException {

        URL url = new File("src/main/resources/com/example/willherofxfinal/gameUI.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoLevel(ActionEvent event) throws IOException {

        URL url = new File("src/main/resources/com/example/willherofxfinal/level1.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        test = (Button)scene.lookup("#test");
        pausemenu = (Pane)scene.lookup("#pausemenu");
        stage.show();
        test.fire();
        pausemenu.setVisible(false);


    }


    public void  jump1()
    {

        t1 = new TranslateTransition();
        t1.setNode(heroimg);
        t1.setByY(-100);
        t1.setCycleCount(TranslateTransition.INDEFINITE);
        t1.setAutoReverse(true);
        t1.play();
    }

    public void exitfromGame(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("You are about to exit from the game.");
        alert.setContentText("If you still wish to exit the game click the OK button.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            URL url = new File("src/main/resources/com/example/willherofxfinal/level.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public void exitfromGameingame(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("You are about to exit from the game.");
        alert.setContentText("If you still wish to exit the game click the OK button.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            URL url = new File("src/main/resources/com/example/willherofxfinal/level1.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public void pauseMenu(ActionEvent event) throws IOException {
        t1.pause();
        pausemenu.setVisible(true);

    }

    public void resume(ActionEvent event) throws IOException {
        t1.play();
        pausemenu.setVisible(false);
    }

    public void right1(ActionEvent event) throws IOException{

        URL url = new File("src/main/resources/com/example/willherofxfinal/level1.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        test1 = (Button)scene.lookup("#test1");

        test1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.UP){
                    System.out.println("hello");
                    t11 = new TranslateTransition();
                    t11.setNode(heroimg);
                    t11.setByX(80);
                    t11.play();
                }
            }
        });

    }



    public void moveForward() {


        this.t11 = new TranslateTransition();
        t11.setNode(heroimg);
        t11.setByX(80);
        t11.play();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}







