package com.example.vfinances;

import android.content.Intent;
import android.media.Image;
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
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        homeHighlighted.setOnClickListener(v-> {
            Intent m = new Intent(getApplicationContext(), OverView.class);
            startActivity(m);
        });

        wallet.setOnClickListener(v ->{
            Intent n = new Intent(getApplicationContext(), WalletScreen.class);
            startActivity(n);
        });

        pig.setOnClickListener(v ->{
            Toast.makeText(this, "You're on this activity already.", Toast.LENGTH_SHORT).show();
        });

        lightbulb.setOnClickListener(v ->{
        });



    }


}
