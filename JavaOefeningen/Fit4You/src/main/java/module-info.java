module com.example.fit4you {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fit4you to javafx.fxml;
    exports com.example.fit4you;
}