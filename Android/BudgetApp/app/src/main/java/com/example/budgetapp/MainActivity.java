package com.example.budgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.budgetapp.controllers.ExpMovingAverage;
import com.example.budgetapp.model.CategoryData;
import com.example.budgetapp.views.Home;
import com.example.budgetapp.views.SignUp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText    Username, Password;
    ExpMovingAverage ca;
    String      uname, pword;
    Button      btnLogin, btnSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSign     = (Button) findViewById(R.id.btnSign);
        btnLogin    = (Button) findViewById(R.id.btnLogin);
        Username    = (EditText) findViewById(R.id.tfUsername);
        Password    = (EditText) findViewById(R.id.tfPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = String.valueOf(Username.getText());
                pword = String.valueOf(Password.getText());

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/User/loginUser.php";

                    StringRequest sq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray array = new JSONObject(response).getJSONArray("data");
                                for(int i = 0; i < array.length(); i++){
                                    JSONObject result = array.getJSONObject(i);
                                    if(result.getString("Username").equals(uname) && result.getString("Password").equals(pword)){
                                        int uID = result.getInt("UserID");

                                        Intent intent = new Intent(MainActivity.this, Home.class);
                                        intent.putExtra("UID", uID);
                                        startActivity(intent);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.toString());
                        }
                    });
                    sq.setRetryPolicy(new DefaultRetryPolicy(5000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    queue.add(sq);
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
}





