package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.example.shevchenko.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class EndpointTestCase extends AndroidTestCase {

    public void testJokeNotEmpty() {
        String joke = null;
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl(MainActivity.BACKEND_URL);
        MyApi myApiService = builder.build();
        try {
            joke = myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(joke);
        assertFalse(joke.equals(""));
    }
}