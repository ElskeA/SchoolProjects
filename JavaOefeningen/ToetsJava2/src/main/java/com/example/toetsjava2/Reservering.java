package com.example.toetsjava2;

import java.util.Date;

public class Reservering {

    protected String datum;
    protected String tijd;
    protected String startpunt;
    protected String eindbest;

    public Reservering(String datum, String tijd, String startpunt, String eindbest) {
        this.datum = datum;
        this.tijd = tijd;
        this.startpunt = startpunt;
        this.eindbest = eindbest;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }

    public String getStartpunt() {
        return startpunt;
    }

    public void setStartpunt(String startpunt) {
        this.startpunt = startpunt;
    }

    public String getEindbest() {
        return eindbest;
    }

    public void setEindbest(String eindbest) {
        this.eindbest = eindbest;
    }
}
