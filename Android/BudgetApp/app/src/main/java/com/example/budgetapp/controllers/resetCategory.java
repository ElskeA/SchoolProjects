package com.example.budgetapp.controllers;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class resetCategory {

     private int UserID;
     private Context context;

    public resetCategory(int userID, Context context) {
        UserID = userID;
        this.context = context;

        String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Budget/resetCategory.php";

        try {
            RequestQueue queue = Volley.newRequestQueue(context);

            StringRequest sq = new StringRequest(Request.Method.POST, url,
                    response -> Toast.makeText(context, "Succes", Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("UserID", String.valueOf(UserID));

                    return params;
                }
            };

            queue.add(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
