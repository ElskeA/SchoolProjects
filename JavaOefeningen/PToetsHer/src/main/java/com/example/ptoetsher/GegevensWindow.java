package com.example.ptoetsher;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class GegevensWindow {
    public GegevensWindow(Controller c){

        Stage gevStage = new Stage();
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 800, 600);

        Button btnOpslaan = new Button("Opslaan");

        Label lNaamKlant = new Label("Naam: ");
        Label lAdres = new Label("Adres: ");
        Label lPostcode = new Label("Postcode: ");
        Label lWoonplaats = new Label("Woonplaats: ");
        Label lGebDatum = new Label("GeboorteDatum: ");
        Label lEmailTel = new Label("Email en/of Telefoonnummer");
        Label lNaamSpel = new Label("Spel: ");
        Label lType = new Label("Hardware: ");
        Label lUitDatum = new Label("Ophaal Datum: ");
        Label lRetDatum = new Label("Terug breng Datum: ");

        TextField txtNaamKlant = new TextField();
        TextField txtAdres = new TextField();
        TextField txtPostcode = new TextField();
        TextField txtWoonplaats = new TextField();
        DatePicker datGeb = new DatePicker();
        datGeb.setValue(LocalDate.of(1900, 01, 01));
        TextField txtEmailTel = new TextField();
        String[] spellen = {"Mario", "Zelda", "GTA"};
        ComboBox txtNaamSpel = new ComboBox(FXCollections.observableArrayList(spellen));
        String[] types = {"PS4", "XBOX", "PC"};
        ComboBox txtType = new ComboBox(FXCollections.observableArrayList(types));
        DatePicker datUit = new DatePicker();
        DatePicker datRet = new DatePicker();

        root.add(lNaamKlant,0,0);
        root.add(txtNaamKlant,1,0);
        root.add(lAdres,0,1);
        root.add(txtAdres,1,1);
        root.add(lPostcode,0,2);
        root.add(txtPostcode,1,2);
        root.add(lWoonplaats,0,3);
        root.add(txtWoonplaats,1,3);
        root.add(lGebDatum,0,4);
        root.add(datGeb,1,4);
        root.add(lEmailTel,0,5);
        root.add(txtEmailTel,1,5);
        root.add(lNaamSpel,0,6);
        root.add(txtNaamSpel,1,6);
        root.add(lType,0,7);
        root.add(txtType,1,7);
        root.add(lUitDatum,0,8);
        root.add(datUit,1,8);
        root.add(lRetDatum,0,9);
        root.add(datRet,1,9);
        root.add(btnOpslaan,0,10);

        btnOpslaan.setOnAction(e->{
            Gegevens gev = new Gegevens(txtNaamKlant.getText(),
                                        txtAdres.getText(),
                                        txtPostcode.getText(),
                                        txtWoonplaats.getText(),
                                        datGeb.getValue().toString(),
                                        txtEmailTel.getText(),
                                        txtNaamSpel.getValue().toString(),
                                        txtType.getValue().toString(),
                                        datUit.getValue().toString(),
                                        datRet.getValue().toString());
                c.opslaanGegevens(gev);
        });


        gevStage.setTitle("GameVerkoper");
        gevStage.setScene(scene);
        gevStage.show();
    }



}
