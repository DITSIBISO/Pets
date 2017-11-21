package com.example.android.pets;

/**
 * Created by eKasiLab Alex CDTB on 2017/11/14.
 */

public class Person {
    private   String Name;
    private  String Surname;
    private String Gender;
    private int Age;
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }



    public int getAge() {
        return Age;
    }

    public Person(String name, String surname, String gender,  int age) {
        Name = name;
        Surname = surname;
        Gender = gender;

        Age = age;
    }

    public Person(int id) {
        Id = id;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Person() {
    }

}
