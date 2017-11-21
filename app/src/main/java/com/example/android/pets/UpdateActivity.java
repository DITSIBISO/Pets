package com.example.android.pets;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    public  static  final  String DATABASE_NAME = "person";
    public  static  final  String PERSON_TABLE_NAME = "person";
    public  static  final  String PERSON_COLUMN_NAME = "name";
    public  static  final  String PERSON_COLUMN_SURNAME = "surname";
    public  static  final  String PERSON_COLUMN_GENDER= "gender";
    public  static  final  String PERSON_COLUMN_AGE= "age";
    public  static  final  String PERSON_COLUMN_ID = "id";
        private  SQLiteDatabase db;
    private EditText mNameEditText;
    private EditText mSurnameEditText;
    private EditText mGenderEditText;

    private EditText mAgeEditText;
    private EditText mIdEditText;
    Button btnviewUpdate;
    Button btnDelete;

    DbHelper myDb;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myDb = new DbHelper(this);
        //UpdateData();

        mNameEditText = (EditText) findViewById(R.id.name);
        mSurnameEditText = (EditText) findViewById(R.id.surname);
        mGenderEditText = (EditText) findViewById(R.id.gender);
        mAgeEditText = (EditText) findViewById(R.id.age);
        mIdEditText = (EditText) findViewById(R.id.id);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        final  DbHelper myDb = new DbHelper(UpdateActivity.this);
        Person person = new Person();


        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(UpdateActivity.this,DisplayActivity.class);
        startActivity(intent);


        Person person = new Person();
        person.setName(mNameEditText.getText().toString());
        person.setSurname(mSurnameEditText.getText().toString());
        person.setGender(mGenderEditText.getText().toString());
        person.setAge(Integer.parseInt(mAgeEditText.getText().toString()));
       // person.setId(Integer.parseInt(mIdEditText.getText().toString()));
        myDb.insertPerson(person.getName(), person.getSurname(), person.getGender(),person.getAge());
    }
});
        //UpdateData();
    }

    //public void UpdateData(String name, String surname, String gender, int age , int id) {

        //ContentValues args = new ContentValues();
        //args.put(PERSON_COLUMN_NAME, name);
        //args.put(PERSON_COLUMN_SURNAME, surname);
        //args.put(PERSON_COLUMN_GENDER, gender);
       // args.put(PERSON_COLUMN_AGE, age);
        //args.put(PERSON_COLUMN_ID,id);

        //return db.update(DATABASE_NAME, args, KEY_ROWID + "=" + rowId, null) > 0;

   // public void UpdateData(){
       // btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

               // boolean isUpdate = myDb.updatePerson(mNameEditText.getText().toString(),
                       // mSurnameEditText.getText().toString(),mGenderEditText.getText().toString() ,mAgeEditText.getText().toString(),mIdEditText.getText().toString());
                //if(isUpdate == true)
                  // Toast.makeText(UpdateActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                //else
               //     Toast.makeText(UpdateActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();

            //}
        //});



    }

    //}

