module com.example.beroepsproduct2p1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires json.simple;
    requires java.desktop;

    opens Bp2 to javafx.fxml;
    exports Bp2;
    exports Bp2.Screens;
    opens Bp2.Screens to javafx.fxml;
    exports Bp2.Screens.Model;
    opens Bp2.Screens.Model to javafx.fxml;
}