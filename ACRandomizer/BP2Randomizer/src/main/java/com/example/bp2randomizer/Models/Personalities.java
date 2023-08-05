package com.example.bp2randomizer.Models;

import java.util.ArrayList;
import java.util.List;

public class Personalities {

    List<String> lstPerson = new ArrayList<>();

    public Personalities(){

        lstPerson.add("Normal");
        lstPerson.add("Peppy");
        lstPerson.add("Snooty");
        lstPerson.add("Lazy");
        lstPerson.add("Jock");
        lstPerson.add("Cranky");
        lstPerson.add("Smug");
        lstPerson.add("Sisterly");

    }

    public List geefList(){
        return lstPerson;
    }

}

