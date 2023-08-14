package com.example.vfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

public class WalletScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_screen);

        Button schoolTag = findViewById(R.id.schoolTag);
        Button techTag = findViewById(R.id.techTag);
        Button editTag = findViewById(R.id.editTag);



    }
}