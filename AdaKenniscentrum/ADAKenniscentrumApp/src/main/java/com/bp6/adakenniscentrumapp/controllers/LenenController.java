package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.views.ViewAfronden;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LenenController {

    private int bookID;
    private int userID;

    public LenenController(int bookID, int userID) {
        this.bookID = bookID;
        this.userID = userID;

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("insert into BorrowedBook(BorrowedID, Startdate, Returndate, Extend, BookID, UserID)values(null, curdate(), null, 0, "+bookID+", "+userID+");");
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
            ViewAfronden af = new ViewAfronden(3);

    }
}
