package com.bp6.adakenniscentrumapp.controllers;

import com.bp6.adakenniscentrumapp.models.NieuwBoek;
import com.bp6.adakenniscentrumapp.views.ViewNieuwBoek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BoekAPI {

    NieuwBoekArray ba = new NieuwBoekArray();
    public BoekAPI(String isbn) throws IOException, ParseException {

        URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:"+isbn);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try {
            conn.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Check if connect is made
        int responseCode = conn.getResponseCode();

        // 200 OK
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {

            BufferedReader jsonString = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

            JSONParser jsonParser = new JSONParser();
            JSONObject obj = (JSONObject) jsonParser.parse(jsonString);
            JSONArray arr = (JSONArray) obj.get("items");
            JSONObject boek = (JSONObject) arr.get(0);

            JSONObject volume = (JSONObject) boek.get("volumeInfo");
            JSONArray author = (JSONArray) volume.get("authors");
            JSONObject img = (JSONObject) volume.get("imageLinks");

            String sTitle = ((String) volume.get("title"));
            String sAuthor = ((String) author.get(0));
            String desc = ((String) volume.get("description"));
            Long lIsbn = (Long.parseLong(isbn));
            String sImg = ((String) img.get("thumbnail"));

            NieuwBoek bk = new NieuwBoek(sAuthor, sTitle, desc, lIsbn, sImg);
            ba.saveNieuwBoek(bk);
            System.out.println("Boek opgeslagen");

            ViewNieuwBoek vnb = new ViewNieuwBoek(bk);

        }

    }

}
