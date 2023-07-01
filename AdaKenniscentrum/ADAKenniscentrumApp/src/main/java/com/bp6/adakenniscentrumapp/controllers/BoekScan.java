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

        //Connectie maken met de db
        // Het laatste gescande tag wordt weer opgehaald en haalt daarmee de gegevens van het boek op
        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT Title FROM Book bk JOIN ScannedNFC nfc ON bk.NFC = nfc.NFCID WHERE nfc.NFCID = (SELECT NFCID FROM ScannedNFC ORDER BY Time DESC LIMIT 1);");
//                bookID = rs.getInt("BookID");
                if(rs.next()){
                    title = rs.getString("Title");
                }
//                author = rs.getString("Author");

//                Boek bk = new Boek(title);
//                ba.saveBoek(bk);
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
