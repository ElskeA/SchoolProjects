package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.models.NieuwBoek;
import com.bp6.adakenniscentrumapp.views.ViewAfronden;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BoekController {

    private String title;
    private Long isbn;
    private String author;
    private String summary;
    private String img;
//    private int nfc;

    public void addBoek(NieuwBoek b){

        //Om een nieuw boek toe te voegen worden alle strings opgehaald uit NieuwBoek
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
                String sql = "INSERT INTO Book(BookID, Title, ISBN, Author, Summary, Added, NFC, CourseID, ImageURL) VALUES (NULL, ?, ?, ?, ?, curdate(), 2, 1, ?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                // Alle strings worden doorgezet aan de statement, zodat het met de query in de database gezet kan worden
                stmt.setString(1, title);
                stmt.setLong(2, isbn);
                stmt.setString(3, author);
                stmt.setString(4, summary);
                stmt.setString(5, img);
                stmt.executeUpdate();
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
