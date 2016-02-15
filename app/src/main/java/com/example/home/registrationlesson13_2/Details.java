package com.example.home.registrationlesson13_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity
{
    User myUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent startingIntent = getIntent();

        if (startingIntent.hasExtra("User")){
            myUser = startingIntent.getParcelableExtra("User");

            ((TextView) findViewById(R.id.nameTextViewDetails)).setText(myUser.name);
            ((TextView) findViewById(R.id.lastTextViewDetails)).setText(myUser.last);
            ((TextView) findViewById(R.id.emailTextViewDetails)).setText(myUser.email);
            ((TextView) findViewById(R.id.phoneTextViewDetails)).setText(myUser.phone);
            ((TextView) findViewById(R.id.idTextViewDetails)).setText(Integer.toString(myUser.idnum));
            ((TextView) findViewById(R.id.addressTextViewDetails)).setText(myUser.address);
        }
    }

    public void clickDeleteBtn(View view) {

        Intent data = new Intent();
        data.putExtra("data", myUser);
        setResult(RESULT_OK, data);
        finish();
    }
}
