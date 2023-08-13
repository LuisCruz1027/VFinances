package com.example.vfinancesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class RemoveTransaction extends AppCompatActivity {
    DBHelper db;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removetransac);

        db = new DBHelper(this);
        listItem = new ArrayList<>();
        viewData();

    }

    private void viewData() {
        Cursor cursor = db.viewData();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(getBaseContext(), "No data.", Toast.LENGTH_SHORT).show();

        }

    }
}