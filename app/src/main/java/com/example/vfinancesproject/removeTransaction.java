package com.example.vfinancesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


import java.util.ArrayList;

public class removeTransaction extends AppCompatActivity {


    ArrayList<String> listItem;
    ArrayAdapter adapter;
    DBHelper db;
    ListView userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_transaction);

        db = new DBHelper(this);
        listItem = new ArrayList<>();
        userList = findViewById(R.id.transactions_list);
        viewData();


        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(removeTransaction.this,""+text,Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void viewData() {

        Cursor cursor = db.viewData();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(getBaseContext(), "No data.", Toast.LENGTH_SHORT).show();

        }
        else {
            while(cursor.moveToNext())
            {
                listItem.add(cursor.getString(0));
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.activity_list_item,listItem);
            userList.setAdapter(adapter);

        }

    }


}