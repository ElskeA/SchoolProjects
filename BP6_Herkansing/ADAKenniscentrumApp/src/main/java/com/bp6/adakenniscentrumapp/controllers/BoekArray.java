package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.models.Boek;


import java.util.ArrayList;

public class BoekArray {

    private ArrayList<Boek> lstBoeken;

    public BoekArray(){
        lstBoeken = new ArrayList<>();
    }

    void saveBoek(Boek b){
        lstBoeken.add(b);
    }

    public ArrayList<Boek> geefBoek(){
        return lstBoeken;
    }

}
