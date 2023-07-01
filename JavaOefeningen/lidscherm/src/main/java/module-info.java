module com.example.lidscherm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lidscherm to javafx.fxml;
    exports com.example.lidscherm;
}