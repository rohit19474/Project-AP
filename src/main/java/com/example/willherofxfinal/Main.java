package com.example.willherofxfinal;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.DoubleToIntFunction;

public class Main extends Application {

    @Override
    public void start(Stage stage){
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/resources/com/example/willherofxfinal/gameUI.fxml"));
            URL url = new File("src/main/resources/com/example/willherofxfinal/gameUI.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            ModuleLayer.Controller control = loader.getController();
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {

                }
            });
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
