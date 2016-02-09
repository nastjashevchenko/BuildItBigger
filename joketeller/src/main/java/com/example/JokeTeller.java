package com.example;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JokeTeller {
    OkHttpClient client = new OkHttpClient();
    private static final String DEFAULT_JOKE = "Your joke is: you have no connection!";
    private static final String JOKES_URL = "http://api.icndb.com/jokes/random";
    private static final String JSON_VALUE = "value";
    private static final String JSON_JOKE = "joke";

    public String getJoke() {
        String joke = DEFAULT_JOKE;

        Request request = new Request.Builder()
                .url(JOKES_URL)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonData = null;
        if (response != null)
            try {
                jsonData = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

        if (jsonData != null) {
            joke = new JSONObject(jsonData).getJSONObject(JSON_VALUE).getString(JSON_JOKE);
        }
        return joke;
    }
}
