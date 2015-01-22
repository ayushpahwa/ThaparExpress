package com.example.thereaper.thaparexpress.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thereaper.thaparexpress.R;

/**
 * Created by thereaper on 17/1/15.
 */
public class Home extends android.app.Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home,container,false);
        return rootView;
    }
}
