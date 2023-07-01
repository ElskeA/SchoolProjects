package Bp2.Screens;

import Bp2.Screens.Model.Code;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage implements Initializable {

    private static String apiURL = "https://api.sampleapis.com/codingresources/codingResources";

    //arraylist om de gegevens in op te slaan
    ArrayList<String> keyWords = new ArrayList<>();
    ArrayList<Code> codeResources = new ArrayList<>();

    @FXML
    Label nameLabel;

    @FXML
    private ListView<String> listView;

    @FXML
    private ImageView SliderAfb;


    public SearchPage() throws IOException, ParseException {
        getCodingResources();
    }

    //"slider" afbeeldingen
    javafx.scene.image.Image SliderImage = new Image(getClass().getResourceAsStream("/Bp2/Images/AfbPane3.png"));
    public void displayImage(){
        SliderAfb.setImage(SliderImage);
    }

    public void displayName(String searchedWords) {
        nameLabel.setText("Gekozen woord: " + searchedWords);
        List<String> filterList = searchList(searchedWords, keyWords);
        listView.getItems().addAll(filterList);

        //als de lijst 0 items bevat -> melding
        if (listView.getItems().size() > 0){
        }else {
            Alert searchedWordsFailedAlert = new Alert(Alert.AlertType.INFORMATION);
            DialogPane dialogPane = searchedWordsFailedAlert.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("/StylingCSS/dialogs.css").toExternalForm());
            dialogPane.getStyleClass().add("dialog");
            searchedWordsFailedAlert.setContentText("Het kan zijn dat uw getypte trefwoord niet voorkomt in de Coding-recourses-lijst. " +
                    "Wanneer de lijst leeg is, ga dan terug naar de hoofdpagina en probeer een ander trefwoord.");
            searchedWordsFailedAlert.showAndWait();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    private List<String> searchList(String searchWords, ArrayList<String> listOfStrings) {
        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> searchWordsArray.stream().allMatch(word ->
                input.toLowerCase().contains(word.toLowerCase()))).collect(Collectors.toList());

    }

    private void getCodingResources() throws IOException, ParseException {
        URL url = new URL(apiURL);
        BufferedReader jsonString = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(jsonString);

        keyWords.clear();

        System.out.println(jsonArray);

        //lopen door JSON data met de gewenste gefilterde data deze toevoegen aan de lijst
        for (Object code : jsonArray) {
            JSONObject searchData = (JSONObject) code;
            Code model = new Code(searchData);

            System.out.println(model.getDescription());

            codeResources.add(model);
            keyWords.add("-Beschrijving:"+ "\n" + model.getDescription() + "\n" + "-Topics:"+ "\n" +model.getTopics() + "\n" +  "-Website:"+ "\n" + model.getUrl());

        }
}


    //lijst item klikbaar maken
    public void handleItemClick(MouseEvent mouseEvent) throws IOException {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        int index = keyWords.indexOf(selectedItem);
        String codeURL = codeResources.get(index).getUrl();
        // Desktop.getDesktop().browse(URI.create(codeURL));
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI.create(codeURL)) ;
        }
    }
    //terug keren naar het hoofdscherm
    public void BackToHomeScreen(MouseEvent mouseEvent) throws IOException {
        Parent changeToSearchWordsParent = FXMLLoader.load(getClass().getResource("/Bp2/SceneBuilder.fxml"));

        Scene changeToSearchWordsScene = new Scene(changeToSearchWordsParent);

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        window.setScene(changeToSearchWordsScene);
        window.show();

    }
}

