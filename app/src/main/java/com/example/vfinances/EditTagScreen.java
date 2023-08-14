package com.example.vfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

public class EditTagScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tag_screen);

        Button backToWallet = findViewById(R.id.backToWallet);

        backToWallet.setOnClickListener(v -> {
            finish();
        });
    }
}