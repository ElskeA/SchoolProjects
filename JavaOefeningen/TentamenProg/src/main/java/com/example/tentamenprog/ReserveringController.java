package com.example.tentamenprog;

import java.util.ArrayList;

public class ReserveringController {

    ArrayList<Reservering> lstReserv = new ArrayList<>();
    ArrayList<Items> lstItem = new ArrayList<>();

    public void opslaanReservering(Reservering res){
        lstReserv.add(res);
    }

    public ArrayList geefReserveringen() { return lstReserv; }

}
