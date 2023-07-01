package com.example.budgetapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.budgetapp.MainActivity;
import com.example.budgetapp.R;
import com.example.budgetapp.controllers.DeleteTransaction;
import com.example.budgetapp.controllers.ExpMovingAverage;
import com.example.budgetapp.controllers.GetResetData;
import com.example.budgetapp.controllers.NewTransaction;
import com.example.budgetapp.controllers.ResetData;
import com.example.budgetapp.controllers.resetCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Home extends AppCompatActivity implements View.OnClickListener {

    DeleteTransaction   dt;
    NewTransaction      nt;
    resetCategory       rc;
    ResetData           rd;
    HashMap             resMap;
    GetResetData        reset;
    EditText            etTrans;
    Integer             activeUser;
    String              cat;
    double              gTotal, hTotal, pTotal, mTotal, oTotal, gSpent, hSpent, pSpent, mSpent, oSpent;
    double              gDiff, hDiff, pDiff, mDiff, oDiff;
    int                 gID, hID, mID, pID, oID;
    PopupWindow         cog, add, warning;
    TextView            tvName, GrocBudget, GrocLeft, HygBudget, HygLeft, PetBudget, PetLeft, MedBudget, MedLeft, OtherBudget, OtherLeft, txtTrans, txtWarning, titleWarning;
    Button              btnSettings, btnGroc, btnHyg, btnPet, btnMed, btnOther, btnReset, btnAdd, btnUndo, btnCancel, btnOkay;
    ProgressBar         prgGroceries, prgHygiene, prgPets, prgMeds, prgOther;

    DecimalFormat currency = new DecimalFormat("€###,###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvName = (TextView)findViewById(R.id.tvUsername);

        GrocBudget  = (TextView)findViewById(R.id.tvGroceries_budget);
        GrocLeft    = (TextView)findViewById(R.id.tvGroceries_left);
        HygBudget   = (TextView)findViewById(R.id.tvHygiene_budget);
        HygLeft     = (TextView)findViewById(R.id.tvHygiene_left);
        PetBudget   = (TextView)findViewById(R.id.tvPets_budget);
        PetLeft     = (TextView)findViewById(R.id.tvPets_Left);
        MedBudget   = (TextView)findViewById(R.id.tvMeds_budget);
        MedLeft     = (TextView)findViewById(R.id.tvMeds_left);
        OtherBudget = (TextView)findViewById(R.id.tvOther_budget);
        OtherLeft   = (TextView)findViewById(R.id.tvOther_Left);

        btnGroc     = (Button)findViewById(R.id.btnGroceries);
        btnHyg      = (Button)findViewById(R.id.btnHygiene);
        btnPet      = (Button)findViewById(R.id.btnPets);
        btnMed      = (Button)findViewById(R.id.btnMeds);
        btnOther    = (Button)findViewById(R.id.btnOther);
        btnReset    = (Button)findViewById(R.id.btnReset);
        btnUndo     = (Button)findViewById(R.id.btnUndo);

        prgGroceries = (ProgressBar)findViewById(R.id.progressGroceries);
        prgHygiene  = (ProgressBar)findViewById(R.id.progressHygiene);
        prgPets     = (ProgressBar)findViewById(R.id.progressPets);
        prgMeds     = (ProgressBar)findViewById(R.id.progressMeds);
        prgOther    = (ProgressBar)findViewById(R.id.progressOther);

        btnGroc.setOnClickListener(this);
        btnHyg.setOnClickListener(this);
        btnPet.setOnClickListener(this);
        btnMed.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnUndo.setOnClickListener(this);

        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSettings(view);
            }
        });

        Intent intent = getIntent();
        activeUser = intent.getIntExtra("UID", 0);

        //Handler wordt gebruikt om eerst te checken of de hashmap leeg is of niet. Als het niet leeg is dan moeten de popups aangemaakt worden
        // De delay zit hieraan om de app extra tijd te geven om de hashmap correct in te lezen anders crasht de hele applicatie
        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                resMap = (HashMap) intent.getSerializableExtra("Results");
                System.out.println("Dit is de map " + resMap);
                try{
                if(resMap.isEmpty()){
                    System.out.println("Hashmap is leeg");
                }else{
                    createPopup(resMap);
                    System.out.println("Hashmap is gevuld");
                }}catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }, 2000);


    if(activeUser != 0) {
        try {
            String url = "https://bp5.adainforma.tk/budgetapp/BP5/PHP/Budget/getCategoryData.php";
            System.out.println("Current user: " + activeUser);

            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest
                    (Request.Method.POST, url, response -> {
                        try{
                            JSONArray array = new JSONObject(response).getJSONArray("data");
                            for(int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                if (object.getInt("UserID") == activeUser) {
                                    double CategoryLeft = object.getDouble("CategoryLeft");
                                    double CategoryBudget = object.getDouble("CategoryBudget");
                                    String CategoryName = object.getString("CategoryName");
                                    int CategoryID = object.getInt("CategoryID");
                                    String Username = object.getString("Username");

                                    tvName.setText(Username);
                                    long round = Math.round((CategoryLeft / CategoryBudget) * 100);
                                    if(CategoryName.equals("Groceries")){
                                        GrocBudget.setText(currency.format(CategoryBudget));
                                        gID = CategoryID;
                                        gTotal = CategoryBudget;
                                        gSpent = CategoryLeft;
                                        GrocLeft.setText(currency.format(CategoryLeft)+" left");
                                        int percent = (int) round;
                                        ObjectAnimator.ofInt(prgGroceries, "progress", percent).setDuration(700).start();
                                    }
                                    if(CategoryName.equals("Hygiene")) {
                                        HygBudget.setText(currency.format(CategoryBudget));
                                        HygLeft.setText(currency.format(CategoryLeft)+" left");
                                        hID = CategoryID;
                                        hTotal = CategoryBudget;
                                        hSpent = CategoryLeft;
                                        int percent = (int) round;
                                        ObjectAnimator.ofInt(prgHygiene, "progress", percent).setDuration(700).start();
                                    }
                                    if(CategoryName.equals("Pets")) {
                                        PetBudget.setText(currency.format(CategoryBudget));
                                        PetLeft.setText(currency.format(CategoryLeft)+" left");
                                        pID = CategoryID;
                                        pTotal = CategoryBudget;
                                        pSpent = CategoryLeft;
                                        int percent = (int) round;
                                        ObjectAnimator.ofInt(prgPets, "progress", percent).setDuration(700).start();
                                    }
                                    if(CategoryName.equals("Medication")) {
                                        MedBudget.setText(currency.format(CategoryBudget));
                                        MedLeft.setText(currency.format(CategoryLeft)+" left");
                                        mID = CategoryID;
                                        mTotal = CategoryBudget;
                                        mSpent = CategoryLeft;
                                        int percent = (int) round;
                                        ObjectAnimator.ofInt(prgMeds, "progress", percent).setDuration(700).start();
                                    }
                                    if(CategoryName.equals("Other")) {
                                        OtherBudget.setText(currency.format(CategoryBudget));
                                        OtherLeft.setText(currency.format(CategoryLeft)+" left");
                                        oID = CategoryID;
                                        oTotal = CategoryBudget;
                                        oSpent = CategoryLeft;
                                        int percent = (int) round;
                                        ObjectAnimator.ofInt(prgOther, "progress", percent).setDuration(700).start();
                                    }
                                }else{
                                    System.out.println("Something went wrong");
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }, error -> Log.d("Error.Response", error.toString())){
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String, String> params = new HashMap<>();
                        params.put("UserID", String.valueOf(activeUser));
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
    }else{
        System.out.println("No active user");
    }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnGroceries) {
            showAdd(view, 1);
            System.out.println(gID);
        }
        if (view.getId() == R.id.btnHygiene) {
                showAdd(view, 2);
            }
        if (view.getId() == R.id.btnPets) {
                showAdd(view, 3);
        }
        if (view.getId() == R.id.btnMeds) {

                showAdd(view, 4);

        }
        if (view.getId() == R.id.btnOther) {

                showAdd(view, 5);

        }
        if (view.getId() == R.id.btnReset) {
            // ResetData staat uit omdat deze alle huidige transacties reset, wat niet handig is bij het testen
//            Handler hand = new Handler();
//            hand.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        double total = gTotal + pTotal + mTotal + hTotal + oTotal;
//                        rd = new ResetData(activeUser, gSpent, mSpent, pSpent, hSpent, oSpent, total, getApplicationContext());
//                    }catch (NullPointerException e){
//                        e.printStackTrace();
//                    }
//                }
//            }, 2000);


//            rc = new resetCategory(activeUser, getApplicationContext());

           reset = new GetResetData(activeUser, getApplicationContext(), gTotal, pTotal, mTotal, hTotal, oTotal);

        }
        if (view.getId() == R.id.btnUndo){
            undoTransaction(view);
        }

        }

        public void showAdd(View v, int id) {
            LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View popupView = layoutInflater.inflate(R.layout.transaction_window, null,false);

            Display display = getWindowManager().getDefaultDisplay();
            final Point size = new Point();
            display.getSize(size);

            add = new PopupWindow(popupView, 800, 600, true);
            add.setFocusable(true);
            add.setOutsideTouchable(true);
            add.showAtLocation(v, Gravity.CENTER, 0, 0);

            txtTrans    = (TextView) popupView.findViewById(R.id.titleWarning);
            etTrans     = (EditText) popupView.findViewById(R.id.txtWarning);
            btnAdd      = (Button) popupView.findViewById(R.id.btnOkay);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double d = Double.parseDouble(etTrans.getText().toString());
                    try {
                        nt = new NewTransaction(d, id, Home.this);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally{
                        add.dismiss();
                        recreate();
                    }
                }
          });
    }


    public void createPopup(HashMap map){
        View view = new View(getApplicationContext());
        double groceriesDiff = (double)map.get("Groceries");
        double hygieneDiff = (double)map.get("Hygiene");
        double petsDiff = (double)map.get("Pets");
        double medsDiff = (double)map.get("Medication");
        double otherDiff = (double)map.get("Other");

        //Meer spaghetti code om de popups aan de praat te krijgen
        //Hij checkt per categorie die in de hashmap staat hoe hoog het percentage is wat uit ExpMovingAvg komt
        //Op basis daarvan kiest hij de correcte popup and laat deze zien
        if (groceriesDiff > 45){
            String Groceries = "Groceries";
            showHighWarning(view, groceriesDiff, Groceries);
        }
        if (groceriesDiff >= 25 && groceriesDiff <= 45){
            String Groceries = "Groceries";
            showMidWarning(view, groceriesDiff, Groceries);
        }
        if (groceriesDiff >= 15 && groceriesDiff <= 25){
            String Groceries = "Groceries";
            showLowWarning(view, groceriesDiff, Groceries);
        }
        if (hygieneDiff > 45){
            String Hygiene = "Hygiene";
            showHighWarning(view, hygieneDiff, Hygiene);
        }
        if (hygieneDiff >= 25 && hygieneDiff <= 45){
            String Hygiene = "Hygiene";
            showMidWarning(view, hygieneDiff, Hygiene);
        }
        if (hygieneDiff >= 15 && hygieneDiff <= 25){
            String Hygiene = "Hygiene";
            showLowWarning(view, hygieneDiff, Hygiene);
        }
        if (petsDiff > 45){
            String Pets = "Pets";
            showHighWarning(view, petsDiff, Pets);
        }
        if (petsDiff >= 25 && petsDiff <= 45){
            String Pets = "Pets";
            showMidWarning(view, petsDiff, Pets);
        }
        if (petsDiff >= 15 && petsDiff <= 25){
            String Pets = "Pets";
            showLowWarning(view, petsDiff, Pets);
        }
        if (medsDiff > 45){
            String Medication = "Medication";
            showHighWarning(view, medsDiff, Medication);
        }
        if (medsDiff >= 25 && medsDiff <= 45){
            String Medication = "Medication";
            showMidWarning(view, medsDiff, Medication);
        }
        if (medsDiff >= 15 && medsDiff <= 25){
            String Medication = "Medication";
            showLowWarning(view, medsDiff, Medication);
        }
        if (otherDiff > 45){
            String Other = "Other";
            showHighWarning(view, otherDiff, Other);
        }
        if (otherDiff >= 25 && otherDiff <= 45){
            String Other = "Other";
            showMidWarning(view, otherDiff, Other);
        }
        if (otherDiff >= 15 && otherDiff <= 25){
            String Other = "Other";
            showLowWarning(view, otherDiff, Other);
        }

    }

    public void showLowWarning(View v, double d, String s) {
            LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View popupView = layoutInflater.inflate(R.layout.changepopup, null,false);

            Display display = getWindowManager().getDefaultDisplay();
            final Point size = new Point();
            display.getSize(size);

            warning = new PopupWindow(popupView, 1000, 1100, true);
            warning.setFocusable(true);
            warning.setOutsideTouchable(true);
            warning.showAtLocation(v, Gravity.CENTER, 0, 0);

            txtWarning    = (TextView) popupView.findViewById(R.id.txtWarning);
            titleWarning  = (TextView) popupView.findViewById(R.id.titleWarning);
            btnOkay     = (Button) popupView.findViewById(R.id.btnOkay);

            titleWarning.setText("Category: " + s);
            txtWarning.setText(R.string.textWarningLow);


        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warning.dismiss();
            }
        });
    }
    public void showMidWarning(View v, double d, String s) {
        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.changepopup, null,false);

        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        warning = new PopupWindow(popupView, 1000, 1100, true);
        warning.setFocusable(true);
        warning.setOutsideTouchable(true);
        warning.showAtLocation(v, Gravity.CENTER, 0, 0);

        txtWarning    = (TextView) popupView.findViewById(R.id.txtWarning);
        titleWarning  = (TextView) popupView.findViewById(R.id.titleWarning);
        btnOkay     = (Button) popupView.findViewById(R.id.btnOkay);

        titleWarning.setText("Category: " + s);
        txtWarning.setText(R.string.textWarningMid);


        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warning.dismiss();
            }
        });
    }
    public void showHighWarning(View v, double d, String s) {
        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.changepopup, null,false);

        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        warning = new PopupWindow(popupView, 1000, 1100, true);
        warning.setFocusable(true);
        warning.setOutsideTouchable(true);
        warning.showAtLocation(v, Gravity.CENTER, 0, 0);

        txtWarning    = (TextView) popupView.findViewById(R.id.txtWarning);
        titleWarning  = (TextView) popupView.findViewById(R.id.titleWarning);
        btnOkay     = (Button) popupView.findViewById(R.id.btnOkay);

        titleWarning.setText("Category: " + s);
        txtWarning.setText(R.string.textWarningHigh);

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warning.dismiss();
            }
        });
    }


    public void undoTransaction(View view) {
        try {
            dt = new DeleteTransaction(activeUser, getApplicationContext());;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            recreate();
        }
    }

    public void showSettings(View v) {
        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.cogmenu_layout, null,false);
        cog = new PopupWindow(popupView, 400, 200, true);
        cog.setFocusable(true);
        cog.setOutsideTouchable(true);
        cog.showAtLocation(v, Gravity.NO_GRAVITY, 600, 150);

        TextView btnSet;
        TextView btnLogout;
        btnSet = (TextView) popupView.findViewById(R.id.btnSet);
        btnLogout = (TextView) popupView.findViewById(R.id.btnLogout);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Settings.class);
                intent.putExtra("UID", activeUser);
                startActivity(intent);
                cog.dismiss();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
