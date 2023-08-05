package com.example.bp2randomizer.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ACAPI {
    private static final String BASE_URL = "http://acnhapi.com/v1/villagers/";

    public static String getVillagerInfo(String villagerID) throws IOException, MalformedURLException {
        String urlString = BASE_URL + villagerID;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            return response.toString();
        } else {
            throw new IOException("API request failed with response code: " + responseCode);
        }
    }
}

