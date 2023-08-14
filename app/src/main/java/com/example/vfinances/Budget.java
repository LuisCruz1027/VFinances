package com.example.vfinances;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class Budget extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        ImageButton homeHighlighted = (ImageButton) findViewById(R.id.home_highlighted);
        ImageButton wallet = (ImageButton) findViewById(R.id.wallet);
        ImageButton pig = (ImageButton) findViewById(R.id.pig);
        ImageButton lightbulb = (ImageButton) findViewById(R.id.lightbulb);

        homeHighlighted.setOnClickListener(v-> {
            Intent i = new Intent(getApplicationContext(), OverView.class);
            startActivity(i);
            setContentView(R.layout.activity_overview);
        });

        wallet.setOnClickListener(v ->{
            Intent i = new Intent(getApplicationContext(), WalletScreen.class);
            startActivity(i);
            setContentView(R.layout.activity_wallet_screen);
        });

        pig.setOnClickListener(v ->{
            Toast.makeText(this, "You're on this activity already.", Toast.LENGTH_SHORT).show();
        });

        lightbulb.setOnClickListener(v ->{
        });

    }


}
