package com.example.toetsjava2;

public class Touringcar extends Voertuig{

    public int aantPass;
    private static int minPass = 6;

    public Touringcar(String datum, String tijd, String startpunt, String eindbest, String bouwjaar, String brandstof, String kenteken, String merk, double prijskm, String status, int aantPass) {
        super(datum, tijd, startpunt, eindbest, bouwjaar, brandstof, kenteken, merk, prijskm, status);
        this.aantPass = aantPass;
    }

    public int getAantPass() {
        return aantPass;
    }

    public void setAantPass(int aantPass) {
        this.aantPass = aantPass;
    }

    public int getMinPass() {
        return minPass;
    }

}
