package com.example.vfinances;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


import com.example.vfinancesproject.DBHelper;
import com.example.vfinancesproject.User;

public class LoginActivity extends AppCompatActivity {

    com.example.vfinancesproject.DBHelper db;
    Button loginButton;
    EditText passText,emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        emailText =(EditText) findViewById(R.id.emailText);
        passText =(EditText) findViewById(R.id.passwordText);
        loginButton =(Button) findViewById(R.id.loginButton);
        db = new DBHelper(this);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button forgotPass = (Button) findViewById(R.id.forgotPass);

                forgotPass.setOnClickListener(v -> {
                    Intent forgot = new Intent(LoginActivity.this, ForgotPassword.class);
                    startActivity(forgot);
                });

                String ema = emailText.getText().toString().trim();
                String pas = passText.getText().toString().trim();
                User u = db.checkLogin(ema , pas);
                Intent intentInsights= new Intent(LoginActivity.this, insightsActivity.class);
                Intent intentRemove = new Intent(LoginActivity.this, removeTransaction.class);

                if(u != null){

                    Toast.makeText(getBaseContext(), "Hello, " + ema, Toast.LENGTH_SHORT).show();
                    startActivity(intentRemove);
                }
                else{
                    Toast.makeText(getBaseContext(), "Incorrect Email/Password", Toast.LENGTH_SHORT).show();
                }

            }



        });



    }


}