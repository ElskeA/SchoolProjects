package com.example.fit4you;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.DateTimeException;

public class IndScreen {

    public IndScreen(AbController ab){
        GridPane root = new GridPane();

        Label lbTitel= new Label("Vul de onderstaande gegevens in:");
        Label lbVnaam = new Label("Voornaam:");
        Label lbAnaam = new Label("Achternaam:");
        Label lbPost = new Label("Postcode:");
        Label lbAdres = new Label("Adres:");
        Label lbWoon = new Label("Woonplaats:");
        Label lbGebDat = new Label("Geboortedatum:");

        TextField txtVnaam = new TextField();
        TextField txtAnaam = new TextField();
        TextField txtPost = new TextField();
        TextField txtAdres = new TextField();
        TextField txtWoon = new TextField();
        DatePicker dp = new DatePicker();


        Button btnOpslaan = new Button("Opslaan");
        btnOpslaan.setOnAction(e->
        {
            try{
                if(dp.getValue() == null){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Datum fout");
                    alert.showAndWait();
                }else{
                Individueel i = new Individueel(txtVnaam.getText(),
                                                txtAnaam.getText(),
                                                txtAdres.getText(),
                                                txtPost.getText(),
                                                txtWoon.getText(),
                                                dp.getValue());
                ab.opslaanAb(i);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Gegevens opgeslagen");
                alert.showAndWait();
                }
            }catch(Exception dte)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Onjuiste datum");
                alert.showAndWait();
            }finally
            {

            }
        });


        root.add(lbTitel, 0, 0);
        root.add(lbVnaam, 0, 1);
        root.add(txtVnaam, 1, 1);
        root.add(lbAnaam, 0, 2);
        root.add(txtAnaam, 1, 2);
        root.add(lbAdres, 0, 3);
        root.add(txtAdres, 1, 3);
        root.add(lbPost, 0, 4);
        root.add(txtPost, 1, 4);
        root.add(lbWoon, 0, 5);
        root.add(txtWoon, 1, 5);
        root.add(lbGebDat, 0, 6);
        root.add(dp, 1, 6);
        root.add(btnOpslaan, 1, 7);


        Stage stage = new Stage();
        stage.setTitle("Gezins abbonement");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

}
