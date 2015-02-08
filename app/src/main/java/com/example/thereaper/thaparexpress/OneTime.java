package com.example.thereaper.thaparexpress;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OneTime extends Activity {

    final int[] counter = {0};
    String savedCounter = null;
    private int roll_No;
    private String year;
    private String name;
    private String branch;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ot);
        SharedPreferences myPrefs = getSharedPreferences("data",0);
        final SharedPreferences.Editor editor = myPrefs.edit();

        if(savedInstanceState!= null){

            counter[0]= savedInstanceState.getInt(savedCounter);
        }

        if(counter[0] !=0) {
            Intent i = new Intent(this, Main.class);
            startActivity(i);
            finish();
        }else {
           Button submit = (Button) findViewById(R.id.submit);
           submit.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
            String roll;
            EditText rollNo = (EditText) findViewById(R.id.rollNo);
            EditText group = (EditText) findViewById(R.id.groupNo);

            roll= rollNo.getText().toString();
               int abc = 0;
               abc = Integer.parseInt(roll);
                getYear(abc);
               getBranch();
               getName();
               Toast.makeText(OneTime.this,year,Toast.LENGTH_LONG).show();
               editor.putString("name",name);
               editor.putString("branch",branch);
               editor.putString("year",year);
               editor.putInt("roll",abc);
               editor.putString("group",group.getText().toString());
               editor.apply();

               //TODO: Change if condition for the EditTexts to be not null.
               if (false) {
                   Toast.makeText(OneTime.this,"Please enter a valid roll number and group",Toast.LENGTH_LONG).show();
               } else {
                   counter[0] = 1;
                   Intent i = new Intent(OneTime.this, Main.class);
                   try {
                       savedInstanceState.putInt(savedCounter,counter[0]);
                   } catch (NullPointerException e) {
                       e.printStackTrace();
                   }
                   startActivity(i);
                   finish();
               }
           }});
        }
    }

    public String getYear(int roll_No)

    {
        if (roll_No > 101400000 && roll_No < 101500000) {
            year = "first";
        }
        else if (roll_No >101300000){
            year = "second";
        }
        else if (roll_No>101200000){
            year = "third";
        }
        else if (roll_No > 101100000){
            year = "fourth";
        }
        else {
            year = "Invalid roll number input";
        }

        return year;
    }


    // TODO: Cross check the roll numbers with database to retrieve the name.
    public String getName(){

        name = "XYZ";
        return name;
    }

    // TODO: Write a solution to retrieve the branches from the roll numbers.
    public String getBranch(){

        branch="Engineering";
        return branch;
    }

    public void setCounter(){
        counter[0] = 0;
    }
}