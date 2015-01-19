package com.example.thereaper.thaparexpress.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thereaper.thaparexpress.R;

/**
 * Created by thereaper on 17/1/15.
 */
public class Contribute extends android.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contribute,container,false);

        return rootView;
    }
}
