package com.example.thereaper.thaparexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OneTime extends Activity {


    final int[] counter = {0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ot);

        TextView counterText = (TextView) findViewById(R.id.counterText);

        counterText.setText("" + counter[0]);

        if(false) {
                Intent i = new Intent(this, Main.class);
                startActivity(i);
            }else {
                Button submit = (Button) findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int roll = 0;
                        Global global = (Global) getApplicationContext();
                        EditText rollNo = (EditText) findViewById(R.id.rollNo);
                        EditText group = (EditText) findViewById(R.id.groupNo);

                        try {
                            roll = Integer.parseInt(rollNo.getText().toString());
                        } catch (NumberFormatException e) {
                            Toast.makeText(OneTime.this, "Invalid roll number", Toast.LENGTH_SHORT);
                        }
                        global.setGroup(group.getText().toString());
                        global.setRoll_No(roll);
                        counter[0] += 1;
                        Intent i = new Intent(OneTime.this, Main.class);
                        startActivity(i);
                    }
                });

            }
    }

    public int getCounter(){
        return counter[0];
    }


}
