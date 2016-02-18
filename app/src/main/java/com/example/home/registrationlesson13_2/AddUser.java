package com.example.home.registrationlesson13_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddUser extends Activity
{
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        EditText name = (EditText) findViewById(R.id.nameEditTextAdd);
        EditText last = (EditText) findViewById(R.id.lastEditTextAdd);
        EditText email = (EditText) findViewById(R.id.emailEditTextAdd);
        EditText phone = (EditText) findViewById(R.id.phoneEditTextAdd);
        EditText userId = (EditText) findViewById(R.id.idEditTextAdd);
        EditText address = (EditText) findViewById(R.id.addressEditTextAdd);
        EditText password = (EditText) findViewById(R.id.passwordEditTextAdd);

        name.setOnFocusChangeListener(myFocus);
        last.setOnFocusChangeListener(myFocus);
        email.setOnFocusChangeListener(myFocus);
        phone.setOnFocusChangeListener(myFocus);
        userId.setOnFocusChangeListener(myFocus);
        address.setOnFocusChangeListener(myFocus);
        password.setOnFocusChangeListener(myFocus);
    }

    public void clickAddBtn(View v) {

        //// CREATE NEW USER
        user.name = ((EditText) findViewById(R.id.nameEditTextAdd)).getText().toString();
        if (ifNull((EditText)findViewById(R.id.nameEditTextAdd))){     //if null
            return;}
        user.last = ((EditText) findViewById(R.id.lastEditTextAdd)).getText().toString();
        if (ifNull((EditText)findViewById(R.id.lastEditTextAdd))){     //if null
            return;}
        user.email = ((EditText) findViewById(R.id.emailEditTextAdd)).getText().toString();
        if (ifNull((EditText)findViewById(R.id.emailEditTextAdd))){     //if null
            return;}
        user.phone = ((EditText) findViewById(R.id.phoneEditTextAdd)).getText().toString();
        if (ifNull((EditText)findViewById(R.id.phoneEditTextAdd))){     //if null
            return;}
        try {
            user.idnum = Integer.parseInt(((EditText) findViewById(R.id.idEditTextAdd)).getText().toString());
        }
        catch (Exception e){
           findViewById(R.id.idEditTextAdd).requestFocus();
            return;}
        user.address = ((EditText) findViewById(R.id.addressEditTextAdd)).getText().toString();
        if (ifNull((EditText)findViewById(R.id.addressEditTextAdd))){     //if null
            return;}
        user.password = ((EditText) findViewById(R.id.passwordEditTextAdd)).getText().toString();
        if (ifNull((EditText)findViewById(R.id.passwordEditTextAdd))){     //if null
            return;}

        Intent data = new Intent();
        data.putExtra("data",  user);
        setResult(RESULT_OK, data);
        finish();
    }

    private boolean ifNull(EditText editText) { // if Null - return true
        if (editText.getText().toString().equals(editText.getTag().toString())){
            editText.requestFocus();
            return true;
        }
        return false;
    }

    private View.OnFocusChangeListener myFocus = new View.OnFocusChangeListener()
    {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            EditText editText = (EditText) v;
            String text = editText.getText().toString();
            String tag = editText.getTag().toString();
            if ((hasFocus) && (text.equals(tag))) {
                ((EditText) v).setText("");
            }
            if ((!hasFocus) && (text.equals(""))) {
                ((EditText) v).setText(tag);
            }
        }
    };
}
