package com.example.android.pets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Movie;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.jar.Attributes;

import static com.example.android.pets.DbHelper.PERSON_TABLE_NAME;

/**
 * Created by eKasiLab Alex CDTB on 2017/11/14.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    Context context;
    private List<Person> personList;
    DbHelper db;
    static final String UID = "_id";
    private SQLiteDatabase database;
    private AdapterView.OnItemClickListener itemClickListener;
    public static final String PERSON_COLUMN_ID = "id";
    CardView delete;

    public CustomerAdapter(Context context, List<Person> personList) {
        this.personList = personList;
        this.context = context;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_main, parent, false);
        // return myViewHolder;
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Person person = personList.get(position);
        holder.name.setText(person.getName());
        holder.surname.setText(person.getSurname());
        holder.gender.setText(person.getGender());
        holder.age.setText(String.valueOf(person.getAge()));
        holder.id.setText(String.valueOf(person.getId()));
        // mButton.setOnClickListener(new View.OnClickListener() {
        //delete cardView = (CardView) itemView.findViewById(R.id.card_view);
        //delete = (CardView) findViewById(R.id.card_view);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper db = new DbHelper(context);
                db.deletePerson(holder.id.getId());
                personList.remove(position);
                notifyDataSetChanged();


                //Toast.makeText(getApplicationContext(), "Deleted Successfully",
                       // Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, surname, gender, age, id;
        CardView cardView;


        public ViewHolder(View itemview) {

            super(itemview);
            name = (TextView) itemview.findViewById(R.id.name);
            surname = (TextView) itemview.findViewById(R.id.surname);
            gender = (TextView) itemview.findViewById(R.id.gender);
            age = (TextView) itemview.findViewById(R.id.age);
            id = (TextView) itemview.findViewById(R.id.id);
            CardView cardView = (CardView) itemview.findViewById(R.id.card_view);


        }
    }
}






