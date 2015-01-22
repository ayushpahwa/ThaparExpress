package com.example.thereaper.thaparexpress.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.thereaper.thaparexpress.HelloWebViewClient;
import com.example.thereaper.thaparexpress.R;

/**
 * Created by thereaper on 17/1/15.
 */
public class Event extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new HelloWebViewClient());
        webView.loadUrl("http://thaparexpress.in/events.php");
    }
}
