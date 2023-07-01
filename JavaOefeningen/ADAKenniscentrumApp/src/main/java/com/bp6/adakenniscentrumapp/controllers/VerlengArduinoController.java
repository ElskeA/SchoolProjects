package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.views.ViewAfronden;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class VerlengArduinoController {

    private int userID;
    private int ardID;

    public VerlengArduinoController(int userID, int ardID) {
        this.userID = userID;
        this.ardID = ardID;

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("UPDATE BorrowedArduino SET Extend = 1 WHERE UserID = "+userID+" AND ArduinoID = "+ardID+";");
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
        ViewAfronden af = new ViewAfronden(4);

    }

}
