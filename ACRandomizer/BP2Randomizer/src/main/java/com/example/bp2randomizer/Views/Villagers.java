package com.example.bp2randomizer.Views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Villagers {

  public Villagers(){

    Pane root = new Pane();
    root.setId("villagerPane");
    Scene scene = new Scene(root, 1468, 1004);
    scene.getStylesheets().add(getClass().getResource("/Stylesheet.css").toExternalForm());

    Label lb1 = new Label("Test 1");
    lb1.relocate(82, 225);
    lb1.setId("villagerName");

    root.getChildren().addAll(lb1);

    Stage vstage = new Stage();
    vstage.setScene(scene);
    vstage.show();
  }

}
