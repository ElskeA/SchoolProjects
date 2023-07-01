package com.example.tentamenprog;

import java.util.ArrayList;

public class Items {
    private String Barcode;
    private String Merk;
    private String Soort;
    private String Type;
    private double Prijs;

    public Items(String barcode, String merk, String soort, String type, double prijs){
        this.Barcode = barcode;
        this.Merk = merk;
        this.Soort = soort;
        this.Type = type;
        this.Prijs = prijs;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
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

}
