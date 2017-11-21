package com.example.android.pets;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Person> personList = new ArrayList<>();
    // private List<Person> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CustomerAdapter mAdapter;
    View view = null;
    Context context = this;
    LayoutInflater layoutInflater = null;

    private EditText mNameEditText;
    private EditText mSurnameEditText;
    private EditText mGenderEditText;

    private EditText mAgeEditText;
    private EditText mIdEditText;

    //private EditText mIdEditText;
    private Button mButton;

    private DbHelper Db;
    private CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);








        final DbHelper Db = new DbHelper(MainActivity.this);
        //final  Person person = new Person();


        mNameEditText = (EditText) findViewById(R.id.name);
        mSurnameEditText = (EditText) findViewById(R.id.surname);
        mGenderEditText = (EditText) findViewById(R.id.gender);
        mAgeEditText = (EditText) findViewById(R.id.age);
        mIdEditText = (EditText) findViewById(R.id.id);


        mButton = (Button) findViewById(R.id.button);


        //Log.v("List",String.valueOf((mDbHelper1.getAllPerson().get(0).getName)));

        //adapter = new CustomerAdapter(MainActivity.this, customerList);
        //adapter = new CustomerAdapter(MainActivity.this,personList);
        //recList.setAdapter(adapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name, surname, gender, age, id;

                //final Customer customer1 = new Customer();

                name = mNameEditText.getText().toString();
                surname = mSurnameEditText.getText().toString();
                gender = mGenderEditText.getText().toString();
                age = mAgeEditText.getText().toString();
                id = mIdEditText.getText().toString();

                Person person = new Person();
                person.setName(name);
                person.setSurname(surname);
                person.setGender(gender);
                person.setAge(Integer.parseInt(age));
                //person.setId(Integer.parseInt(id));

                Db.insertPerson(person.getName(), person.getSurname(), person.getGender(),person.getAge());

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);


            }
        });

    }

}




