package com.example.home.registrationlesson13_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Details extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent startingIntent = getIntent();

        if (startingIntent.hasExtra("User")){
            User newUser = startingIntent.getParcelableExtra("User");

            EditText editText = (EditText) findViewById(R.id.nameEditTextEdit);
            editText.setText(newUser.name);

            //TextView textView = (TextView) findViewById(R.id.textView);
            //textView.setText("The towns of "+name+":");
        }

    }
}
