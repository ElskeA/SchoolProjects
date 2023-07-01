package com.example.fit4you;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GezinScreen {

    public GezinScreen(AbController ac){
        GridPane root = new GridPane();

        Label lbTitel= new Label("Vul de onderstaande gegevens in:");
        Label lbFnaam = new Label("Familie naam:");
        Label lbVnaam = new Label("Voornaam:");
        Label lbAnaam = new Label("Achternaam:");
        Label lbPost = new Label("Postcode:");
        Label lbAdres = new Label("Adres:");
        Label lbWoon = new Label("Woonplaats:");
        Label lbVolw = new Label("Aantal volwassenen:");
        Label lbKind = new Label("Aantal kinderen:");

        TextField txtFnaam = new TextField();
        TextField txtVnaam = new TextField();
        TextField txtAnaam = new TextField();
        TextField txtPost = new TextField();
        TextField txtAdres = new TextField();
        TextField txtWoon = new TextField();
        TextField txtVolw = new TextField();
        TextField txtKind = new TextField();

        Button btnOpslaan = new Button("Opslaan");
        btnOpslaan.setOnAction(e->
        {
            try{
            Gezin g = new Gezin(txtVnaam.getText(),
                                txtAnaam.getText(),
                                txtAdres.getText(),
                                txtPost.getText(),
                                txtWoon.getText(),
                                txtFnaam.getText(),
                                Integer.parseInt(txtVolw.getText()),
                                Integer.parseInt(txtKind.getText()));
            ac.opslaanAb(g);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Gegevens opgeslagen");
            alert.showAndWait();
        }catch(NumberFormatException nfe)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Nummer invoer");
                    alert.showAndWait();
        }finally
                {
                    txtVolw.setText("0");
                    txtKind.setText("0");
                }
        });


        root.add(lbTitel, 0, 0);
        root.add(lbFnaam, 0, 1);
        root.add(txtFnaam, 1, 1);
        root.add(lbVnaam, 0, 2);
        root.add(txtVnaam, 1, 2);
        root.add(lbAnaam, 0, 3);
        root.add(txtAnaam, 1, 3);
        root.add(lbAdres, 0, 4);
        root.add(txtAdres, 1, 4);
        root.add(lbPost, 0, 5);
        root.add(txtPost, 1, 5);
        root.add(lbWoon, 0, 6);
        root.add(txtWoon, 1, 6);
        root.add(lbVolw, 0, 7);
        root.add(txtVolw, 1, 7);
        root.add(lbKind, 0, 8);
        root.add(txtKind, 1, 8);
        root.add(btnOpslaan, 1, 9);


        Stage stage = new Stage();
        stage.setTitle("Gezins abbonement");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

}
