package com.nanodegree.shevchenko.jokeactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LibraryActivity extends Activity {
    public static final String JOKE_EXTRA = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        String joke = getIntent().getStringExtra(JOKE_EXTRA);
        TextView textViewJoke = (TextView) findViewById(R.id.joke_text);
        textViewJoke.setText(joke.replace("&quot;", "\""));
    }
}
