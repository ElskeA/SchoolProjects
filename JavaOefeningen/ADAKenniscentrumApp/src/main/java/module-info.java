module com.bp6.adakenniscentrumapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires json.simple;


    opens com.bp6.adakenniscentrumapp to javafx.fxml;
    exports com.bp6.adakenniscentrumapp;
}