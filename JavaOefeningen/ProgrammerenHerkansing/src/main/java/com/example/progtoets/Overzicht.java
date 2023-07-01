package com.example.progtoets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.Flow;

public class Overzicht {

    public Overzicht(TicketController tc) {
        Stage oStage = new Stage();
        GridPane root = new GridPane();

        Label lbRec = new Label("");
        Label lbLeeg = new Label("");
        Label lbTotaalRec1 = new Label("Totaalbedrag recreatiezwemmen: €");
        Label lbTotaalRec2 = new Label("");
        Label lbBaan = new Label("");
        Label lbTotaalBaan1 = new Label("Totaalbedrag baantjeszwemmen: €");
        Label lbTotaalBaan2 = new Label("");
        Label lbTotaal = new Label("");
        Label lbWoonplaats = new Label("");
        Button btnBereken = new Button("Bereken totaal");

        if (tc.lstRecreatie.isEmpty()) {
            lbLeeg.setText("Lijst is leeg");
        } else {
            String recWaarde = "";
            for (Object rec : tc.geefOverzichtRec())
            {
                recWaarde += "Soort ticket: " + ((RecreatieTicket) rec).getSoort() + " > Datum: " + ((RecreatieTicket) rec).getDatum() + "\n";
            }
        lbRec.setText(recWaarde);
        lbTotaalRec2.setText("" + tc.geefTotaalRec());
    }

        if (tc.lstBaantjes.isEmpty()) {
            lbLeeg.setText("Lijst is leeg");
        } else {
            String recWaarde = "";
            for (Object rec : tc.geefOverzichtBaan())
            {
                recWaarde += "Soort ticket: " + ((BaantjesTicket) rec).getSoort() + " > Datum: " + ((BaantjesTicket) rec).getDatum() + "\n";
            }
            lbBaan.setText(recWaarde);
            lbTotaalBaan2.setText("" + tc.geefTotaalBaan());
        }

        btnBereken.setOnAction(e->{
            String baanTotaal = lbTotaalBaan2.getText();
            String recTotaal = lbTotaalRec2.getText();

                double iGetal1 = Double.parseDouble(baanTotaal);
                double iGetal2 = Double.parseDouble(recTotaal);

                double totaal = tc.geefTotaal(iGetal1, iGetal2);
                lbTotaal.setText("Totale opbrengst: €" + totaal);

        });


        root.add(lbRec, 0, 0);
        root.add(lbTotaalRec1, 1, 1);
        root.add(lbTotaalRec2, 2, 1);
        root.add(lbBaan, 0, 3);
        root.add(lbTotaalBaan1, 1, 4);
        root.add(lbTotaalBaan2, 2, 4);
        root.add(btnBereken, 0, 5);
        root.add(lbTotaal, 1, 5);

        oStage.setTitle("Overzicht Tickets");
        oStage.setScene(new Scene(root, 800, 600));
        oStage.show();

    }

}
