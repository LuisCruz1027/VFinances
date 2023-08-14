package com.example.vfinances;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class WalletScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_screen);

        Button schoolTag = findViewById(R.id.schoolTag);
        Button techTag = findViewById(R.id.techTag);
        Button editTag = findViewById(R.id.editTag);

        EditText walletTyping = findViewById(R.id.walletTyping);

        Button[] numberButtons = {
                findViewById(R.id.numberOne),
                findViewById(R.id.numberTwo),
                findViewById(R.id.numberThree),
                findViewById(R.id.numberFour),
                findViewById(R.id.numberFive),
                findViewById(R.id.numberSix),
                findViewById(R.id.numberSeven),
                findViewById(R.id.numberEight),
                findViewById(R.id.numberNine),
                findViewById(R.id.numberZero),
        };

        Button backIcon = findViewById(R.id.backIcon);
        Button checkIcon = findViewById(R.id.checkIcon);

        Intent mainIntent = getIntent();

        for (Button numberButton : numberButtons)
        {
            numberButton.setOnClickListener(view -> {
                String buttonText = numberButton.getText().toString();
                String currentText = walletTyping.getText().toString();

                if (currentText.startsWith("$"))
                {
                    currentText = currentText.substring(1);
                }

                String newText = "$" + currentText + buttonText;
                walletTyping.setText(newText);
            });
        }
        backIcon.setOnClickListener(view -> {
            String currentText = walletTyping.getText().toString();
            if (!currentText.isEmpty())
            {
                currentText = currentText.substring(0, currentText.length() - 1);
                walletTyping.setText(currentText);
            }
        });

        checkIcon.setOnClickListener(view -> {
            String enteredAmount = walletTyping.getText().toString();

            if (!enteredAmount.isEmpty())
            {

            }
        });

        editTag.setOnClickListener(v -> {
            Intent editTagIntent = new Intent(WalletScreen.this, EditTagScreen.class);
            startActivity(editTagIntent);
        });

        Switch enterIncome = findViewById(R.id.enterIncome);
        TextView offIncome = findViewById(R.id.offIncome);
        TextView onExpenses = findViewById(R.id.onExpenses);
        enterIncome.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    offIncome.setVisibility(View.GONE);
                    onExpenses.setVisibility(View.VISIBLE);

                }
                else
                {
                    offIncome.setVisibility(View.VISIBLE);
                    onExpenses.setVisibility(View.GONE);
                }
            }
        });

        checkIcon.setOnClickListener(view -> {
            String enteredAmount = walletTyping.getText().toString();

            // Do something with the entered amount
            // For example, you can log it or process it further

            // Clear the input field after processing
            walletTyping.setText("");
        });

    }
}