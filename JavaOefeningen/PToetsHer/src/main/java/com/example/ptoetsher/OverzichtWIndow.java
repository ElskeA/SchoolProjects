package com.example.ptoetsher;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class OverzichtWIndow {
    public OverzichtWIndow(Controller c){

        Stage OverStage = new Stage();
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 800, 600);
        Label lbUitvoer = new Label(" ");

        StringBuilder sUivoer = new StringBuilder();
        for(Gegevens g : c.getLstGegevens()) {
            sUivoer.append(g).append("\n");

//        for(Object txtGev : c.geefGegevens()){
//            System.out.println(((Gegevens)txtGev).getNaamKlant());
//            sUivoer.append(((Gegevens) txtGev).getNaamKlant()).append("\n");
        }

        lbUitvoer.setText(sUivoer.toString());

        root.getChildren().addAll(lbUitvoer);
        OverStage.setTitle("GameVerkoper");
        OverStage.setScene(scene);
        OverStage.show();
    }
}