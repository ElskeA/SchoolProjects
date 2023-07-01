package com.example.ptoetsher;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableWindow {
    public TableWindow(Controller c){
        Stage tableStage = new Stage();
        TableView<Gegevens> tableView =new TableView<Gegevens>();
        Scene scene = new Scene(tableView, 1200, 800);

        ObservableList<Gegevens> oLstGegevens = FXCollections.observableArrayList(c.lstGegevens);
        System.out.println(oLstGegevens);


        TableColumn<Gegevens,String> naamCol = new TableColumn<Gegevens, String>("Voornaam");
        naamCol.setCellValueFactory(new PropertyValueFactory("NaamKlant"));
        naamCol.setMinWidth(100);

        TableColumn<Gegevens,String> adresCol = new TableColumn<>("Adres");
        adresCol.setCellValueFactory(new PropertyValueFactory("Adres"));
        adresCol.setMinWidth(100);

        TableColumn<Gegevens,String> postcodeCol = new TableColumn<>("Postcode");
        postcodeCol.setCellValueFactory(new PropertyValueFactory("Postcode"));
        postcodeCol.setMinWidth(100);

        TableColumn<Gegevens,String> woonCol = new TableColumn<>("Woonplaats");
        woonCol.setCellValueFactory(new PropertyValueFactory("Woonplaats"));
        woonCol.setMinWidth(100);

        TableColumn<Gegevens,String> gebCol = new TableColumn<>("Geboorte Datum");
        gebCol.setCellValueFactory(new PropertyValueFactory("GebDatum"));
        gebCol.setMinWidth(100);

        TableColumn<Gegevens,String> EmailTelCol = new TableColumn<>("Email en Telefoonnummer");
        EmailTelCol.setCellValueFactory(new PropertyValueFactory("EmailEnTel"));
        EmailTelCol.setMinWidth(200);

        TableColumn<Gegevens,String> spelCol = new TableColumn<>("Spel");
        spelCol.setCellValueFactory(new PropertyValueFactory("NaamSpel"));
        spelCol.setMinWidth(100);

        TableColumn<Gegevens,String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(new PropertyValueFactory("Type"));
        typeCol.setMinWidth(100);

        TableColumn<Gegevens,String> uitCol = new TableColumn<>("Uitleen");
        uitCol.setCellValueFactory(new PropertyValueFactory("UitDatum"));
        uitCol.setMinWidth(100);

        TableColumn<Gegevens,String> retCol = new TableColumn<>("Retour");
        retCol.setCellValueFactory(new PropertyValueFactory("RetDatum"));
        retCol.setMinWidth(100);

        tableView.setItems(oLstGegevens);
        tableView.getColumns().setAll(naamCol, adresCol, postcodeCol, woonCol, gebCol, EmailTelCol, spelCol, typeCol, uitCol, retCol);

        tableStage.setTitle("Table");
        tableStage.setScene(scene);
        tableStage.show();


    }
}
