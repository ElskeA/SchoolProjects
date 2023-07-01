package com.example.tentamenprog;

public class Reservering {
    private String Naam;
    private String Adres;
    private String Postcode;
    private String Woonplaats;
    private String Geboortedatum;
    private String EmailTelefoon;
    private String Merk;
    private String Soort;
    private String Type;
    private double Prijs;
    private String Uitleendatum;
    private String Retourdatum;

    public Reservering(String naam, String adres, String postcode, String woonplaats, String gebdatum, String emailtel, String merk, String soort, String type, double prijs, String uitleendat, String retourdat){
        this.Naam = naam;
        this.Adres = adres;
        this.Postcode = postcode;
        this.Woonplaats = woonplaats;
        this.Geboortedatum = gebdatum;
        this.EmailTelefoon = emailtel;
        this.Merk = merk;
        this.Soort = soort;
        this.Type = type;
        this.Prijs = prijs;
        this.Uitleendatum = uitleendat;
        this.Retourdatum = retourdat;

    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
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

    public String getGeboortedatum() {
        return Geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        Geboortedatum = geboortedatum;
    }

    public String getEmailTelefoon() {
        return EmailTelefoon;
    }

    public void setEmailTelefoon(String emailTelefoon) {
        EmailTelefoon = emailTelefoon;
    }

    public String getMerk() {
        return Merk;
    }

    public void setMerk(String merk) {
        Merk = merk;
    }

    public String getSoort() {
        return Soort;
    }

    public void setSoort(String soort) {
        Soort = soort;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getPrijs() {
        return Prijs;
    }

    public void setPrijs(double prijs) {
        Prijs = prijs;
    }

    public String getUitleendatum() {
        return Uitleendatum;
    }

    public void setUitleendatum(String uitleendatum) {
        Uitleendatum = uitleendatum;
    }

    public String getRetourdatum() {
        return Retourdatum;
    }

    public void setRetourdatum(String retourdatum) {
        Retourdatum = retourdatum;
    }
}
