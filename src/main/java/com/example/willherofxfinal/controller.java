package com.example.willherofxfinal;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.WeakHashMap;


public class controller implements Initializable {

    private Stage stage;
    private Stage stage1;
    private Scene scene;
    private Parent root;
    private AnchorPane anchorPane;

    @FXML
    private Button UP;
    @FXML
    private ImageView heroimg;
    @FXML
    private ImageView redorc;
    @FXML
    private ImageView greenorc;
    @FXML
    private ImageView isl1;
    @FXML
    private ImageView isl2;
    @FXML
    private ImageView temp1;
    @FXML
    private ImageView temp2;
    @FXML
    private ImageView obs1;
    @FXML
    private ImageView obs2;
    @FXML
    private ImageView isl3;
    @FXML
    private Button pause;
    @FXML
    private Button dead;
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
    @FXML
    private Text orckilled;
    TranslateTransition t1;
    TranslateTransition t2;
    TranslateTransition t3;
    TranslateTransition t11;
    ArrayList<ImageView> islands = new ArrayList<>();
    ArrayList<ImageView> orcs = new ArrayList<>();
    HashMap<ImageView,ImageView> orctoimg = new HashMap<ImageView,ImageView>();



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
        Camera camera = new PerspectiveCamera();
        scene.setCamera(camera);
        stage.setScene(scene);
        dead = (Button)scene.lookup("#dead");
        test = (Button)scene.lookup("#test");
        test1 = (Button)scene.lookup("#test1");
        right = (Button)scene.lookup("#right");
        pause = (Button)scene.lookup("#pause");
        pausemenu = (Pane)scene.lookup("#pausemenu");
        heroimg = (ImageView)scene.lookup("#heroimg");
        temp1 = (ImageView)scene.lookup("#temp1");
        temp2 = (ImageView)scene.lookup("#temp2");
        obs1 = (ImageView)scene.lookup("#obs1");
        obs2 = (ImageView)scene.lookup("#obs2");
        redorc = (ImageView)scene.lookup("#redorc");
        greenorc = (ImageView)scene.lookup("#greenorc");
        isl1 = (ImageView)scene.lookup("#isl1");
        isl2 = (ImageView)scene.lookup("#isl2");
        isl3 = (ImageView)scene.lookup("#isl3");
        orckilled = (Text)scene.lookup("#orckilled");
        islands.add(temp1);
        islands.add(temp2);
        orcs.add(obs1);
        orcs.add(obs2);
        orctoimg.put(obs1,greenorc);
        orctoimg.put(obs2,redorc);
        stage.show();
        orckilled.setVisible(false);
        test.fire();
        test.setDisable(true);

        pausemenu.setVisible(false);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()==KeyCode.D){

                    camera.translateXProperty().set(camera.translateXProperty().getValue()+10);
                    test1.fire();

                }
            }
        });

        collisionTimer.start();


    }


    public void  jump1() throws InterruptedException, IOException {



        t1 = new TranslateTransition();
        t1.setNode(heroimg);
        t1.setByY(-120);
        t1.setCycleCount(TranslateTransition.INDEFINITE);
        t1.setAutoReverse(true);
        t1.play();


        t2 = new TranslateTransition();
        t2.setNode(redorc);
        t2.setByY(-50);
        t2.setCycleCount(TranslateTransition.INDEFINITE);
        t2.setAutoReverse(true);
        t2.play();


        t3 = new TranslateTransition();
        t3.setNode(greenorc);
        t3.setByY(-20);
        t3.setCycleCount(TranslateTransition.INDEFINITE);
        t3.setAutoReverse(true);
        t3.play();



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
        t2.pause();
        t3.pause();
        t11.pause();
        pausemenu.setVisible(true);

    }

    public void resume(ActionEvent event) throws IOException {

        if(t11.getStatus()== Animation.Status.PAUSED)
        {
            t11.play();
        }
        t1.play();
        t2.play();
        t3.play();

        pausemenu.setVisible(false);
    }


    public void move() throws IOException {

        URL url = new File("src/main/resources/com/example/willherofxfinal/level1.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        test1 = (Button)scene.lookup("#test1");
        test1.setOnKeyPressed(e -> {
            if(e.getCode()==KeyCode.A) {
                System.out.println("HELLO");


                try {
                    moveForward();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }



    public void moveForward() throws MalformedURLException {


        this.t11 = new TranslateTransition();
        t11.setNode(heroimg);
        t11.setByX(85);
        t11.play();
        orckilled.setVisible(false);


    }

    public void moveUP()
    {
        System.out.println("UP");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    AnimationTimer collisionTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {

            try {
                checkCollision(heroimg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public void checkCollision(ImageView a) throws InterruptedException {

        for( ImageView x : islands){
        if(a.getBoundsInParent().intersects(x.getBoundsInParent())){

            dead.fire();

        }}
        for( ImageView x : orcs){
            if(a.getBoundsInParent().intersects(pausemenu.localToParent(x.getBoundsInParent()))){

                orctoimg.get(x).setVisible(false);
                orckilled.setVisible(true);

            }}

        //orckilled.setVisible(true);

}
public void testfunc(ActionEvent event) throws IOException, InterruptedException {

        t1.stop();
        TranslateTransition t4 = new TranslateTransition();
        t4.setNode(heroimg);
        t4.setDuration(Duration.millis(100));
        t4.setByY(500);
        t4.play();

        if(t4.getStatus()==Animation.Status.STOPPED){

        URL url3 = new File("src/main/resources/com/example/willherofxfinal/deadhero.fxml").toURI().toURL();
        root = FXMLLoader.load(url3);
        stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();}

}

}







