package com.bp6.adakenniscentrumapp.views;

import com.bp6.adakenniscentrumapp.Main;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ViewAfronden {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ViewAfronden(int i){

        String srcLogo = "file:src/main/resources/com/bp6/adakenniscentrumapp/Images/ADA_Logo-2020.png";

        Pane root = new Pane();
        Stage stageAfrond = new Stage();
        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("Stylesheet.css");
        root.setStyle("-fx-background-color: WHITE");

        Image imgLogo = new Image(srcLogo);
        ImageView viewLogo = new ImageView();
        viewLogo.setImage(imgLogo);
        viewLogo.relocate(45, 45);

        Label lbHeader = new Label("Gelukt!");
        lbHeader.setId("titleText");
        lbHeader.relocate(881, 298);

        Label lbSubtekst = new Label();
        lbSubtekst.setId("normalText");

        Label lbDatum = new Label();
        lbDatum.setId("dateText");

        Button btnAfrond = new Button("Afronden");
        btnAfrond.setId("greenButton");
        btnAfrond.relocate(773, 601);
        btnAfrond.setOnAction(e->{
            Main main = new Main();
        });

        // 1 = boek toevoegen
        // 2 = arduiono toevoegen
        // 3 = uitlenen
        // 4 = verlengen
        // 5 = terugbrengen
        switch (i) {
            case 1 -> {
                lbSubtekst.setText("Boek is toegevoegd aan de database");
                lbSubtekst.relocate(643, 455);
            }
            case 2 -> {
                lbSubtekst.setText("Arduino kit is toegevoegd!");
                lbSubtekst.relocate(700, 485);
            }
            case 3 -> {
                lbSubtekst.setText("De items zijn aan je uitgeleend tot");
                lbSubtekst.relocate(696, 430);

                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.DATE, 14);
                String output = sdf.format(c.getTime());
                System.out.println(output);
                lbDatum.setText(output);
                lbDatum.relocate(853, 487);
            }
            case 4 -> {
                lbSubtekst.setText("De items zijn verlengd tot");
                lbSubtekst.relocate(762, 430);
                lbDatum.setText("28/01/2023");
                lbDatum.relocate(853, 487);
            }
            case 5 -> {
                lbSubtekst.setText("Zorg dat alle items terug in de kast staan \n en druk op afronden!");
                lbSubtekst.relocate(636, 430);
            }

        }

        root.getChildren().addAll(lbHeader, btnAfrond, lbSubtekst, lbDatum, viewLogo);
        stageAfrond.setTitle("Afronden");
        stageAfrond.setScene(scene);
        stageAfrond.show();
    }

}
