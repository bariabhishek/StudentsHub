package com.studentshub.android.activities.intro;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studentshub.android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Intro1 extends Fragment {


    public Intro1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro1, container, false);
    }

}