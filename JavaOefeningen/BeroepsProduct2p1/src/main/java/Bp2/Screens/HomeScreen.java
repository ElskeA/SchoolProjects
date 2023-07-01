package Bp2.Screens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeScreen implements Initializable {

    @FXML
    TextField searchField;

    @FXML
    Label myLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    //na het klikken van de button -> naar informatiePagina
    @FXML
    private void InformationAlert(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Bp2/InformationPage.fxml"));
            Parent rootl = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Applicatie informatie");
            stage.setScene(new Scene(rootl));
            stage.show();
        } catch (Exception e) {
            System.out.println("kannie loaden nie");
        }
    }

    //naar zoekpagina
    @FXML
    void searchWords(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Bp2/searchPage.fxml"));
        Parent root = loader.load();

        SearchPage searchpageController = loader.getController();
        searchpageController.displayName(searchField.getText());
        searchField.clear();
        Scene searchWordsScene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(searchWordsScene);
        window.show();

    }

    //na het klikken van de button -> naar overzichtPagina
    @FXML
    private void ChangeToOverviewPage(MouseEvent mouseEvent) throws IOException {

        Parent ChangeToOverviewPageParent = FXMLLoader.load(getClass().getResource("/Bp2/OverviewPage.fxml"));

        Scene ChangeToOverviewPageScene = new Scene(ChangeToOverviewPageParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(ChangeToOverviewPageScene);
        window.show();
    }


    //credits
    public void openWebpage(MouseEvent mouseEvent) throws IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI.create("https://www.womenwhocode.com/"));

        }
    }
}
