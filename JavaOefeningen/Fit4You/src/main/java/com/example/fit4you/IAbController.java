package com.example.fit4you;

import java.util.ArrayList;

public interface IAbController {

    //welke methodes heb je nodig. Prijs berekening, data ophalen etc
    //Alle functionaliteiten kan je hier vermelden

    public void opslaanAb(Object o);
    public ArrayList<Object> geefLijst();
    public double geefTotaalPrijsInd();
    public double geefTotaalPrijsGez();
    public double geefTotaalPrijs();

}
