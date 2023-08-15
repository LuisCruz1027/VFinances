package com.example.vfinancesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class insightsActivity extends AppCompatActivity {


    void goToUrl(String s)
    {
        try{
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
        catch(Exception e)
        {

            Toast.makeText(getApplicationContext(), "No Website Linked!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights);

        Button investButton = findViewById(R.id.investButton);
        Button financialButton = findViewById(R.id.financialButton);

        financialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String send = "https://www.youtube.com/";
                goToUrl(send);
            }
        });
        investButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String send = "https://www.youtube.com/";
                goToUrl(send);
            }
        });

    }
}