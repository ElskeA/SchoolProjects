package com.example.proeftoets_gameverhuur;

import java.util.ArrayList;

public class ResController {

    ArrayList<Reservering> lstOverzicht = new ArrayList<>();

    public ResController(){
        lstOverzicht.add(new Reservering("Elske", "Ulvenhoutselaan 123", "4834ME", "Breda", "05-11-1991", "e@gmail.com", "Zelda", "Nintendo Switch", "25-02-2022", "04-03-2022"));
        lstOverzicht.add(new Reservering("Mien", "Koek 5", "2392KE", "Roosendaal", "10-09-1995", "mien@gmail.com", "Horizon Zero Dawn", "PS4", "04-03-2022", "04-03-2022"));
        lstOverzicht.add(new Reservering("Piet", "Schijt 6", "2394DA", "Middelburg", "24-03-1998", "piet@gmail.com", "Animal Crossing", "Nintendo Switch", "02-03-2022", "09-03-2022"));
    }

    public void opslaanReservering(Reservering res){
        lstOverzicht.add(res);
    }

    public ArrayList geefOverzicht(){
        return lstOverzicht;
    }

    public double geefTotaal(){
        double totaal = 0;
        for(Object res : lstOverzicht){
            double prijs = ((Reservering)res).getPrijs();
            totaal += prijs;
        }
        return totaal;
    }
}
