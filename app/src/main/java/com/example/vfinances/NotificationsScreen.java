package com.example.vfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificationsScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_screen);

        Button arrowBackNoti = findViewById(R.id.arrowBackNoti);
        Button dismissButton = findViewById(R.id.dismissButton);
        TextView notificationsMessage = findViewById(R.id.notificationsMessage);

        arrowBackNoti.setOnClickListener(v -> {
            finish();
        });

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationsMessage.setVisibility(View.GONE);
                dismissButton.setVisibility(View.GONE);
            }
        });
    }
}