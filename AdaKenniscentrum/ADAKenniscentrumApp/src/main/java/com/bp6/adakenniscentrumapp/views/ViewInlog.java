package com.bp6.adakenniscentrumapp.views;

import com.bp6.adakenniscentrumapp.controllers.InlogController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewInlog {

    public ViewInlog(){

        String srcLogo = "file:ADAKenniscentrumApp/src/main/resources/com/bp6/adakenniscentrumapp/Images/ADA_Logo-2020.png";
        String srcClose = "file:ADAKenniscentrumApp/src/main/resources/com/bp6/adakenniscentrumapp/Images/ButtonClose.png";

        Pane root = new Pane();
        Stage stageLogin = new Stage();
        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("Stylesheet.css");
        root.setStyle("-fx-background-color: WHITE");

        Image imgLogo = new Image(srcLogo);
        ImageView viewLogo = new ImageView();
        viewLogo.setImage(imgLogo);
        viewLogo.relocate(45, 45);

        Image imgButton = new Image(srcClose, 80, 80, false, false);
        ImageView btnClose = new ImageView(imgButton);
        btnClose.relocate(1790, 45);
        btnClose.setOnMouseClicked(e->{
            stageLogin.close();
        });

        Label lbHeader = new Label("Scan je tag en klik op volgende");
        lbHeader.setId("titleText");
        lbHeader.relocate(615, 404);

        Button btnVolgende = new Button("Volgende");
        btnVolgende.setId("greenButton");
        btnVolgende.relocate(773, 600);
        btnVolgende.setOnAction(e->{
            InlogController ic = new InlogController();
        });

        root.getChildren().addAll(viewLogo, lbHeader, btnClose, btnVolgende);
        stageLogin.setTitle("Login");
        stageLogin.setScene(scene);
        stageLogin.show();

    }

}
