package com.example.vfinancesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        TextView emailText = findViewById(R.id.emailText);
        TextView passText = findViewById(R.id.passwordText);
        Button loginButton = findViewById(R.id.loginButton);
        Intent intent = new Intent(LoginActivity.this, testingActivity.class);
        Intent intent1 = new Intent(LoginActivity.this, insightsActivity.class);

    }
}