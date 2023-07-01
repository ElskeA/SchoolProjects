package com.example.progtoets;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TicketController tc = new TicketController();
        FlowPane root = new FlowPane();

        Button btnRecreatie = new Button("Recreatiezwemmen");
        Button btnBaantjes = new Button("Baantjeszwemmen");
        Button btnOverzicht = new Button("Overzicht");

        btnRecreatie.setOnAction(e->
        {
            RecreatieWindow rc = new RecreatieWindow(tc);
        });

        btnBaantjes.setOnAction(e->
        {
            BaantjesWindow bw = new BaantjesWindow(tc);
        });

        btnOverzicht.setOnAction(e->{
            Overzicht ov = new Overzicht(tc);
        });

        root.getChildren().addAll(btnRecreatie, btnBaantjes, btnOverzicht);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Zwembad Bovenwater");
        stage.setScene(scene);
        stage.show();

    }
}
