package com.bp6.adakenniscentrumapp;

import com.bp6.adakenniscentrumapp.views.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("Stylesheet.css");
        root.setStyle("-fx-background-color: #94D200");

        Image imgLogo = new Image("file:ADAKenniscentrumApp/src/main/resources/com/bp6/adakenniscentrumapp/Images/LogoGif.gif");
        ImageView logoSplash = new ImageView(imgLogo);
        logoSplash.relocate(310, 140);
        logoSplash.setFitWidth(1300);
        logoSplash.setFitHeight(800);
        logoSplash.setOnMouseClicked(e->{
            ViewInlog vi = new ViewInlog();
        });

//        Button btnDocent = new Button("Docent");
//        btnDocent.relocate(574, 853);
//        btnDocent.setOnAction(e-> {
//            ViewDocent vd = new ViewDocent();
//        });
//
//        Button btnStudent = new Button("Student");
//        btnStudent.relocate(1053, 863);
//        btnStudent.setOnAction(e->{
//            ViewStudent vc = new ViewStudent();
//        });

        root.getChildren().setAll(logoSplash);
        stage.setTitle("Splash");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}