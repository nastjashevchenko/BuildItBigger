package com.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JokeTeller {
    private static final String DEFAULT_JOKE = "Your joke is: you have no connection!";
    private static final String JOKES_URL = "http://api.icndb.com/jokes/random";
    private static final String JSON_VALUE = "value";
    private static final String JSON_JOKE = "joke";

    public String getJoke() {
        String joke = DEFAULT_JOKE;

        URL url = null;
        String jsonData = null;
        try {
            url = new URL(JOKES_URL);
            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() != 200) {
                throw new IOException(conn.getResponseMessage());
            }
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();

            conn.disconnect();
            jsonData = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jsonData != null) {
            joke = new JSONObject(jsonData).getJSONObject(JSON_VALUE).getString(JSON_JOKE);
        }
        return joke;
    }
}
