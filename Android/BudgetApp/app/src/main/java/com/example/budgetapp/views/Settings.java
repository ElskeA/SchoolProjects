package com.example.budgetapp.views;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.budgetapp.R;
import com.example.budgetapp.controllers.UpdateCategoryBudget;
import com.example.budgetapp.controllers.UpdatePersonal;
import com.example.budgetapp.controllers.UpdateTotalBudget;
import com.example.budgetapp.model.CategoryData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    UpdatePersonal          up;
    UpdateCategoryBudget    uc;
    UpdateTotalBudget       tb;
    CategoryData            cd;
    Button                  btnBack, btnPers, btnBudget, btnSave;
    EditText                txtName, txtEmail, txtPassword, txtBudget,
                            grocBudget, hygBudget, petBudget, medBudget, otherBudget;
    Integer                 activeUser;
    String                  uname, pword, email;

    DecimalFormat currency = new DecimalFormat("###,###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnBack     = (Button) findViewById(R.id.btnBack);
        btnPers     = (Button) findViewById(R.id.btnPers);
        btnBudget   = (Button) findViewById(R.id.btnBudget);
        btnSave     = (Button) findViewById(R.id.btnSave);

        txtName     = (EditText) findViewById(R.id.txtName);
        txtEmail    = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        txtBudget   = (EditText) findViewById(R.id.txtBudget);

        grocBudget  = (EditText) findViewById(R.id.etGroc);
        hygBudget   = (EditText) findViewById(R.id.etHyg);
        petBudget   = (EditText) findViewById(R.id.etPets);
        medBudget   = (EditText) findViewById(R.id.etMeds);
        otherBudget = (EditText) findViewById(R.id.etOther);

        btnBack.setOnClickListener(this);
        btnPers.setOnClickListener(this);
        btnBudget.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        Intent intent = getIntent();
        activeUser = intent.getIntExtra("UID", 0);

        if (activeUser != 0) {
            try {
                String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Settings/getCategoryBudget.php";
                RequestQueue q = Volley.newRequestQueue(this);
                StringRequest request = new StringRequest
                        (Request.Method.POST, url, response -> {
                            try {
                                JSONArray array = new JSONObject(response).getJSONArray("data");
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject ob = array.getJSONObject(i);
                                    String Budget = currency.format(ob.getDouble("Budget"));
                                    String Name = ob.getString("Name");
                                    if (Name.equals("Groceries")) {
                                        grocBudget.setText(Budget);
                                    }
                                    if (Name.equals("Hygiene")) {
                                        hygBudget.setText(Budget);
                                    }
                                    if (Name.equals("Pets")) {
                                        petBudget.setText(Budget);
                                    }
                                    if (Name.equals("Medication")) {
                                        medBudget.setText(Budget);
                                    }
                                    if (Name.equals("Other")) {
                                        otherBudget.setText(Budget);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }, error -> Log.d("Error.Response", error.toString())) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("UserID", String.valueOf(activeUser));
                        return params;
                    }
                };
                request.setRetryPolicy(new DefaultRetryPolicy(5000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                q.add(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Settings/getUserInfo.php";
                RequestQueue q = Volley.newRequestQueue(this);
                StringRequest request = new StringRequest
                        (Request.Method.POST, url, response -> {
                            try {
                                JSONArray array = new JSONObject(response).getJSONArray("data");
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject usr = array.getJSONObject(i);
                                    uname = usr.getString("Username");
                                    pword = usr.getString("Password");
                                    email = usr.getString("Email");

                                    txtName.setText(uname);
                                    txtEmail.setText(email);
                                    txtPassword.setText(pword);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }, error -> Log.d("Error.Response", error.toString())) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("UserID", String.valueOf(activeUser));
                        return params;
                    }
                };
                request.setRetryPolicy(new DefaultRetryPolicy(5000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                q.add(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Settings/getTotalBudget.php";
                RequestQueue q = Volley.newRequestQueue(this);
                StringRequest request = new StringRequest
                        (Request.Method.POST, url, response -> {
                            try {
                                JSONArray array = new JSONObject(response).getJSONArray("data");
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject bud = array.getJSONObject(i);

                                    txtBudget.setText(currency.format(bud.getDouble("Amount")));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }, error -> Log.d("Error.Response", error.toString())) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("UserID", String.valueOf(activeUser));
                        return params;
                    }
                };
                request.setRetryPolicy(new DefaultRetryPolicy(5000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                q.add(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPers) {
            try {
                up = new UpdatePersonal(activeUser, txtName.getText().toString(), txtEmail.getText().toString(),
                        txtPassword.getText().toString(), getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (view.getId() == R.id.btnBudget) {
            try {
                tb = new UpdateTotalBudget(1, Double.parseDouble(txtBudget.getText().toString()), getApplicationContext());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (view.getId() == R.id.btnSave) {
            uc = new UpdateCategoryBudget(1, Double.parseDouble(grocBudget.getText().toString()), getApplicationContext());
            uc = new UpdateCategoryBudget(2, Double.parseDouble(hygBudget.getText().toString()), getApplicationContext());
            uc = new UpdateCategoryBudget(3, Double.parseDouble(petBudget.getText().toString()), getApplicationContext());
            uc = new UpdateCategoryBudget(4, Double.parseDouble(medBudget.getText().toString()), getApplicationContext());
            uc = new UpdateCategoryBudget(5, Double.parseDouble(otherBudget.getText().toString()), getApplicationContext());
        }
        if (view.getId() == R.id.btnBack) {
            finish();
        }
    }
    }
