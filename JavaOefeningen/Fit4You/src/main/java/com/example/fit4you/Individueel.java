package com.example.fit4you;

import java.time.LocalDate;
import java.util.Date;

//extends is de overerving
//create constructor matching super
public class Individueel extends Abbonement {

    private LocalDate gebDatum;
    public static double prijs = 20;

    public Individueel(String voornaam, String achternaam, String adres,
                       String postcode, String woonplaats, LocalDate gebDatum){
        super(voornaam, achternaam, adres, postcode, woonplaats);
        this.gebDatum = gebDatum;
    }

    public static double getPrijs() {
        return prijs;
    }

    public static void setPrijs(double prijs) {
        Individueel.prijs = prijs;
    }

    public LocalDate getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(LocalDate gebDatum) {
        this.gebDatum = gebDatum;
    }
}
