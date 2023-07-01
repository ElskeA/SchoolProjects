package com.example.cijferssorteren;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        int array [] = {12, 5, 33, 2, 79, 120, 3, 10};

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}