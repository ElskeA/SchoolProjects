package com.bp6.adakenniscentrumapp.views;

import com.bp6.adakenniscentrumapp.controllers.BoekController;
import com.bp6.adakenniscentrumapp.models.NieuwBoek;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewNieuwBoek{

    BoekController bc = new BoekController();
    public ViewNieuwBoek(NieuwBoek b){
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

        });

        Label lbHeader = new Label("Controleer de gegevens van het boek");
        Label lbBoektitel = new Label();
        Label lbAutheur = new Label();
        Label lbISBN = new Label();

        lbHeader.setId("titleText");
        lbHeader.relocate(546, 220);
        lbBoektitel.setId("normalText");
        lbAutheur.setId("normalText");
        lbISBN.setId("normalText");
        lbBoektitel.setMaxWidth(Double.MAX_VALUE);
        lbAutheur.setMaxWidth(Double.MAX_VALUE);
        lbISBN.setMaxWidth(Double.MAX_VALUE);

        Button btnVolgende = new Button("Volgende");
        btnVolgende.setId("greenButton");
        btnVolgende.relocate(1058, 853);

        btnVolgende.setOnAction(e-> {
            bc.addBoek(b);
//            ViewAfronden va = new ViewAfronden(1);
            });

        Button btnVorige = new Button("Vorige");
        btnVorige.setId("greenButton");
        btnVorige.relocate(487, 853);

        btnVorige.setOnAction(e->{
            stageStudent.close();
        });

        lbBoektitel.setText(b.getTitle());
        lbAutheur.setText(b.getAuthor());
        lbISBN.setText("ISBN: " + b.getIsbn().toString());

        Image imgBoek = new Image(b.getImgURL());
        System.out.println(b.getImgURL());
        ImageView vBoek = new ImageView(imgBoek);
        vBoek.relocate(920, 400);

        GridPane labelPane = new GridPane();
        labelPane.relocate(780, 520);
        labelPane.setVgap(20);
        labelPane.setPrefWidth(600);
        labelPane.add(lbBoektitel, 0, 0);
        labelPane.add(lbAutheur, 0, 1);
        labelPane.add(lbISBN, 0, 2);

        root.getChildren().addAll(btnVorige, btnVolgende, labelPane, vBoek, lbHeader, viewLogo, btnClose);
        stageStudent.setTitle("Boek");
        stageStudent.setScene(scene);
        stageStudent.show();
    }

}
