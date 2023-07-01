package Bp2;

import Bp2.Screens.Model.Code;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Applicatie extends Application {


    

    @Override
    public void start(Stage stage) throws IOException, ParseException {

        //hoofdscherm zichtbaar maken
        stage.setTitle("Coding Recourses");
        Parent SceneBuilderRoot = FXMLLoader.load(getClass().getResource("/Bp2/SceneBuilder.fxml"));
        Scene home = new Scene(SceneBuilderRoot);

        stage.setScene(home);
        stage.setResizable(false);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
