package com.example.home.registrationlesson13_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Edit extends Activity
{
    User myUser = new User();
    int UserPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent startingIntent = getIntent();

        if (startingIntent.hasExtra("User")) {
            myUser = startingIntent.getParcelableExtra("User");

            ((TextView)findViewById(R.id.nameTextViewEdit)).setText(myUser.name);
            ((TextView)findViewById(R.id.lastTextViewEdit)).setText(myUser.last);
            ((EditText) findViewById(R.id.emailEditTextEdit)).setText(myUser.email);
            ((EditText) findViewById(R.id.phoneEditTextEdit)).setText(myUser.phone);
            ((EditText) findViewById(R.id.idEditTextEdit)).setText(Integer.toString(myUser.idnum));
            ((EditText) findViewById(R.id.addressEditTextEdit)).setText(myUser.address);
            if (startingIntent.hasExtra("Position")) {
                UserPosition = startingIntent.getIntExtra("Position", 0);
            }
        }
    }

    public void clickSaveBtn(View view) {
        myUser.email = ((EditText) findViewById(R.id.emailEditTextEdit)).getText().toString();
        myUser.phone = ((EditText) findViewById(R.id.phoneEditTextEdit)).getText().toString();
        myUser.idnum = Integer.parseInt(((EditText) findViewById(R.id.idEditTextEdit)).getText().toString());
        myUser.address = ((EditText) findViewById(R.id.addressEditTextEdit)).getText().toString();

        Intent data = new Intent();
        data.putExtra("User", myUser);
        data.putExtra("Position", UserPosition);
        setResult(RESULT_OK, data);
        finish();
    }
}

