package com.example.thereaper.thaparexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 *Completed on 18/02/2015 by Ayush Pahwa
 */
public class Splash extends Activity {

    private static int splashTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this,OneTime.class);
                startActivity(i);

                finish();
            }
        },splashTime);

    }
}
