package com.nanodegree.shevchenko.jokeactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LibraryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        String joke = getIntent().getStringExtra("JOKE");
        TextView textViewJoke = (TextView) findViewById(R.id.joke_text);
        textViewJoke.setText(joke);
    }
}
