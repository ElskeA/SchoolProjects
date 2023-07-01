package com.example.fit4you;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    AbController ac = new AbController();

    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();

        Label lbTitel = new Label("Kies het type abbonement:");
        Button btnIndi = new Button("Individueel");
        Button btnGezin = new Button("Gezin");
        Button btnOverzicht = new Button("Overzicht");

        btnOverzicht.setOnAction(e->{
            System.out.println("Totaal Ind: " + ac.geefTotaalPrijsInd());
            System.out.println("Totaal Gez: " + ac.geefTotaalPrijsGez());
        });

        btnGezin.setOnAction(e->{
            GezinScreen gs = new GezinScreen(ac);
        });

        btnIndi.setOnAction(e->{
            IndScreen is = new IndScreen(ac);
        });

        root.add(lbTitel, 0,0);
        root.add(btnIndi, 1, 0);
        root.add(btnGezin, 1, 1);
        root.add(btnOverzicht, 1, 2);


        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}