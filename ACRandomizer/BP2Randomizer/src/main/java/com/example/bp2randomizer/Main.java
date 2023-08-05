package com.example.bp2randomizer;

import com.example.bp2randomizer.Controllers.Randomiser;
import com.example.bp2randomizer.Models.Personalities;
import com.example.bp2randomizer.Models.Species;
import com.example.bp2randomizer.Views.Villagers;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Personalities ps = new Personalities();
        List<String> lstPerson = ps.geefList();
        Species spec = new Species();
        List<String> lstSpecies = spec.geefList();

        Pane root = new Pane();
        root.setId("rootPane");
        Scene scene = new Scene(root, 1468, 1004);
        scene.getStylesheets().add(getClass().getResource("/Stylesheet.css").toExternalForm());

        Label lbIntro = new Label("Don't know what villagers to get to liven up your island? \nBrowse from either of the categories below, or if you're feeling \nadventurous, hit the button and we'll pick them all for you!");
        lbIntro.setId("list");
        lbIntro.relocate(135, 235);

        Image imgButton = new Image("button.png");
        ImageView vButton = new ImageView(imgButton);
        vButton.relocate(1053, 253);
        vButton.setOnMouseClicked(event -> {
            Randomiser.generateAndPrintRandomNumbers(10,1,413);
            Villagers v = new Villagers();
        });

        Label lbPerson = new Label("Personalities");
        lbPerson.setId("header");
        lbPerson.relocate(150, 454);

        Label lbSpecies = new Label("Species");
        lbSpecies.setId("header");
        lbSpecies.relocate(595, 454);

        GridPane perPane = createGridPane(lstPerson, 2, 4, 35, 50, 150, 550);
        GridPane specPane = createGridPane(lstSpecies, 5, (int) Math.ceil(lstSpecies.size() / 5.0), 35, 20, 590, 525);

        root.getChildren().addAll(vButton, specPane, perPane, lbIntro, lbPerson, lbSpecies);

        primaryStage.setTitle("Animal Crossing Randomiser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane createGridPane(List<String> dataList, int numColumns, int numRows, double hgap, double vgap, double relocateX, double relocateY) {
        GridPane gridPane = new GridPane();
        gridPane.relocate(relocateX, relocateY);
        gridPane.setHgap(hgap);
        gridPane.setVgap(vgap);
        gridPane.setPadding(new Insets(10));

        int index = 0;
        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows; row++) {
                if (index < dataList.size()) {
                    Label label = new Label(dataList.get(index));
                    label.setId("list");
                    gridPane.add(label, col, row);
                    index++;
                }
            }
        }

        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}
