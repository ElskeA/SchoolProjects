package com.example.proeftoets_gameverhuur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        ResController rc = new ResController();

        FlowPane root = new FlowPane();


        Button btnReserveren = new Button("Reserveren");
        Button btnOverzicht = new Button("Overzicht");
        Button btnTable = new Button("OverzichtTable");

        btnReserveren.setOnAction(e->{
            ReserverenWindow res = new ReserverenWindow(rc);
        });

        btnOverzicht.setOnAction(e->{
            OverzichtWindow ov = new OverzichtWindow(rc);
        });

        btnTable.setOnAction(e->{
            TableWindow tv = new TableWindow(rc);
        });


        root.getChildren().addAll(btnReserveren, btnOverzicht, btnTable);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Gameverhuur");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}