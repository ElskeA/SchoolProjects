package com.example.toetsjava2;

public class Auto extends Voertuig{

    public String soortAuto;

    public Auto(String datum, String tijd, String startpunt, String eindbest, String bouwjaar, String brandstof, String kenteken, String merk, double prijskm, String status, String soortAuto) {
        super(datum, tijd, startpunt, eindbest, bouwjaar, brandstof, kenteken, merk, prijskm, status);
        this.soortAuto = soortAuto;
    }

    public String getSoortAuto() {
        return soortAuto;
    }

    public void setSoortAuto(String soortAuto) {
        this.soortAuto = soortAuto;
    }

}
