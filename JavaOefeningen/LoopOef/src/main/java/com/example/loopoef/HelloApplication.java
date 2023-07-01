package com.example.loopoef;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        int arr[] = {10, 1, 9, 45, 6, 12, 34, 54, 90, 112, 2, 0, 4};

        sorteren(arr);

    }

    public void sorteren(int arr[]) {
        int iTemp = 0;

        //eerste for laat de tweede for zovaak door de loop heenlopen zodat het alle nummers heeft gehad
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    iTemp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = iTemp;
                }
            }

            for (int p : arr)
            {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}