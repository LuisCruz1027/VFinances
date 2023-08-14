package com.example.vfinancesproject;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class removeTransaction extends AppCompatActivity {

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_transaction);
        db.viewData();


    }

}