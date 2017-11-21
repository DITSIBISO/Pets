package com.example.android.pets;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by eKasiLab Alex CDTB on 2017/11/14.
 */

public class DbHelper extends SQLiteOpenHelper {

    public  static  final  String DATABASE_NAME = "person";
    public  static  final  String PERSON_TABLE_NAME = "person";
    public  static  final  String PERSON_COLUMN_NAME = "name";
    public  static  final  String PERSON_COLUMN_SURNAME = "surname";
    public  static  final  String PERSON_COLUMN_GENDER= "gender";
    public  static  final  String PERSON_COLUMN_AGE= "age";
    public  static  final  String PERSON_COLUMN_ID = "id";


   // public  static  final  String CUSTOMER_TABLE_NAME = "customer";

    public  DbHelper(Context context) {
        super(context,DATABASE_NAME,null, 1 );


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table persons(Id integer primary key Autoincrement ,name text ,surname text , gender text , age int)"
        );

    }

    @Override

    public  void  onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS persons");
        onCreate(db);

    }




    public void  insertPerson(String name, String surname, String gender, int age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("gender", gender);
        contentValues.put("age", age);
        //contentValues.put("id", id);
        db.insert("persons", null, contentValues);

    }


    public void updatePerson (String name, String surname, String gender, int age ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("gender", gender);
        contentValues.put("age", age);
        //contentValues.put("id", id);
        db.update("persons", contentValues, "id = ? ", new String[]{});
        //return true;
        //return false;
    }



    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "persons");
        return numRows;

    }

    public Integer deletePerson(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();

         return db.delete("persons",
                "id= ?",
                new String[]{(Integer.toString(id))});
    }


    public ArrayList<Person> getAllPerson() {
        ArrayList<Person> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from persons", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {

            //array_list.add(String.valueOf(new Person(res.getString(1), res.getString(2), res.getString(3), Integer.parseInt(res.getString(4))));


            array_list.add(new Person(res.getString(0),res.getString(1),res.getString(2),res.getInt(3) ));


            //array_list.add(String.valueOf(new Customer(res.getString(1), Integer.parseInt(res.getString(2)), Integer.parseInt(res.getString(3)), res.getString(4))));
            res.moveToNext();


        }

        return array_list;
    }

}



    //private   String Name;
    //private  String Surname;
   // private String Gender;
   // private int Age;
    //private int Id;