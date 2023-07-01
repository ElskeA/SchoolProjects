package com.example.tentamenprog;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ReserverenWindow {

    public ReserverenWindow() {

        GridPane root = new GridPane();
        Stage stage = new Stage();

        Label txtInvoer = new Label("Vul de onderstaande gegevens in:");

        Label lbNaam = new Label("Naam");
        Label lbAdres = new Label("Adres");
        Label lbPostcode = new Label("Postcode");
        Label lbWoonplaats = new Label("Woonplaats");
        Label lbGebDat = new Label("Geboortedatum");
        Label lbEmTel = new Label("Email/Telefoonnummer");
        Label lbUitleen = new Label("Uitleendatum");
        Label lbRetour = new Label("Retourdatum");

        TextField txtNaam = new TextField();
        TextField txtAdres = new TextField();
        TextField txtPostcode = new TextField();
        TextField txtWoonplaats = new TextField();
        DatePicker dtGebDat = new DatePicker();
        TextField txtEmtel = new TextField();

        Label lbKies = new Label("Kies een apparaat:");
        Button rbLaptop = new Button("Laptop");
        Button rbTelefoon = new Button("Telefoon");
        Button rbWebcam = new Button("Webcam");
        Button rbMonitor = new Button("Monitor");
        Button rbMic = new Button("Microfoon");




        Button btnOpslaan = new Button("Reserveren");

        root.add(txtInvoer, 0, 0);

        root.add(lbNaam, 0, 1);
        root.add(txtNaam, 1, 1);

        root.add(lbAdres, 0, 2);
        root.add(txtAdres, 1, 2);

        root.add(lbPostcode, 0, 3);
        root.add(txtPostcode, 1, 3);

        root.add(lbWoonplaats, 0, 4);
        root.add(txtWoonplaats, 1, 4);

        root.add(lbGebDat, 0, 5);
        root.add(dtGebDat, 1, 5);

        root.add(lbKies, 0, 6);

        root.add(rbLaptop, 0, 7);
        root.add(rbTelefoon, 1, 7);
        root.add(rbWebcam, 2, 7);
        root.add(rbMonitor, 3, 7);
        root.add(rbMic, 4, 7);

        stage.setTitle("Reserveren");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}