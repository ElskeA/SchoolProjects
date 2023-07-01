package com.example.binairzoeken;

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

        StackList sl = new StackList();


        int arr[] ={1, 4, 6, 12, 23, 34, 56, 78, 100, 150, 168};

        System.out.println(bSearch(100, arr, 0, arr.length-1));

    }


    public int bSearch(int x, int arr[], int begin, int end){
        if(begin > end) return -1;

        //Het midden bepalen van de index
        int midden = (begin + end) /2;

        if(arr[midden] == x){
            return midden;
        }else if(x > arr[midden]){
            //x is groter dan midden. Nieuw startpunt wordt midden om verder te zoeken in kleinere scope
            return bSearch(x, arr, midden + 1, end);
        }else if(x < arr[midden]){
            return bSearch(x, arr, begin, midden - 1);
        }
        //return geeft nummer van de plaats in de index waar het nummer is gevonden
        return midden;
    }



    public static void main(String[] args) {
        launch();
    }
}