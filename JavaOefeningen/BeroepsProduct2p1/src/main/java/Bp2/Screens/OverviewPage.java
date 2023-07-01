package Bp2.Screens;


import Bp2.Applicatie;
import Bp2.Screens.Model.Code;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.Desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpRetryException;
import java.net.URI;
import java.net.URL;
import java.net.URLStreamHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OverviewPage implements Initializable {

    private static String apiURL = "https://api.sampleapis.com/codingresources/codingResources";

    //Arraylist gevuld met (words) JSON data
    ArrayList<String> words = new ArrayList<>();
    ArrayList<Code> codeResources = new ArrayList<>();

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Label LabelLevel;

    @FXML
    private ListView<String> MyListView;

    @FXML
    private ImageView SliderAfb;


    //opvanger page voor de geparsde JSON informatie
    public OverviewPage() throws IOException, ParseException {
        getCodingResources();
    }

    //zoekt de gegeven waarde in JSON data
    @FXML
    void Beginner(ActionEvent event) {
        MyListView.getItems().clear();
        MyListView.getItems().addAll(searchList(Button1.getText(), words));
    }

    @FXML
    void Intermediate(ActionEvent event) {
        MyListView.getItems().clear();
        MyListView.getItems().addAll(searchList(Button2.getText(), words));
    }

    @FXML
    void Advanced(ActionEvent event) {
        MyListView.getItems().clear();
        MyListView.getItems().addAll(searchList(Button3.getText(), words));
    }
    //mouseEvents -> label krijgt het label van de overheen gehoverde button(button1,button2,button3)
    public void handleLevelBeginner(MouseEvent mouseEvent) {
        LabelLevel.setText("Beginner");
    }

    public void handleLevelIntermediate(MouseEvent mouseEvent) {
        LabelLevel.setText("Intermediate");
    }

    public void handleLevelAdvanced(MouseEvent mouseEvent) {
        LabelLevel.setText("Advanced");
    }

    //mouseEvents -> label keert terug naar defaultstate wanneer de muis zich niet over een button(1,2,3) bevindt
    public void defaultState(MouseEvent mouseEvent) {
        LabelLevel.setText("Kies je niveau ->");
    }

    //veranderen Afbeelding uit imageview (SliderAfb)
    Image SliderImage = new Image(getClass().getResourceAsStream("/Bp2/Images/AfbPane2.png"));
    public void displayImage(){
        SliderAfb.setImage(SliderImage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MyListView.getItems().addAll(words);
    }

    //geeft de data met de gekozen waarde weer van de ingedrukte knop void-> beginner,intermediate,advanced
    private List<String> searchList(String searchWords, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }

    //JSON data binnenhalen
    private void getCodingResources() throws IOException, ParseException {
        URL url = new URL(apiURL);
        BufferedReader jsonString = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(jsonString);

        words.clear();

        System.out.println(jsonArray);

        //lopen door JSON data met de gewenste gefilterde data
        for (Object code : jsonArray) {
            JSONObject overviewData = (JSONObject) code;
            Code model = new Code(overviewData);

            System.out.println(model.getDescription());

            codeResources.add(model);
            words.add("-Beschrijving:" + "\n" +  model.getDescription()+ "\n" + "-Website:" + "\n" +model.getUrl()+ "\n" + "-Niveau:" +model.getLevels());
        }
    }

    //terugkeren naar de hoofdpagina
    public void BackToHomeScreen(MouseEvent mouseEvent) throws IOException {

        Parent backToHomeScreenParent = FXMLLoader.load(getClass().getResource("/Bp2/SceneBuilder.fxml"));

        Scene backToHomeScreenScene = new Scene(backToHomeScreenParent);

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        window.setScene(backToHomeScreenScene);
        window.show();

    }

    //item uit listview klikbaar maken
    public void handleItemClick(MouseEvent mouseEvent) throws IOException {
        String selectedItem = MyListView.getSelectionModel().getSelectedItem();
        int index = words.indexOf(selectedItem);
        String codeURL = codeResources.get(index).getUrl();
        // Desktop.getDesktop().browse(URI.create(codeURL));
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI.create(codeURL)) ;
        }

    }
}


