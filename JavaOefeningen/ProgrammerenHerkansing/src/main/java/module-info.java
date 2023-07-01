module com.example.progtoets {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progtoets to javafx.fxml;
    exports com.example.progtoets;
}