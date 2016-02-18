package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shevchenko.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.nanodegree.shevchenko.jokeactivity.LibraryActivity;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {
    static final String BACKEND_URL = "https://builditbigger-1218.appspot.com/_ah/api/";
    static final String JOKE_LOADING_TAG = "Fetching joke error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke() {
        new EndpointsAsyncTask().execute(this);
    }

    class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

        private MyApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Context... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl(BACKEND_URL);
                myApiService = builder.build();
            }
            context = params[0];
            try {
                return myApiService.getJoke().execute().getData();
            } catch (IOException e) {
                Log.e(JOKE_LOADING_TAG, e.getMessage());
                return "";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Intent jokeActivity = new Intent(context, LibraryActivity.class);
            jokeActivity.putExtra(LibraryActivity.JOKE_EXTRA, result);
            startActivity(jokeActivity);
        }
    }
}