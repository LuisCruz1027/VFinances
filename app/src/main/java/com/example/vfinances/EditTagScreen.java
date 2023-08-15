package com.example.vfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
/*
        TextView schoolTagText = findViewById(R.id.schoolTagText);

        // Set an OnClickListener for the drawable
        schoolTagText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_clear, 0, 0, 0);
        schoolTag.setOnTouchListener((v, event) -> {
            if (event.getRawX() <= (schoolTagText.getCompoundDrawables()[0].getBounds().width() * 1.5)) {
                // Clicked on the drawable
                schoolTagText.setVisibility(View.GONE); // Hide the EditText
                return true;
            }
            return false;
        });*/
    }
}