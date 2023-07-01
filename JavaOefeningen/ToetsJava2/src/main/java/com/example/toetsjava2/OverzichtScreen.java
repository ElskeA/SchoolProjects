package com.example.toetsjava2;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OverzichtScreen {

    public OverzichtScreen(VController vc){
        Stage stage = new Stage();
        GridPane root = new GridPane();

        Label lbAuto = new Label("Auto");
        lbAuto.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20");
        Label lbAutoRes = new Label("");
        lbAutoRes.setText(vc.geefAuto());

        Label lbBus = new Label("Familie bus");
        lbBus.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20");
        Label lbBusRes = new Label("");
        lbBusRes.setText(vc.geefBus());

        Label lbMotor = new Label("Motor");
        lbMotor.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20");
        Label lbMotorRes = new Label("");
        lbMotorRes.setText(vc.geefMotor());

        Label lbCar = new Label("Touring car");
        lbCar.setStyle("-fx-font-weight: BOLD; -fx-font-size: 20");
        Label lbCarRes = new Label("");

        lbCarRes.setText(vc.geefTour());


        root.add(lbAuto, 0, 0);
        root.add(lbAutoRes, 0, 1);

        root.add(lbBus, 1, 0);
        root.add(lbBusRes, 1, 1);

        root.add(lbMotor, 2, 0);
        root.add(lbMotorRes, 2, 1);

        root.add(lbCar, 3, 0);
        root.add(lbCarRes, 3, 1);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Overzicht reserveringen");
        stage.setScene(scene);
        stage.show();
    }

}
