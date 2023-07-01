package com.example.proeftoets_gameverhuur;

public class Reservering {
    private String Naam;
    private String Adres;
    private String Postcode;
    private String Woonplaats;
    private String GebDatum;
    private String EmailTel;

    private String Game;
    private String Console;
    private String UitleenDat;
    private String RetourDat;
    private double Prijs = 7.50;


    public Reservering(String naam, String adres, String postcode, String woonplaats, String gebdat, String emailtel,
                        String game, String console, String uitleendat, String retourdat){
        this.Naam = naam;
        this.Adres = adres;
        this.Postcode = postcode;
        this.Woonplaats = woonplaats;
        this.GebDatum = gebdat;
        this.EmailTel = emailtel;

        this.Game = game;
        this.Console = console;
        this.UitleenDat = uitleendat;
        this.RetourDat = retourdat;
    }

    public double getPrijs() {
        return Prijs;
    }

    public String getNaam() {
        return Naam;
    }

    public String getGame() {
        return Game;
    }

    public String getConsole() {
        return Console;
    }

    public String getUitleenDat() {
        return UitleenDat;
    }

    public String getRetourDat() {
        return RetourDat;
    }
}
