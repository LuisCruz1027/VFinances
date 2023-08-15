package com.example.vfinances;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class WalletScreen extends AppCompatActivity
{
    private TransactionDBHelper dbHelper;
    boolean isSchoolTagSelected = false;
    boolean isTechTagSelected = false;

    private void updateTagButtonState(Button tagButton, boolean isSelected) {
        if (isSelected) {
            // Change the background color to indicate selection
            tagButton.setBackgroundResource(R.drawable.button_tag_selected);
        } else {
            // Change the background color back to the default
            tagButton.setBackgroundResource(R.drawable.border_tag);
        }
    }

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

        dbHelper = new TransactionDBHelper(this);


        checkIcon.setOnClickListener(view -> {
            String enteredAmount = walletTyping.getText().toString();

            if (!enteredAmount.isEmpty())
            {
                double amount = Double.parseDouble(enteredAmount.substring(1));
                String type = enterIncome.isChecked() ? "income" : "expenses";
                String tag = "";

                if (schoolTag.isSelected())
                {
                    tag = schoolTag.getText().toString();
                }
                else if (techTag.isSelected())
                {
                    tag = techTag.getText().toString();
                }

                dbHelper.insertTransaction(type, amount, tag);

                walletTyping.setText("");
            }
        });

        schoolTag.setOnClickListener(v -> {
            isSchoolTagSelected = !isSchoolTagSelected;
            updateTagButtonState(schoolTag, isSchoolTagSelected);
        });

        techTag.setOnClickListener(v -> {
            isTechTagSelected = !isTechTagSelected;
            updateTagButtonState(techTag, isTechTagSelected);
        });


        Button homeIconButton = findViewById(R.id.homeIconButton);
        Button walletIconButton = findViewById(R.id.walletIconButton);
        Button pigIconButton = findViewById(R.id.pigIconButton);
        Button lightBulbIconButton = findViewById(R.id.lightBulbIconButton);

        homeIconButton.setOnClickListener(v -> {
            Intent userOverview = new Intent(WalletScreen.this, OverView.class);
            startActivity(userOverview);
        });

        walletIconButton.setOnClickListener(v -> {
            Toast.makeText(this, "You're on this activity already.", Toast.LENGTH_SHORT).show();
        });

        pigIconButton.setOnClickListener(v -> {
            Intent userPig = new Intent(WalletScreen.this, Budget.class);
            startActivity(userPig);
        });

        lightBulbIconButton.setOnClickListener(v -> {

        });
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        dbHelper.close();
    }
}