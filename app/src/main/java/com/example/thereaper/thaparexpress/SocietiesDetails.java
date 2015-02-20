package com.example.thereaper.thaparexpress;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class SocietiesDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socities_details);

        Intent i = getIntent();
        String socName = i.getStringExtra("socName");
        String socDesc = i.getStringExtra("socDesc");

        ImageView iv = (ImageView) findViewById(R.id.imageSocFinal);
        TextView socNameFinal = (TextView) findViewById(R.id.socNameFinal);
        TextView socDescFinal = (TextView) findViewById(R.id.socDescFinal);

        socNameFinal.setText(socName);
        socDescFinal.setText(socDesc);

    }
}
