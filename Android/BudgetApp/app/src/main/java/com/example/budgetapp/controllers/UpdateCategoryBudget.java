package com.example.budgetapp.controllers;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateCategoryBudget {

    private int CategoryID;
    private double Budget;
    private Context context;

    public UpdateCategoryBudget(int categoryID, double budget, Context context) {
        this.CategoryID = categoryID;
        this.Budget = budget;
        this.context = context;

        String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Settings/updateCategoryBudget.php";

        try {
            RequestQueue queue = Volley.newRequestQueue(context);

            StringRequest sq = new StringRequest(Request.Method.POST, url,
                    response -> Toast.makeText(context, "Succes", Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("CategoryID", String.valueOf(categoryID));
                    params.put("Budget", String.valueOf(budget));

                    return params;
                }
            };

            queue.add(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

