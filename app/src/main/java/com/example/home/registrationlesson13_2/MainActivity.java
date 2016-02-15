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


        CreateDummyUsers(8);

        buildListView();
    }

    /**
     *  For debugging only, Creates fake users and adds to the users array list
     * @param usersCount - How many users to create
     */
    private void CreateDummyUsers(int usersCount)
    {
        for(int i = 0; i< usersCount; i++) {
            User user = new User();
            user.name = "Name " + Integer.toString(i);
            user.last = "Last " + Integer.toString(i);
            user.idnum = i;
            user.phone = "+972- " + Integer.toString((i * i * 123456));
            user.address = "City " + Integer.toString(i) + ", Street " + Integer.toString(i + 7);
            user.email = "name" + Integer.toString(i * 979) + "@email.com";
            user.password = Integer.toString(i + 123456) + Integer.toString(i * 123456);

            userslist.add(user);
        }
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

                Intent intentDetails = new Intent(MainActivity.this,Details.class);
                intentDetails.putExtra("User", user);
                startActivityForResult(intentDetails, DETAILS);

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
            if (resultCode == RESULT_OK){
                User newUserDel = data.getParcelableExtra("data");
                userslist.remove(newUserDel);
                buildListView();
            }
        }
    }
}
