package com.example.vfinances;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeeAllTransactions extends AppCompatActivity
{
    RecyclerView recycleView;
    TransactionDBHelper myDB;
    ArrayList<String> trans_id, trans_type, trans_amount, trans_tag;
    TransactionsCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_transactions);

        recycleView = findViewById(R.id.recycleView);

        myDB = new TransactionDBHelper(SeeAllTransactions.this);
        trans_id = new ArrayList<>();
        trans_type = new ArrayList<>();
        trans_amount = new ArrayList<>();
        trans_tag = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new TransactionsCustomAdapter(SeeAllTransactions.this, trans_id, trans_type, trans_amount, trans_tag);
        recycleView.setAdapter(customAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(SeeAllTransactions.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                trans_id.add(cursor.getString(0));
                trans_type.add(cursor.getString(1));
                trans_amount.add(cursor.getString(2));
                trans_tag.add(cursor.getString(3));

            }
        }
    }
}
