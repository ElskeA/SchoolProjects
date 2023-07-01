package com.example.progtoets;

public class RecreatieTicket {
    private String Soort;
    private String Barcode;
    private String Datum;
    private String Tijd;
    private String Postcode;
    private String Woonplaats;

    private double Prijs = 3.75;

    public RecreatieTicket(String soort, String barcode, String datum, String tijd, String postcode, String woonplaats){
        this.Soort = soort;
        this.Barcode = barcode;
        this.Datum = datum;
        this.Tijd = tijd;
        this.Postcode = postcode;
        this.Woonplaats = woonplaats;
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

    public double getPrijs() {
        return Prijs;
    }

    public String getSoort() {
        return Soort;
    }

    public void setSoort(String soort) {
        Soort = soort;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public String getTijd() {
        return Tijd;
    }

    public void setTijd(String tijd) {
        Tijd = tijd;
    }
}
