package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivityFragment extends Fragment {

    private MainActivity mActivity;
    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);


        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        Button mTellJokeButton = (Button) root.findViewById(R.id.joke_button);
        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                mActivity.tellJoke();
            }
        });

        return root;
    }
}