package com.example.toetsjava2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.Timestamp;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VController vc = new VController();

        FlowPane root = new FlowPane();

        Label lbTitel = new Label("Kies een voertuig: ");
        Label lbOverzicht = new Label();
        RadioButton rbMotor = new RadioButton("Motor");
        RadioButton rbBus = new RadioButton("Familie bus");
        RadioButton rbAuto = new RadioButton("Auto");
        RadioButton rbCar = new RadioButton("Touringcar");

        ToggleGroup tg = new ToggleGroup();
        rbBus.setToggleGroup(tg);
        rbMotor.setToggleGroup(tg);
        rbAuto.setToggleGroup(tg);
        rbCar.setToggleGroup(tg);

        Button btnOverzicht = new Button("Geef overzicht");

        btnOverzicht.setOnAction(e->{
                if(vc.vlijst.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Er zijn geen reserveringen");
                    alert.showAndWait();
                }else{
                    OverzichtScreen os = new OverzichtScreen(vc);
                }
        });

        rbMotor.setOnAction(e->
        {
            MotorScreen ms = new MotorScreen(vc);
        });

        rbBus.setOnAction(e->
        {
            BusScreen bs = new BusScreen(vc);
        });

        rbCar.setOnAction(e->
        {
            TouringScreen ts = new TouringScreen(vc);
        });

        rbAuto.setOnAction(e->
        {
            AutoScreen as = new AutoScreen(vc);
        });


        root.getChildren().addAll(lbTitel, rbMotor, rbBus, rbCar, rbAuto, btnOverzicht, lbOverzicht);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Goed op weg!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}