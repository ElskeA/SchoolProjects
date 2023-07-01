package com.example.fit4you;

public class Abbonement {

    //protected gebruiken op toets ipv private
    //Protected String voornaam, achternaam, adres, postcode, woonplaats;
    private String voornaam;
    private String achternaam;
    private String adres;
    private String postcode;
    private String woonplaats;

    //constructor generaten
    public Abbonement(String voornaam, String achternaam, String adres,
                      String postcode, String woonplaats)
    {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}
