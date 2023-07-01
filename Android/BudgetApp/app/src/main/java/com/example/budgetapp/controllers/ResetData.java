package com.example.budgetapp.controllers;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ResetData {

        private int UserID;
        private double groc;
        private double med;
        private double pet;
        private double hyg;
        private double other;
        private double total;
        private Context context;

    public ResetData(int userID, double groc, double med,
                     double pet, double hyg, double other,
                     double total, Context context) {
        this.UserID = userID;
        this.groc = groc;
        this.med = med;
        this.pet = pet;
        this.hyg = hyg;
        this.other = other;
        this.total = total;
        this.context = context;

        //In de database is een tabel voor Overunder, deze houdt bij of bij de reset het totaalbudget boven of onder het budget uit komt
        //Door dit bij te houden wordt er straks gebruik van gemaakt bij de gamification
        String Overunder;
            if((groc+med+pet+hyg+other) <= total){
                Overunder = "Under";
                System.out.println(Overunder);
            }else{
                Overunder = "Over";
                System.out.println(Overunder);
            }


        String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Budget/setReset.php";

        try {
            RequestQueue queue = Volley.newRequestQueue(context);

            StringRequest sq = new StringRequest(Request.Method.POST, url,
                    response -> Toast.makeText(context, "Succes", Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("UserID", String.valueOf(UserID));
                    params.put("Groc", String.valueOf(groc));
                    params.put("Hyg", String.valueOf(hyg));
                    params.put("Med", String.valueOf(med));
                    params.put("Pet", String.valueOf(pet));
                    params.put("Other", String.valueOf(other));
                    params.put("Total", String.valueOf(total));
                    params.put("OverUnder", Overunder);

                    return params;
                }
            };

            queue.add(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
