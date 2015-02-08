package com.example.thereaper.thaparexpress.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thereaper.thaparexpress.Global;
import com.example.thereaper.thaparexpress.R;

public class Bug extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);
        Button send = (Button) findViewById(R.id.sendBug);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global global = new Global();
                int rollNo = global.getRoll_No();
                EditText Bug = (EditText) findViewById(R.id.detaiBug);
                String message, email;
                email = "ayushpahwa96@gmail.com";
                String[] mail = {email};
                message = Bug.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("plain/text");
                i.putExtra(Intent.EXTRA_EMAIL, mail);
                i.putExtra(Intent.EXTRA_SUBJECT,"Bug report from" + rollNo);
                i.putExtra(Intent.EXTRA_TEXT, message);
                try {
                    startActivity(i);
                    finish();

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Bug.this,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
