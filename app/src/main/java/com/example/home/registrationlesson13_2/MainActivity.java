package com.example.home.registrationlesson13_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    ArrayList<User> userslist = new ArrayList<>();

    static final int ADD_USER = 1;
    static final int DETAILS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildListView();

    }


    public void buildListView(){
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,userslist);

        final ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(adapter);

        mListView.setOnItemLongClickListener(new OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                User user = userslist.get(position);

                Intent intentEdit = new Intent(MainActivity.this,Details.class);
                intentEdit.putExtra("User", user);
                startActivity(intentEdit);


                //Toast.makeText(getApplicationContext(),mListView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();


                return true;
            }
        });
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
                if (userslist==null){
                    userslist = new ArrayList<>();
                    userslist.add(newUser);
                }
                else
                {
                    for (int i = 0; i<userslist.size(); i++){
                        if(userslist.get(i).equals(newUser)) {
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
