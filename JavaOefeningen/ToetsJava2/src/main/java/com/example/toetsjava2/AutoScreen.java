package com.example.toetsjava2;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AutoScreen {

    public AutoScreen(VController vc){
        Stage stage = new Stage();
        GridPane root = new GridPane();

        Label lbBjaar = new Label("Bouwjaar: ");
        Label lbBstof = new Label("Brandstof: ");
        Label lbKenteken = new Label("Kenteken: ");
        Label lbMerk = new Label("Merk: ");
        Label lbPpk = new Label("Prijs p. kilometer: ");
        Label lbStatus = new Label("Status: ");
        Label lbDatum = new Label("Datum: ");
        Label lbTijd = new Label("Tijd: ");
        Label lbSp = new Label("Startpunt: ");
        Label lbEb = new Label("Eindbestemming");
        Label lbSoort = new Label("Soort: ");

        TextField txtSoort = new TextField();
        TextField txtBjaar = new TextField();
        TextField txtBstof = new TextField();
        TextField txtKenteken = new TextField();
        TextField txtMerk = new TextField();
        TextField txtPpk = new TextField();
        String[] statusString = {"Bezet", "In onderhoud", "Vrij"};
        ComboBox cbStatus = new ComboBox(FXCollections.observableArrayList(statusString));
        DatePicker dp = new DatePicker();
        TextField txtTijd = new TextField();
        TextField txtSp = new TextField();
        TextField txtEb = new TextField();

        Button btnOpslaan = new Button("Opslaan");
        btnOpslaan.setOnAction(e->{
            try{
                Auto a = new Auto(dp.getValue().toString(),
                                    txtTijd.getText(),
                                    txtSp.getText(),
                                    txtEb.getText(),
                                    txtBjaar.getText(),
                                    txtBstof.getText(),
                                    txtKenteken.getText(),
                                    txtMerk.getText(),
                                    Double.parseDouble(txtPpk.getText()),
                                    cbStatus.getValue().toString(),
                                    txtSoort.getText());
                vc.opslaanV(a);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Opgeslagen");
                alert.showAndWait();
            }catch(NumberFormatException nr)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Let op nummer invoer");
                alert.showAndWait();
            }
                finally
                {
                    txtPpk.setText("0");
                }

        });


        root.add(lbBjaar, 0, 1);
        root.add(txtBjaar, 1, 1);
        root.add(lbBstof, 0, 2);
        root.add(txtBstof, 1, 2);
        root.add(lbKenteken, 0, 3);
        root.add(txtKenteken, 1, 3);
        root.add(lbMerk, 0, 4);
        root.add(txtMerk, 1, 4);
        root.add(lbPpk, 0, 5);
        root.add(txtPpk, 1, 5);
        root.add(lbStatus, 0, 6);
        root.add(cbStatus, 1, 6);
        root.add(lbSoort, 0, 7);
        root.add(txtSoort, 1, 7);
        root.add(lbDatum, 0, 8);
        root.add(dp, 1, 8);
        root.add(lbTijd, 0, 9);
        root.add(txtTijd, 1, 9);
        root.add(lbSp, 0, 10);
        root.add(txtSp, 1, 10);
        root.add(lbEb, 0, 11);
        root.add(txtEb, 1, 11);
        root.add(btnOpslaan, 1, 12);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Auto");
        stage.setScene(scene);
        stage.show();
    }

}
