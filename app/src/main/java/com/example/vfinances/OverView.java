package com.example.vfinances;
import android.util.*;
import android.view.*;
import android.widget.*;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
public class OverView extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview);

        Intent mainIntent = getIntent();

        TextView userBankBalance = findViewById(R.id.user_bank_balance);


    }
}
