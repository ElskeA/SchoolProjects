package com.example.proeftoets_gameverhuur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableWindow {
    public TableWindow(ResController rc){
        Stage tableStage = new Stage();
        TableView<Reservering> tableView = new TableView<Reservering>();
        Scene scene = new Scene(tableView, 800, 600);

        ObservableList<Reservering> oLstReservering = FXCollections.observableArrayList(rc.lstOverzicht);
        System.out.println(oLstReservering);

        TableColumn<Reservering, String> naamCol = new TableColumn<Reservering, String>("Naam");
        naamCol.setCellValueFactory(new PropertyValueFactory("Naam"));
        naamCol.setMinWidth(100);

        TableColumn<Reservering, String> gameCol = new TableColumn<Reservering, String>("Game");
        gameCol.setCellValueFactory(new PropertyValueFactory<>("Game"));
        gameCol.setMinWidth(100);

        TableColumn<Reservering, String> totaalCol = new TableColumn<>("Totaal");
        totaalCol.setCellValueFactory(new PropertyValueFactory<>("€" + rc.geefTotaal()));

        tableView.setItems(oLstReservering);
        tableView.getColumns().setAll(naamCol, gameCol);

        tableStage.setTitle("Table");
        tableStage.setScene(scene);
        tableStage.show();
    }

}
