package com.example.thereaper.thaparexpress.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thereaper.thaparexpress.R;

/**
 * Created by thereaper on 17/1/15.
 */
public class TimeTable extends android.app.Fragment {

    public TimeTable(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ttable,container,false);

        return rootView;
    }
}
