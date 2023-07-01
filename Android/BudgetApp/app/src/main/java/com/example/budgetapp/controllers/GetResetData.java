package com.example.budgetapp.controllers;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.budgetapp.MainActivity;
import com.example.budgetapp.model.CategoryData;
import com.example.budgetapp.views.Home;
import com.example.budgetapp.views.SignUp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetResetData {

        private int UserID;
        private Context context;
        private double gt, pt, mt, ht, ot;

        public GetResetData(int userID, Context context, double gt, double pt, double mt, double ht, double ot) {
            this.UserID = userID;
            this.context = context;
            this.gt = gt;
            this.pt = pt;
            this.mt = mt;
            this.ht = ht;
            this.ot = ot;

            try {
                String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Budget/getResetData.php";

                RequestQueue queue = Volley.newRequestQueue(context);
                StringRequest request = new StringRequest
                        (Request.Method.POST, url, response -> {
                            try{
                                Map<String, Double> Results  = new HashMap<String, Double>();
                                ArrayList<String> category = new ArrayList<>(Arrays.asList("Groceries", "Hygiene", "Pets", "Medication", "Other"));
                                for (int i = 0; i < category.size(); i++) {
                                    JSONArray array = new JSONObject(response).getJSONArray("data");
                                    ArrayList<CategoryData> arrayData = new ArrayList<>();
                                    for (int a = 0; a < array.length(); a++) {
                                        JSONObject reset = array.getJSONObject(a);
                                        double cAmount = reset.getDouble(category.get(i));

                                        String cName = category.get(i);
                                        CategoryData cd = new CategoryData(cAmount, cName);
                                        arrayData.add(cd);
                                    }
                                        //Per categorie wordt de expmovingaverage uitgerekend en in de hashmap Results gestopt
                                        if(i == 0) {
                                            Results.put(category.get(i), new ExpMovingAverage(arrayData, gt).Difference());
                                        }if(i == 1){
                                            Results.put(category.get(i), new ExpMovingAverage(arrayData, ht).Difference());
                                        }if(i == 2){
                                            Results.put(category.get(i), new ExpMovingAverage(arrayData, pt).Difference());
                                        }if(i == 3){
                                            Results.put(category.get(i), new ExpMovingAverage(arrayData, mt).Difference());
                                        }if(i == 4){
                                            Results.put(category.get(i), new ExpMovingAverage(arrayData, ot).Difference());
                                        }
                                }
                                Intent intent = new Intent(context, Home.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("UID", UserID);
                                intent.putExtra("Results", (Serializable)Results);
                                context.getApplicationContext().startActivity(intent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }, error -> Log.d("Error.Response", error.toString())){
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String, String> params = new HashMap<>();
                        params.put("UserID", String.valueOf(UserID));
                        return params;
                    }
                };
                request.setRetryPolicy(new DefaultRetryPolicy(5000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queue.add(request);
            }catch (Exception e){
                e.printStackTrace();
            }
        }



        }

