module com.example.cijferssorteren {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cijferssorteren to javafx.fxml;
    exports com.example.cijferssorteren;
}