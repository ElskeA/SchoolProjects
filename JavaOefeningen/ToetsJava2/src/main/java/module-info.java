module com.example.toetsjava2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.toetsjava2 to javafx.fxml;
    exports com.example.toetsjava2;
}