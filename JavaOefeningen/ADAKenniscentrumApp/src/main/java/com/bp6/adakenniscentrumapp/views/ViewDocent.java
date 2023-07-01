package com.bp6.adakenniscentrumapp.views;

import com.bp6.adakenniscentrumapp.controllers.ArduinoController;
import com.bp6.adakenniscentrumapp.controllers.BoekAPI;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ViewDocent {

    public ViewDocent(int userID){
        String srcLogo = "file:src/main/resources/com/bp6/adakenniscentrumapp/Images/ADA_Logo-2020.png";
        String srcClose = "file:src/main/resources/com/bp6/adakenniscentrumapp/Images/ButtonClose.png";

        Pane root = new Pane();
        Stage stageDocent = new Stage();
        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("Stylesheet.css");
        root.setStyle("-fx-background-color: WHITE");

        Image imgLogo = new Image(srcLogo);
        ImageView viewLogo = new ImageView();
        viewLogo.setImage(imgLogo);
        viewLogo.relocate(45, 45);

        Image imgButton = new Image(srcClose, 80, 80, false, false);
        ImageView btnClose = new ImageView(imgButton);
        btnClose.relocate(1790, 45);
        btnClose.setOnMouseClicked(e->{

        });

        Label lbTitel = new Label("Kies een item om toe te voegen");
        lbTitel.setId("titleText");
        lbTitel.relocate(585, 326);

        TextField tfItem = new TextField();
        tfItem.relocate(528, 550);
        tfItem.setPromptText("ISBN");
        tfItem.setId("textField");
        tfItem.setFocusTraversable(false);

        RadioButton rbBoek = new RadioButton("Boek");
        rbBoek.relocate(609, 441);
        RadioButton rbArduino = new RadioButton("Arduino");
        rbArduino.relocate(1037, 440);
        ToggleGroup tgItem = new ToggleGroup();
        rbBoek.setToggleGroup(tgItem);
        rbArduino.setToggleGroup(tgItem);
        rbBoek.setSelected(true);


        Button btnVolgende = new Button("Volgende");
        btnVolgende.setId("greenButton");
        btnVolgende.relocate(1058, 853);

        Button btnVorige = new Button("Vorige");
        btnVorige.setId("greenButton");
        btnVorige.relocate(487, 853);

        btnVorige.setOnAction(e->{
            stageDocent.close();
        });

        rbBoek.setOnAction(e->{
            tfItem.setPromptText("ISBN");
        });
        rbArduino.setOnAction(e->{
            tfItem.setPromptText("ID Nummer");
        });

        btnVolgende.setOnAction(e->{
            if (rbArduino.isSelected()){
                System.out.println("Arduino kit gekozen");
                if (tfItem.getText().isBlank()){
                    System.out.println("Niks ingevuld");
                    tfItem.setPromptText("Vul een nieuw ID nummer in");
                } else if (!tfItem.getText().isBlank()) {
                    System.out.println("Wel gevuld");
                    int id = Integer.parseInt(tfItem.getText());
                    //Meteen query naar DB
                    //Moet ook nog een NFC id mee kunnen geven
                    ArduinoController ac = new ArduinoController(id);
                    ViewAfronden af = new ViewAfronden(2);
                }
            } else if (rbBoek.isSelected()) {
                System.out.println("boek gekozen");
                if(tfItem.getText().isBlank()){
                    tfItem.setPromptText("Vul een ISBN in");
                } else if (!tfItem.getText().isBlank()) {
                    System.out.println("Wel gevuld");
                    String isbn = tfItem.getText();
                    try {
                        BoekAPI api = new BoekAPI(isbn);
                    } catch (IOException | ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("ISBN voor api: " + isbn);
                }

            }
        });

        root.getChildren().addAll(lbTitel, tfItem, rbBoek, rbArduino, btnVolgende, btnVorige, viewLogo, btnClose);
        stageDocent.setTitle("Docent");
        stageDocent.setScene(scene);
        stageDocent.show();
    }


}
