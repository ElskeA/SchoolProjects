module com.example.bp2randomizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bp2randomizer to javafx.fxml;
    exports com.example.bp2randomizer;
}