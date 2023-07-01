package com.bp6.adakenniscentrumapp.models;

public class NieuwBoek {

    private String author;
    private String title;
    private String description;
    private Long isbn;
    private String imgURL;


    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NieuwBoek(String author, String title, String description, Long isbn, String imgURL) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.imgURL = imgURL;
    }

}
