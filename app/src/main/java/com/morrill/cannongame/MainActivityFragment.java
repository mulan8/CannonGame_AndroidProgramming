// MainActivityFragment.java
// MainActivityFragment creates and manages a CannonView
package com.morrill.cannongame;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
    private CannonView cannonView; //custom view to display the game

//    public MainActivityFragment() {
        // Required empty public constructor
//    }

    // called when Fragment's view needs to be created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment (fragment_main.xml)
        View view =
                inflater.inflate(R.layout.fragment_main, container, false);

        // get a reference to the CannonView
        cannonView = (CannonView) view.findViewById(R.id.cannonView);
        return view;
    }

    // set up volume control once Activity is created
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // allow volume buttons to set game volume
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    // when MainActivity is paused, terminate the game
    @Override
    public void onPause() {
        super.onPause();
        cannonView.stopGame(); // terminates the game
    }

    // when MainActivity is paused, MainActivityFragment releases resources
    @Override
    public void onDestroy() {
        super.onDestroy();
        cannonView.releaseResources();
    }
}