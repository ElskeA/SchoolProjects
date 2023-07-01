package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.views.ViewDocent;
import com.bp6.adakenniscentrumapp.views.ViewStudent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InlogController {
    private int roleID;
    private int userID;
    public InlogController(){

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT Firstname, UserID, RoleID FROM Users usr JOIN ScannedNFC nfc ON usr.NFC = nfc.NFCID WHERE nfc.NFCID = (SELECT NFCID FROM ScannedNFC ORDER BY Time DESC LIMIT 1);");
                if (rs.next()) {
                    userID = rs.getInt("UserID");
                    roleID = rs.getInt("RoleID");
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

        if (roleID == 1){
            ViewStudent vs = new ViewStudent(userID);
        }
        if(roleID == 2 || roleID == 3){
            ViewDocent vd = new ViewDocent(userID);
        }

    }

}


