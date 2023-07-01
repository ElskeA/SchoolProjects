package com.bp6.adakenniscentrumapp.views;

import com.bp6.adakenniscentrumapp.controllers.*;
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewLenen {

    BoekArray ba = new BoekArray();
    String title;
    public ViewLenen(int id){

        String srcLogo = "file:ADAKenniscentrumApp/src/main/resources/com/bp6/adakenniscentrumapp/Images/ADA_Logo-2020.png";
        String srcClose = "file:ADAKenniscentrumApp/src/main/resources/com/bp6/adakenniscentrumapp/Images/ButtonClose.png";

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
//            BoekScan bs = new BoekScan();
//            for(Boek b : ba.geefBoek()){
            Connection connection = null;
            try {
                connection = DatabaseConfig.getConnection();
                if (connection != null) {
                    System.out.println("Connection established");
                    Statement stmt = connection.createStatement();
                    // Alle laatst gescande boeken ophalen en toont de titel van het boek
                    ResultSet rs = stmt.executeQuery("SELECT Title FROM Book bk JOIN ScannedNFC nfc ON bk.NFC = nfc.NFCID WHERE nfc.NFCID = (SELECT NFCID FROM ScannedNFC ORDER BY Time DESC LIMIT 1);");
//                bookID = rs.getInt("BookID");
                    if(rs.next()){
                        title = rs.getString("Title");
                    }
//                Boek bk = new Boek(title);
//                ba.saveBoek(bk);
                }
            } catch (Exception o) {
                o.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException o) {
                        o.printStackTrace();
                    }
                }
            }
                vb.getChildren().add(new Label(title));
//            }
        });

        btnVolgende.setOnAction(e->{
            ViewAfronden vf = new ViewAfronden(3);
        });

        root.getChildren().addAll(lbHeader, sp, btnVolgende, btnBoek, viewLogo, btnClose);
        stageLenen.setTitle("Lenen");
        stageLenen.setScene(scene);
        stageLenen.show();

    }

}
