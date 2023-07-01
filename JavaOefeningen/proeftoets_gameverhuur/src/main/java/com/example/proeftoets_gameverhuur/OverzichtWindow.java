package com.example.proeftoets_gameverhuur;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OverzichtWindow {


    public OverzichtWindow(ResController rc){
        Stage deStage = new Stage();
        GridPane root = new GridPane();

        Label lbTitle = new Label("Overzicht reserveringen");
        lbTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 30");

        Label resNaam = new Label("");
        resNaam.setStyle("-fx-font-family: Calibri");
        Label lbTotaal = new Label("");
        lbTotaal.setStyle("-fx-text-fill: green; -fx-font-weight: bold");


        if (rc.lstOverzicht.isEmpty()) {
            System.out.println("Lijst is leeg");
        }else{
            String resWaarde = "";
            for (Object res : rc.geefOverzicht())
            {
                  resWaarde += "Naam: " + ((Reservering)res).getNaam() + " > Game: " + ((Reservering) res).getGame() + "\n";
            }
            resNaam.setText(resWaarde);
            lbTotaal.setText("Totaal: €" + rc.geefTotaal());

        }

        root.add(lbTitle, 4, 0);
        root.add(resNaam, 3, 2);
        root.add(lbTotaal, 1, 3);


        //root.getChildren().addAll(lbTitle, resNaam, lbTotaal);


        deStage.setTitle("Overzicht");
        deStage.setScene(new Scene(root, 800, 600));
        deStage.show();
    }

}
