module com.example.loopoef {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loopoef to javafx.fxml;
    exports com.example.loopoef;
}