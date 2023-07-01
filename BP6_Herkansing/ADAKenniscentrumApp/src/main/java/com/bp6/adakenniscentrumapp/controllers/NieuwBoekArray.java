package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.models.NieuwBoek;

import java.util.ArrayList;

public class NieuwBoekArray {

    private final ArrayList<NieuwBoek> lstBoeken;

    public NieuwBoekArray(){
        lstBoeken = new ArrayList<>();
    }

    void saveNieuwBoek(NieuwBoek b){
        lstBoeken.add(b);
    }

    ArrayList<NieuwBoek> geefBoek(){
        return lstBoeken;
    }
}
