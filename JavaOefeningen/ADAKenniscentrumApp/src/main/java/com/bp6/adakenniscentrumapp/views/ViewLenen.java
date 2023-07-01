package com.bp6.adakenniscentrumapp.views;

import com.bp6.adakenniscentrumapp.controllers.BoekArray;
import com.bp6.adakenniscentrumapp.controllers.BoekController;
import com.bp6.adakenniscentrumapp.controllers.BoekScan;
import com.bp6.adakenniscentrumapp.controllers.LenenController;
import com.bp6.adakenniscentrumapp.models.Boek;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewLenen {

    BoekArray ba = new BoekArray();
    public ViewLenen(int id){

        String srcLogo = "file:src/main/resources/com/bp6/adakenniscentrumapp/Images/ADA_Logo-2020.png";
        String srcClose = "file:src/main/resources/com/bp6/adakenniscentrumapp/Images/ButtonClose.png";

        Pane root = new Pane();
        Stage stageLenen = new Stage();
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
            stageLenen.close();
        });

        Label lbHeader = new Label("Scan je items");
        lbHeader.setId("titleText");
        lbHeader.relocate(809, 226);

        VBox vb = new VBox();
        vb.setId("boekPane");
        vb.relocate(660, 330);
        vb.setAlignment(Pos.BASELINE_LEFT);
        vb.setSpacing(20);

        ScrollPane sp = new ScrollPane();
        sp.setId("scrollPane");
        sp.relocate(660, 330);
        sp.setContent(vb);

        Button btnVolgende = new Button("Volgende");
        btnVolgende.setId("greenButton");
        btnVolgende.relocate(1058, 853);

        Button btnBoek = new Button("Nieuw boek");
        btnBoek.setId("blueButton");
        btnBoek.relocate(487, 853);

        BoekArray ba = new BoekArray();

        btnBoek.setOnAction(e->{
            BoekScan bs = new BoekScan();
            for(Boek b : ba.geefBoek()){
                vb.getChildren().add(new Label(b.getTitle()+ " " + b.getAuthor()));
            }
        });

        btnVolgende.setOnAction(e->{
//            LenenController lc = new LenenController(id, );
        });

        root.getChildren().addAll(lbHeader, sp, btnVolgende, btnBoek, viewLogo, btnClose);
        stageLenen.setTitle("Lenen");
        stageLenen.setScene(scene);
        stageLenen.show();

    }

}
