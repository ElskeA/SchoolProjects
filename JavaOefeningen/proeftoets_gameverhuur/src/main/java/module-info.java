module com.example.proeftoets_gameverhuur {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proeftoets_gameverhuur to javafx.fxml;
    exports com.example.proeftoets_gameverhuur;
}