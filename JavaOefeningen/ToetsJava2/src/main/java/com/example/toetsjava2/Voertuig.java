package com.example.toetsjava2;

public class Voertuig extends Reservering{

    public String bouwjaar;
    public String brandstof;
    public String kenteken;
    public String merk;
    public double prijskm;
    public String status;

    public Voertuig(String datum, String tijd, String startpunt, String eindbest, String bouwjaar, String brandstof, String kenteken, String merk, double prijskm, String status) {
        super(datum, tijd, startpunt, eindbest);
        this.bouwjaar = bouwjaar;
        this.brandstof = brandstof;
        this.kenteken = kenteken;
        this.merk = merk;
        this.prijskm = prijskm;
        this.status = status;
    }

    public String getBouwjaar() {
        return bouwjaar;
    }

    public void setBouwjaar(String bouwjaar) {
        this.bouwjaar = bouwjaar;
    }

    public String getBrandstof() {
        return brandstof;
    }

    public void setBrandstof(String brandstof) {
        this.brandstof = brandstof;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public double getPrijskm() {
        return prijskm;
    }

    public void setPrijskm(double prijskm) {
        this.prijskm = prijskm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
