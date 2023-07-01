package com.bp6.adakenniscentrumapp.views;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewTerugbrengen {

    public ViewTerugbrengen(int id){

        String srcLogo = "file:ADAKenniscentrumApp/src/main/resources/com/bp6/adakenniscentrumapp/Images/ADA_Logo-2020.png";
        String srcClose = "file:ADAKenniscentrumApp/src/main/resources/com/bp6/adakenniscentrumapp/Images/ButtonClose.png";

        Pane root = new Pane();
        Stage stageTerug = new Stage();
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
            stageTerug.close();
        });

        Label lbHeader = new Label("Welke items breng je terug?");
        lbHeader.setId("titleText");
        lbHeader.relocate(649, 230);

        VBox vb = new VBox();
        vb.setId("boekPane");
        vb.relocate(660, 330);
        vb.setAlignment(Pos.BASELINE_LEFT);
        vb.setSpacing(20);

        CheckBox lbBoek1 = new CheckBox("Teach yourself Salesforce.com");
        CheckBox lbBoek2 = new CheckBox("Handboek Power BI");
        CheckBox lbBoek3 = new CheckBox("Computernetwerken Een top-downbenadering");

        CheckBox[] labels = {lbBoek1, lbBoek2, lbBoek3};

        for(int a = 0; a < labels.length; a++){
            vb.getChildren().add(labels[a]);
        }

        ScrollPane sp = new ScrollPane();
        sp.setId("scrollPane");
        sp.relocate(660, 330);
        sp.setContent(vb);

        Button btnVolgende = new Button("Volgende");
        btnVolgende.setId("greenButton");
        btnVolgende.relocate(1058, 853);

        Button btnVorige = new Button("Vorige");
        btnVorige.setId("greenButton");
        btnVorige.relocate(487, 853);

        btnVorige.setOnAction(e->{
            stageTerug.close();
        });

        btnVolgende.setOnAction(e->{
            //Query om alles in db te zetten
            ViewAfronden af = new ViewAfronden(5);
        });


        root.getChildren().addAll(lbHeader, sp, btnVolgende, btnVorige, viewLogo, btnClose);
        stageTerug.setTitle("Terugbrengen");
        stageTerug.setScene(scene);
        stageTerug.show();
    }

}
