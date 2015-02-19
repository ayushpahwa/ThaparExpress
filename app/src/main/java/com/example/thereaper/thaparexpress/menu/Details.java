package com.example.thereaper.thaparexpress.menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thereaper.thaparexpress.OneTime;
import com.example.thereaper.thaparexpress.R;


public class Details extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Change the UI of the details class.
        setContentView(R.layout.activity_details);
        TextView roll = (TextView) findViewById(R.id.roll1);
        TextView branch = (TextView) findViewById(R.id.Branch1);
        TextView year = (TextView) findViewById(R.id.Year1);
        TextView group = (TextView) findViewById(R.id.Group1);
        TextView name = (TextView) findViewById(R.id.Name1);
        Button edit = (Button) findViewById(R.id.Edit);

        final OneTime ot = new OneTime();

        SharedPreferences myPrefs = getSharedPreferences("data",0);
        int rollNo = myPrefs.getInt("roll",0);
        String nameP = myPrefs.getString("name","");
        String branchP = myPrefs.getString("branch","");
        String yearP = myPrefs.getString("year","");
        String groupP = myPrefs.getString("group","");

        roll.setText(""+rollNo);
        branch.setText(branchP);
        year.setText(yearP);
        group.setText(groupP);
        name.setText(nameP);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ot.setCounter();
                Intent i = new Intent(Details.this,OneTime.class);
                startActivity(i);
                finish();
            }
        });
    }
}
