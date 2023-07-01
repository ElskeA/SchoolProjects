package com.example.fit4you;

import java.util.ArrayList;

public class AbController implements IAbController {

    //lijst declareren
    private ArrayList<Object> lijst;

    public AbController(){
        lijst = new ArrayList<>();
    }

    @Override
    public void opslaanAb(Object o) {
        lijst.add(o);
    }

    @Override
    public ArrayList<Object> geefLijst() {
        return lijst;
    }

    @Override
    public double geefTotaalPrijsInd() {
        double totaalprijs = 0.00;
        //forlus elk object moet type object zijn van individueel. Dubbele punt: waar haal je data uit - Dus lijst
        for(Object e: lijst)
        {
            if (e instanceof Individueel) {
                totaalprijs += Individueel.prijs;
            }
        }
        return totaalprijs;
    }

    @Override
    public double geefTotaalPrijsGez() {
        double totaalprijs = 0.00;

        for(Object e: lijst)
        {
            if (e instanceof Gezin) {
                totaalprijs += Gezin.prijs;
            }
        }
        return totaalprijs;
    }

    @Override
    public double geefTotaalPrijs() {
        double totaalprijs = 0.00;
        for(Object e: lijst)
        {
            if (e instanceof Individueel) {
                totaalprijs += Individueel.prijs;
            }else if(e instanceof Gezin){
                totaalprijs += Gezin.prijs;
            }
        }
        return totaalprijs;
    }
}


