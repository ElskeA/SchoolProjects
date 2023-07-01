package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.models.Boek;
import com.bp6.adakenniscentrumapp.models.NieuwBoek;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoekScan {

    BoekArray ba = new BoekArray();
    private String title;
    private int bookID;
    private String author;

    public BoekScan() {

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT BookID, Title, Author FROM Book bk JOIN ScannedNFC nfc ON bk.NFC WHERE NFCID = (SELECT NFCID FROM ScannedNFC ORDER BY NFCID DESC LIMIT 1);)");
                bookID = rs.getInt("BookID");
                title = rs.getString("Title");
                author = rs.getString("Author");

                Boek bk = new Boek(bookID, title, author);
                ba.saveBoek(bk);
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
