package com.example.tentamenprog;

import java.util.ArrayList;

public class ItemController {

    ArrayList<Items> lstItems = new ArrayList<>();

    public ItemController(){
        Items a1 = new Items("bc1234", "HP Zbook Power G7", "Laptop", "1J3Y2EA", 50);
        Items a2 = new Items("bc5678", "iPhone 12", "Telefoon", "64GB", 20);
        Items a3 = new Items("bc4321", "Logitech", "Webcam", "Brio ULTRA-HD PRO", 7.5);
        Items a4 = new Items("bc8765", "HP EliteDisplay", "Monitor", "E243m 24inch", 15);
        Items a5 = new Items("bc9999", "Rode", "Microfoon", "NT-USB", 12);

        lstItems.add(a1);
        lstItems.add(a2);
        lstItems.add(a3);
        lstItems.add(a4);
        lstItems.add(a5);

    }

    public ArrayList<Items> geefItems(String soort){
        ArrayList lijst = new ArrayList();
        for(Object i : lstItems){
            if( ((Items)i).getSoort() == soort){
                lijst.add(i);
            }
        }
        return lijst;
    }

}
