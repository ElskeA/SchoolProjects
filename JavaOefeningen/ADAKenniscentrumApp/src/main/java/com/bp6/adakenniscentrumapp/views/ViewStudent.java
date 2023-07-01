package com.bp6.adakenniscentrumapp.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewStudent {
    public ViewStudent(int id) {
        String srcLogo = "file:src/main/resources/com/bp6/adakenniscentrumapp/Images/ADA_Logo-2020.png";
        String srcClose = "file:src/main/resources/com/bp6/adakenniscentrumapp/Images/ButtonClose.png";

        Pane root = new Pane();
        Stage stageStudent = new Stage();
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
            stageStudent.close();
        });

        Label lbTitel = new Label("Ik kom iets ...");
        lbTitel.setId("titleText");
        lbTitel.relocate(810, 326);

        Button btnLenen = new Button("Lenen");
        Button btnTerugbrengen = new Button("Terugbrengen");
        Button btnVerlengen = new Button("Verlengen");
        btnTerugbrengen.setId("greenButton");
        btnVerlengen.setId("greenButton");
        btnLenen.setId("greenButton");
        btnLenen.relocate(773, 449);
        btnVerlengen.relocate(773, 657);
        btnTerugbrengen.relocate(773, 553);

        btnLenen.setOnAction(e->{
            ViewLenen vl = new ViewLenen(id);
        });

        btnTerugbrengen.setOnAction(e->{
            ViewTerugbrengen vt = new ViewTerugbrengen(id);
        });

        btnVerlengen.setOnAction(e->{
            ViewVerlengen vv = new ViewVerlengen(id);
        });



        root.getChildren().addAll(viewLogo, btnLenen, btnTerugbrengen, btnVerlengen, lbTitel, btnClose);
        stageStudent.setTitle("Student");
        stageStudent.setScene(scene);
        stageStudent.show();
    }

}
