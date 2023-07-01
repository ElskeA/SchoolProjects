package com.example.bp2randomizer.Models;

import java.util.ArrayList;
import java.util.List;

public class Personalities {

    public Personalities(){

        List<String> lstPerson = new ArrayList<>();

        lstPerson.add("normal");
        lstPerson.add("peppy");
        lstPerson.add("snooty");
        lstPerson.add("lazy");
        lstPerson.add("jock");
        lstPerson.add("cranky");
        lstPerson.add("smug");

        System.out.println(lstPerson);
    }

}
