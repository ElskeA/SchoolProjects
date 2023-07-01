package com.example.budgetapp.controllers;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateTotalBudget {

    private int budgetID;
    private double amount;
    private Context context;

    public UpdateTotalBudget(int budgetID, double amount, Context context) {
        this.budgetID = budgetID;
        this.amount = amount;
        this.context = context;

        String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Settings/updateTotalBudget.php";

        try {
            RequestQueue queue = Volley.newRequestQueue(context);

            StringRequest sq = new StringRequest(Request.Method.POST, url,
                    response -> Toast.makeText(context, "Succes", Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("BudgetID", String.valueOf(budgetID));
                    params.put("Amount", String.valueOf(amount));

                    return params;
                }
            };

            queue.add(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    }

