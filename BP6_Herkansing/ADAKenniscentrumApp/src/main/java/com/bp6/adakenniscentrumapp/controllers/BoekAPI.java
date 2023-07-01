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

        // Controleer of er een succesvolle verbinding is gemaakt
        int responseCode = conn.getResponseCode();

        // Checkt of dat de response code van de HTTP gelijk is aan 200(succescode)
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            // nieuwe BufferedReader om de inputstream van de URL-verbinding te lezen
            BufferedReader jsonString = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

            // Haalt de JSON-array met de key "items" op uit het 'obj' JSONObject en slaat het op in een JSONArray genaamd 'arr'
            JSONParser jsonParser = new JSONParser();
            // Haalt het eerste object uit de 'arr' JSONArray en slaat het op in 'boek'
            JSONObject obj = (JSONObject) jsonParser.parse(jsonString);
            JSONArray arr = (JSONArray) obj.get("items");
            JSONObject boek = (JSONObject) arr.get(0);

            // Haalt de "volumeInfo" JSONObject, "authors" JSONArray en "imageLinks" JSONObject op uit het 'boek' JSONObject en slaat ze op in respectievelijk 'volume', 'author' en 'img'.
            JSONObject volume = (JSONObject) boek.get("volumeInfo");
            JSONArray author = (JSONArray) volume.get("authors");
            JSONObject img = (JSONObject) volume.get("imageLinks");

            // Haalt alle waardes op d.m.v. de keys en slaat deze op in hun eigen variabelen
            String sTitle = ((String) volume.get("title"));
            String sAuthor = ((String) author.get(0));
            String desc = ((String) volume.get("description"));
            Long lIsbn = (Long.parseLong(isbn));
            String sImg = ((String) img.get("thumbnail"));

            NieuwBoek bk = new NieuwBoek(sAuthor, sTitle, desc, lIsbn, sImg);
            ba.saveNieuwBoek(bk);
            System.out.println("Boek opgeslagen");

            // Alle boekgegevens opslaan in een nieuw object
            ViewNieuwBoek vnb = new ViewNieuwBoek(bk);

        }

    }

}
