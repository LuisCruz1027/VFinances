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
            String name = nameInput.getText().toString().trim();
            String em = emailInput.getText().toString().trim();
            String pass = passwordInput.getText().toString().trim();
            String conPass = confirmPasswordInput.getText().toString().trim();

            // Check if both password fields are not empty
            if (!pass.isEmpty() && !conPass.isEmpty())
            {
                // Proceed with password confirmation check
                if (pass.equals(conPass))
                {
                    Intent signUpIntent = new Intent(SignUpScreen.this, OverView.class);
                    startActivity(signUpIntent);

                } else
                {
                    confirmPasswordInputLayout.setError(null);
                    // Passwords do not match, show error message
                    confirmPasswordInputLayout.setError("Passwords do not match");
                }
            } else
            {
                confirmPasswordInputLayout.setError(null);
                // One or both password fields are empty, show error message
                confirmPasswordInputLayout.setError("Please enter both passwords");
            }
        });

        alreadyLoginButton.setOnClickListener(v ->
        {
            Intent alreadyIntent = new Intent(SignUpScreen.this, WalletScreen.class);
            startActivity(alreadyIntent);
        });

    }
}