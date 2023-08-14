package com.example.vfinances;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Button submitEmail = (Button) findViewById(R.id.submitEmail);
        Button yes = (Button) findViewById(R.id.yes);
        Button no = (Button) findViewById(R.id.no);
        ImageButton backToHome = (ImageButton) findViewById(R.id.back_to_home);
        EditText enterEmailAddress = findViewById(R.id.enter_email_address);
        TextView pleaseEnterEmail = findViewById(R.id.please_enter_email);

        submitEmail.setOnClickListener(v ->{
            submitEmail.setVisibility(View.INVISIBLE);
            yes.setVisibility(View.VISIBLE);
            no.setVisibility(View.VISIBLE);
            enterEmailAddress.setVisibility(View.INVISIBLE);
            String makeString = "Is " + enterEmailAddress.getText().toString() + " the correct email?";
            pleaseEnterEmail.setText(makeString);
            /*
            switch(v.getId()){
                case R.id.yes:
                    if (!isValidEmail(enterEmailAddress.getText().toString())) {
                        Toast.makeText(this, "This email is invalid. Try again", Toast.LENGTH_SHORT).show();
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                    else{
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("message/rfc822");
                        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{enterEmailAddress.getText().toString()});
                        i.putExtra(Intent.EXTRA_SUBJECT, "Your Password");
                        i.putExtra(Intent.EXTRA_TEXT   , "Your password is: ");
                        try {
                            startActivity(Intent.createChooser(i, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(ForgotPassword.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                case R.id.no:
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                default:
                    break;
            }
        });*/

        if (v.getId() == R.id.yes) {
            if (!isValidEmail(enterEmailAddress.getText().toString())) {
                Toast.makeText(this, "This email is invalid. Try again", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            } else {
                // Your email sending logic for 'yes' case
            }
        } else if (v.getId() == R.id.no) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    });

        backToHome.setOnClickListener(v ->{
            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(myIntent);
            setContentView(R.layout.activity_sign_up_screen);
        });


    }

    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}