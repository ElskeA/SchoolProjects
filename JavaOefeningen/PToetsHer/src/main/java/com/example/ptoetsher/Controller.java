package com.example.ptoetsher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Controller {

    ArrayList<Gegevens> lstGegevens = new ArrayList();


    public Controller (){
       lstGegevens.add(new Gegevens("Viktor",
               "Pietstraat 16",
               "4921 KD",
               "Breda",
               "24/03/1990",
               "viktorpietstraaat@homal.com",
               "Mario",
               "PC",
               "07/03/2022",
               "14/03/2022"));
//        lstGegevens.add(new Gegevens())
   }

    public void opslaanGegevens(Gegevens gev){
        lstGegevens.add(gev);
        System.out.println(lstGegevens);
    }
    public ArrayList geefGegevens(){
        return lstGegevens;
    }

    public ArrayList<Gegevens> getLstGegevens() {
        System.out.println(lstGegevens);
        return lstGegevens;
    }


}
