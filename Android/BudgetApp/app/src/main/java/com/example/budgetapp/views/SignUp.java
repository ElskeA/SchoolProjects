package com.example.budgetapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.budgetapp.MainActivity;
import com.example.budgetapp.R;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    EditText etPass;
    EditText etBudget;
    Button btnSign;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPassword);
        etBudget = (EditText) findViewById(R.id.etBudget);
        btnSign = (Button) findViewById(R.id.btnSignup);
        btnCancel = (Button) findViewById(R.id.btnSignCancel);

        btnCancel.setOnClickListener(view -> {
            finish();
        });

        btnSign.setOnClickListener(view -> {
                    String username = etName.getText().toString();
                    String email = etEmail.getText().toString();
                    String password = etPass.getText().toString();
                    double budget = Double.parseDouble(etBudget.getText().toString());

                    String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/User/registerUser.php";

                    RequestQueue queue = Volley.newRequestQueue(SignUp.this);

                    if(!username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !Double.toString(budget).isEmpty()) {
                        try {

                            StringRequest sq = new StringRequest(Request.Method.POST, url,
                                    response -> Toast.makeText(SignUp.this, "Succes", Toast.LENGTH_LONG).show(),
                                    error -> Toast.makeText(SignUp.this, "Error", Toast.LENGTH_LONG).show()) {
                                @Override
                                protected Map<String, String> getParams() {
                                    Map<String, String> params = new HashMap<>();

                                    params.put("username", username);
                                    params.put("password", password);
                                    params.put("email", email);

                                    return params;
                                }
                            };
                            queue.add(sq);
                        } catch (Exception e) {
                            System.out.println("er is iets fout gegaan");
                        } finally {
                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Succes", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(SignUp.this, "Fill out all textfields", Toast.LENGTH_LONG).show();
                    }
                    });
    }
}

