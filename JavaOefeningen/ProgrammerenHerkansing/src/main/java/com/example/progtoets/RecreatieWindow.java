package com.example.progtoets;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;

public class RecreatieWindow {

  public RecreatieWindow(TicketController tc) {
      Stage recStage = new Stage();

      GridPane root = new GridPane();

      Label lbSoort = new Label("Recreatiezwemmen");
      Label lbBarcode = new Label("Voer een barcode in: ");
      Label lbDatum = new Label("Kies een datum: ");
      Label lbTijd = new Label("Kies een tijd: ");
      Label lbPostcode = new Label("Postcode: ");
      Label lbWoonplaats = new Label("Woonplaats: ");

      DatePicker dpRec = new DatePicker();
      String[] tijdStrings = {"10:00", "13:00", "15:00"};
      ComboBox cmbTijd = new ComboBox(FXCollections.observableArrayList(tijdStrings));
      TextField txtPostcode = new TextField();
      TextField txtWoonplaats = new TextField();
      TextField txtBarcode = new TextField();

      Button btnOpslaan = new Button("Opslaan");

      btnOpslaan.setOnAction(e->{
          RecreatieTicket bt = new RecreatieTicket(lbSoort.getText(),
                  txtBarcode.getText(),
                  dpRec.getValue().toString(),
                  cmbTijd.getValue().toString(),
                  txtPostcode.getText(),
                  txtWoonplaats.getText());
          tc.opslaanRecreatie(bt);
      });

      root.add(lbSoort, 0, 0);
      root.add(lbPostcode, 0, 1);
      root.add(txtPostcode, 1, 1);
      root.add(lbWoonplaats, 0, 2);
      root.add(txtWoonplaats, 1, 2);
      root.add(lbDatum, 0, 3);
      root.add(dpRec, 1, 3);
      root.add(lbTijd, 0, 4);
      root.add(cmbTijd, 1, 4);
      root.add(lbBarcode, 0, 5);
      root.add(txtBarcode, 1, 5);
      root.add(btnOpslaan, 0, 6);

      recStage.setTitle("Recreatiezwemmen");
      recStage.setScene(new Scene(root, 800, 600));
      recStage.show();

  }
}
