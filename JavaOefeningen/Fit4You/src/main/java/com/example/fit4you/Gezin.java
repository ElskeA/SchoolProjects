package com.example.fit4you;

public class Gezin extends Abbonement{

    public static double prijs = 35;
    private String famNaam;
    private int aantalVol;
    private int aantalKind;

    public Gezin(String voornaam, String achternaam, String adres,
                  String postcode, String woonplaats, String famNaam, int aantalVol, int aantalKind){
        super(voornaam, achternaam, adres, postcode, woonplaats);
        this.famNaam = famNaam;
        this.aantalVol = aantalVol;
        this.aantalKind = aantalKind;
    }

    public static double getPrijs() {
        return prijs;
    }

    public static void setPrijs(double prijs) {
        Gezin.prijs = prijs;
    }

    public String getFamNaam() {
        return famNaam;
    }

    public void setFamNaam(String famNaam) {
        this.famNaam = famNaam;
    }

    public int getAantalVol() {
        return aantalVol;
    }

    public void setAantalVol(int aantalVol) {
        this.aantalVol = aantalVol;
    }

    public int getAantalKind() {
        return aantalKind;
    }

    public void setAantalKind(int aantalKind) {
        this.aantalKind = aantalKind;
    }
}
