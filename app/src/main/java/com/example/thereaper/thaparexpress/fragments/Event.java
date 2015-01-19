package com.example.thereaper.thaparexpress.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.thereaper.thaparexpress.R;

/**
 * Created by thereaper on 17/1/15.
 */
public class Event extends android.app.Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events,container,false);
        WebView webView = null;
        try {
            webView=(WebView) getView().findViewById(R.id.webView);
            webView.loadUrl("http://www.google.com");

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return rootView;


    }
}
