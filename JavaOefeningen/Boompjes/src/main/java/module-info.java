module com.example.boompjes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.boompjes to javafx.fxml;
    exports com.example.boompjes;
}