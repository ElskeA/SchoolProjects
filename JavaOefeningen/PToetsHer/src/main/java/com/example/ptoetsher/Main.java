package com.example.ptoetsher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Controller c = new Controller();
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 800, 600);

        Button btnNaarGegevens = new Button("Reserveren");
        Button btnOverzicht = new Button("Overzicht");
        Button btnTableOverzicht = new Button("Table Overzicht");

        btnNaarGegevens.setOnAction(e->{
            GegevensWindow gev = new GegevensWindow(c);
        });
        btnOverzicht.setOnAction(e->{
            OverzichtWIndow ove = new OverzichtWIndow(c);
        });
        btnTableOverzicht.setOnAction(e->{
            TableWindow tab = new TableWindow(c);
        });

        root.getChildren().addAll(btnNaarGegevens, btnOverzicht, btnTableOverzicht);
        stage.setTitle("GameVerkoper");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}