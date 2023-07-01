package com.example.toetsjava2;

public class Motor extends Voertuig{

    public Boolean zijspan;

    public Motor(String datum, String tijd, String startpunt, String eindbest, String bouwjaar, String brandstof, String kenteken, String merk, double prijskm, String status, Boolean zijspan) {
        super(datum, tijd, startpunt, eindbest, bouwjaar, brandstof, kenteken, merk, prijskm, status);
        this.zijspan = zijspan;
    }

    public Boolean getZijspan() {
        return zijspan;
    }

    public void setZijspan(Boolean zijspan) {
        this.zijspan = zijspan;
    }


}
