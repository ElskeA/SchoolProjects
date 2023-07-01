package com.example.ptoetsher;

import java.util.Date;

public class Gegevens {
    private String NaamKlant;
    private String Adres;
    private String Postcode;
    private String Woonplaats;
    private String GebDatum;
    private String EmailEnTel;
    private String NaamSpel;
    private String Type;
    private String UitDatum;
    private String RetDatum;

    public Gegevens(String naamKlant, String adres, String postcode, String woonplaats, String gebDatum, String emailEnTel, String naamSpel, String type, String uitDatum, String retDatum) {
        this.NaamKlant = naamKlant;
        this.Adres = adres;
        this.Postcode = postcode;
        this.Woonplaats = woonplaats;
        this.GebDatum = gebDatum;
        this.EmailEnTel = emailEnTel;
        this.NaamSpel = naamSpel;
        this.Type = type;
        this.UitDatum = uitDatum;
        this.RetDatum = retDatum;
    }


    public String getNaamKlant() {
        return NaamKlant;
    }

    public void setNaamKlant(String naamKlant) {
        NaamKlant = naamKlant;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getWoonplaats() {
        return Woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        Woonplaats = woonplaats;
    }

    public String getGebDatum() {
        return GebDatum;
    }

    public void setGebDatum(String gebDatum) {
        GebDatum = gebDatum;
    }

    public String getEmailEnTel() {
        return EmailEnTel;
    }

    public void setEmailEnTel(String emailEnTel) {
        EmailEnTel = emailEnTel;
    }

    public String getNaamSpel() {
        return NaamSpel;
    }

    public void setNaamSpel(String naamSpel) {
        NaamSpel = naamSpel;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUitDatum() {
        return UitDatum;
    }

    public void setUitDatum(String uitDatum) {
        UitDatum = uitDatum;
    }

    public String getRetDatum() {
        return RetDatum;
    }

    public void setRetDatum(String retDatum) {
        RetDatum = retDatum;
    }

    @Override
    public String toString() {
        return NaamKlant + " | " +
                Adres + " | " +
                Postcode + " | " +
                Woonplaats + " | " +
                GebDatum + " | " +
                EmailEnTel + " | " +
                NaamSpel + " | " +
                Type + " | " +
                UitDatum + " | " +
                RetDatum + "\n";
    }
}


