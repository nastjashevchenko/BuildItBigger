package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MainActivity activity = (MainActivity) getActivity();
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJoke = (Button) root.findViewById(R.id.joke_button);
        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.tellJoke();
            }
        });

        return root;
    }
}
