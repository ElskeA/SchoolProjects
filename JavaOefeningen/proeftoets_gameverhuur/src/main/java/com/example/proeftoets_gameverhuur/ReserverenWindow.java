package com.example.proeftoets_gameverhuur;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;

public class ReserverenWindow {

    public ReserverenWindow(ResController rc){

        Stage resStage = new Stage();

        GridPane root = new GridPane();

        Label lbNaam = new Label("Naam:");
        Label lbAdres = new Label("Adres:");
        Label lbPostcode = new Label("Postcode:");
        Label lbWoonplaats = new Label("Woonplaats:");
        Label lbGebDatum = new Label("Geboortedatum:");
        Label lbEmailTel = new Label("Email of Telefoonnummer:");

        TextField txtNaam = new TextField();
        TextField txtAdres = new TextField();
        TextField txtPostcode = new TextField();
        TextField txtWoonplaats = new TextField();
        DatePicker dpGeb = new DatePicker();
        TextField txtEmailTel = new TextField();

        Label lbGame = new Label("Game:");
        Label lbConsole = new Label("Console:");
        Label lbUitleendat = new Label("Uitleendatum:");
        Label lbRetourdat = new Label("Retourdatum:");

        String[] gameStrings = {"Animal Crossing", "Horizon Zero Dawn", "Zelda"};
        ComboBox cmbGame = new ComboBox(FXCollections.observableArrayList(gameStrings));
        String[] consoleStrings = {"PS4", "Nintendo Switch", "XBOX ONE"};
        ComboBox cmbConsole = new ComboBox(FXCollections.observableArrayList(consoleStrings));
        DatePicker dtUitleen = new DatePicker();
        DatePicker dtRetour = new DatePicker();

        Button btnOpslaan = new Button("Opslaan");

        btnOpslaan.setOnAction(e->
        {
            Reservering res = new Reservering(txtNaam.getText(),
                                                txtAdres.getText(),
                                                txtPostcode.getText(),
                                                txtWoonplaats.getText(),
                                                dpGeb.getValue().toString(),
                                                txtEmailTel.getText(),
                                                cmbGame.getValue().toString(),
                                                cmbConsole.getValue().toString(),
                                                dtUitleen.getValue().toString(),
                                                dtRetour.getValue().toString());
            rc.opslaanReservering(res);
        });


        root.add(lbNaam, 0, 0);
        root.add(txtNaam, 1, 0);

        root.add(lbAdres, 0, 1);
        root.add(txtAdres, 1, 1);

        root.add(lbPostcode, 0, 2);
        root.add(txtPostcode, 1, 2);

        root.add(lbWoonplaats, 0, 3);
        root.add(txtWoonplaats, 1, 3);

        root.add(lbGebDatum, 0, 4);
        root.add(dpGeb, 1, 4);

        root.add(lbEmailTel, 0, 5);
        root.add(txtEmailTel, 1, 5);

        root.add(lbGame, 0, 6);
        root.add(cmbGame, 1, 6);
        root.add(lbConsole, 0, 7);
        root.add(cmbConsole, 1, 7);
        root.add(lbUitleendat, 0, 8);
        root.add(dtUitleen, 1, 8);
        root.add(lbRetourdat, 0, 9);
        root.add(dtRetour, 1, 9);

        root.add(btnOpslaan, 0, 10);


        resStage.setTitle("Reserveren");
        resStage.setScene(new Scene(root, 800, 600));
        resStage.show();

    }

}
