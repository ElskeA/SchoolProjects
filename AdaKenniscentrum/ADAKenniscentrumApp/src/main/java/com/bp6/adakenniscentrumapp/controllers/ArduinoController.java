package com.bp6.adakenniscentrumapp.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ArduinoController {

    private int id;

//    private int nfc;

    public ArduinoController(int id) {
        this.id = id;

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(
                        "insert into Arduino(ArduinoID, NFC)values("+id+", null);");
            }
        } catch (Exception o) {
            o.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException o) {
                    o.printStackTrace();
                }
            }
        }

    }
}
