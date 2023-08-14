package com.example.vfinances;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void onSubmitClick(){
        TextView plsEnterEmail = findViewById(R.id.please_enter_email);
        EditText edtTextEmail = findViewById(R.id.enter_email_address);
        plsEnterEmail.setText("is " + edtTextEmail.getText().toString() + " the correct email address?");
    }


}
