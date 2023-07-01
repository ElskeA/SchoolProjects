module com.example.binairzoeken {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.binairzoeken to javafx.fxml;
    exports com.example.binairzoeken;
}