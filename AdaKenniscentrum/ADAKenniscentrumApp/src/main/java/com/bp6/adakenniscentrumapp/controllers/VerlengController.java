package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.views.ViewVerlengen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerlengController {

    private int userID;

    public VerlengController(int userID) {
        this.userID = userID;

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT ArduinoID ,b.BookID,bk.Title,b.UserID,ba.Extend FROM BorrowedArduino ba JOIN BorrowedBook b ON ba.Extend = b.Extend JOIN Users u ON b.UserID = u.UserID JOIN Book bk ON b.BookID = bk.BookID WHERE ba.UserID = "+userID+" AND ba.Extend = 0;");

                NieuwBoekArray ba = new NieuwBoekArray();
                while(rs.next()){
                    ViewVerlengen vv = new ViewVerlengen(userID);
                }
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
