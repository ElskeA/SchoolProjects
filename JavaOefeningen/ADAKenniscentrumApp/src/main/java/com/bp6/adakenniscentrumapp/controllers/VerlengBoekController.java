package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.views.ViewAfronden;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class VerlengBoekController {

    private int userID;
    private int bookID;

    public VerlengBoekController(int userID, int bookID) {
        this.userID = userID;
        this.bookID = bookID;

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("UPDATE BorrowedBook SET Extend = 1 WHERE UserID = "+userID+" AND BookID = "+bookID+";");
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
