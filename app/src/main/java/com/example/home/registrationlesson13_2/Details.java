package com.example.home.registrationlesson13_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends Activity
{
    User myUser = new User();
    int UserPosition;
    static final int DETAIL_OK = 11;
    static final int EDIT_OK = 12;

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
        if (startingIntent.hasExtra("Position")){
            UserPosition = startingIntent.getIntExtra("Position", 0);
        }
    }

    public void clickDeleteBtn(View view) {
        Intent data = new Intent();
        data.putExtra("data", myUser);
        setResult(DETAIL_OK, data);
        finish();
    }

    public void clickEditBtn(View view) {
        Intent intentEditUser = new Intent(getApplicationContext(), Edit.class);
        intentEditUser.putExtra("User", myUser);
        intentEditUser.putExtra("Position",UserPosition);
        startActivityForResult(intentEditUser, EDIT_OK);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            User myNewUser = data.getParcelableExtra("User");
            data.putExtra("Position", UserPosition);
            data.putExtra("User", myNewUser);
            setResult(EDIT_OK, data);
            finish();
        }
    }
}
