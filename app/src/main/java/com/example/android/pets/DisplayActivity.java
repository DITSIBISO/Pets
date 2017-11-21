package com.example.android.pets;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {


    DbHelper db ;
    View view = null;
    Context context = this;
    LayoutInflater layoutInflater = null;
    FrameLayout content;
     CustomerAdapter adapter;
    Button btnviewUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);





        //getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        //recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
        db = new DbHelper(DisplayActivity.this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.CardList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        List<Person> personList = (ArrayList<Person>)db.getAllPerson();
        //List<Person> personList = new ArrayList<>();
       // Person person = new Person();


        adapter = new CustomerAdapter(DisplayActivity.this,personList);
        recyclerView.setAdapter(adapter);
        btnviewUpdate= (Button)findViewById(R.id.button_update);


        //Person person = new Person();
        //Person person = new Person();


       // person.setName(person.getName());
        //person.setSurname(person.getSurname());
        //person.setGender(person.getGender());
       // person.setAge(Integer.parseInt(String.valueOf(person.getAge())));

       // personList.add(person);

        //adapter = new CustomerAdapter(DisplayActivity.this,personList);
        //recList.setAdapter(adapter);

        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case  R.id.update:Bundle dataBundle = new Bundle();
            dataBundle.putInt("id",0);

                Intent intent = new Intent(DisplayActivity.this,UpdateActivity.class);
                intent.putExtras(dataBundle);

                startActivity(intent);
                return true;
                default:return super.onOptionsItemSelected(item);


        }
    }


    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}


