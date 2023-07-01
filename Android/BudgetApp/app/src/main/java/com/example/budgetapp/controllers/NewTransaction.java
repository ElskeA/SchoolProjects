package com.example.budgetapp.controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.budgetapp.views.SignUp;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class NewTransaction {

    private double trx;
    private int cat;
    private Context context;

    public NewTransaction(double trx, int cat, Context context) {
        this.trx = trx;
        this.cat = cat;
        this.context = context;

        String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Budget/Transaction.php";

        try {
            RequestQueue queue = Volley.newRequestQueue(context);

            StringRequest sq = new StringRequest(Request.Method.POST, url,
                    response -> Toast.makeText(context, "Succes", Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("CategoryID", String.valueOf(cat));
                    params.put("Amount", String.valueOf(trx));

                    return params;
                }
            };

            queue.add(sq);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Toast.makeText(context, "Transaction added", Toast.LENGTH_LONG).show();

        }
    }
}
