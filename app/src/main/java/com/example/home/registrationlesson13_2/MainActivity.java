package com.example.home.registrationlesson13_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    ArrayList<User> userslist = new ArrayList<User>();


    static final int ADD_USER = 1;
    static final int DETAILS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buildListView();

    }


    public void buildListView(){
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1,userslist);

        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    public void clickAddUserBtn(View v) {
        Intent intentAddUser = new Intent(this,AddUser.class );
        startActivityForResult(intentAddUser, ADD_USER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_USER){
            if (resultCode == RESULT_OK){
                User newUser = data.getParcelableExtra("data");
                if ((userslist==null)||(userslist.size()==0)){
                    userslist.add(newUser);
                }
                else {
                    for (int i = 0; i<userslist.size(); i++){
                        if(equals(newUser)) {
                            Toast.makeText(this, "The user "+newUser.name+" "+newUser.last+" is already exist",Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    userslist.add(newUser);
                }
                Toast.makeText(this, "DONE "+userslist.size(),Toast.LENGTH_LONG).show();
                buildListView();
            }
        }

        if (requestCode == DETAILS){

        }
    }
}
