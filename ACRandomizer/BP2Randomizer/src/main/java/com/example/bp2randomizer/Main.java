package com.example.bp2randomizer;

import com.example.bp2randomizer.Models.Personalities;
import com.example.bp2randomizer.Models.Species;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {

        Personalities ps = new Personalities();
        Species spec = new Species();

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #C4E9EB");
        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("Stylesheet.css");

        Pane wp = new Pane();
        wp.setId("rootPane");
        wp.relocate(226, 32);

        Image imgInfo = new Image("Info.png");
        ImageView vInfo = new ImageView(imgInfo);
        vInfo.relocate(85, 181);

        Image imgPers = new Image("Personalities.png");
        ImageView vPers = new ImageView(imgPers);
        vPers.relocate(85, 436);

        Image imgSpecies = new Image("Species.png");
        ImageView vSpec = new ImageView(imgSpecies);
        vSpec.relocate(538, 436);

        Image imgButton = new Image("bluebtn.png");
        ImageView vButton = new ImageView(imgButton);
        vButton.relocate(1053, 253);

        HBox hb = new HBox();
        hb.relocate(594, 551);
        hb.setSpacing(20);

        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        VBox vb3 = new VBox();
        VBox vb4 = new VBox();
        VBox vb5 = new VBox();

        for(int i = 0; i < spec.geefList().size(); i++){
            String curr = (String) spec.geefList().get(i);
            System.out.println(curr);
        }

        wp.getChildren().addAll(vInfo, vPers, vSpec, vButton);

        root.getChildren().addAll(wp);
        primaryStage.setTitle("Animal Crossing Randomizer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}