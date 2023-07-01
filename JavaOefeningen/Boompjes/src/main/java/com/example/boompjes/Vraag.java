package com.example.boompjes;

public class Vraag {

    private String deVraag;
    private String antw[];

    public Vraag(String deVraag, String[] antw) {
        this.deVraag = deVraag;
        this.antw = antw;
    }

    public String getDeVraag() {
        return deVraag;
    }

    public void setDeVraag(String deVraag) {
        this.deVraag = deVraag;
    }

    public String[] getAntw() {
        return antw;
    }

    public void setAntw(String[] antw) {
        this.antw = antw;
    }
}
