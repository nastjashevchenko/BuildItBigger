package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivityFragment extends Fragment {

    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MainActivity activity = (MainActivity) getActivity();
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button mTellJokeButton = (Button) root.findViewById(R.id.joke_button);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                activity.tellJoke();
            }
        });

        return root;
    }
}
