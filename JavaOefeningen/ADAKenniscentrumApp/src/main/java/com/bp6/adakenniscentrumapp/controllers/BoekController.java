package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.models.NieuwBoek;
import com.bp6.adakenniscentrumapp.views.ViewAfronden;

import java.sql.*;

public class BoekController {

    private String title;
    private Long isbn;
    private String author;
    private String summary;
    private String img;
//    private int nfc;

    public void addBoek(NieuwBoek b){

        author = b.getAuthor();
        summary = b.getDescription();
        title = b.getTitle();
        isbn = b.getIsbn();
        img = b.getImgURL();

        Connection connection = null;
        try {
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println(author+summary+title+img);
                System.out.println("Connection established");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("insert into Book(BookID, Title, ISBN, Author, Summary, Added, NFC, CourseID, ImageURL) values (NULL, '"+title+"', "+isbn+", '"+author+"', '"+summary+"', curdate(), 2, 1, '"+img+"')");

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

        ViewAfronden va = new ViewAfronden(1);

    }

}
