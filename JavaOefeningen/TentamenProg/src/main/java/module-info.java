module com.example.tentamenprog {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tentamenprog to javafx.fxml;
    exports com.example.tentamenprog;
}