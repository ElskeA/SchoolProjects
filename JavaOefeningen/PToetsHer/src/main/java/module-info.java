module com.example.ptoetsher {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ptoetsher to javafx.fxml;
    exports com.example.ptoetsher;
}