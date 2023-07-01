package com.example.tentamenprog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        GridPane root = new GridPane();

        Label lbWelkom = new Label("Welkom bij Verhuurbedrijf Electro. \n Maak een keuze:");
        RadioButton rbNieuw = new RadioButton("Nieuwe reservering");
        RadioButton rbLijst = new RadioButton("Opvragen reserveringslijst");
        ToggleGroup tgKeuze = new ToggleGroup();
        rbNieuw.setToggleGroup(tgKeuze);
        rbLijst.setToggleGroup(tgKeuze);

        rbNieuw.setOnAction(e->{
            ReserverenWindow res = new ReserverenWindow();
        });


        root.add(lbWelkom, 0, 0);
        root.add(rbNieuw, 0, 1);
        root.add(rbLijst, 0, 2);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Verhuurbedrijf");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}