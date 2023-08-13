package com.example.vfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        TextView signUp = findViewById(R.id.signUp);
        EditText nameInput = findViewById(R.id.nameInput);
        EditText emailInput = findViewById(R.id.emailInput);
        TextInputEditText passwordInput = findViewById(R.id.passwordInput);
        TextInputEditText confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        TextInputLayout passwordInputLayout = findViewById(R.id.passwordInputLayout);
        TextInputLayout confirmPasswordInputLayout = findViewById(R.id.confirmPasswordInputLayout);

        Button signUpButton = findViewById(R.id.signUpButton);
        Button alreadyLoginButton = findViewById(R.id.alreadyLogInButton);

        signUpButton.setOnClickListener(v ->
        {
            Intent signUpIntent = new Intent(SignUpScreen.this, OverView.class);
            startActivity(signUpIntent);
        });
    }
}