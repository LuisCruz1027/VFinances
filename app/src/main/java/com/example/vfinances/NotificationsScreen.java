package com.example.vfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class NotificationsScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_screen);

        Button arrowBackNoti = findViewById(R.id.arrowBackNoti);

        arrowBackNoti.setOnClickListener(v -> {
            finish();
        });
    }
}