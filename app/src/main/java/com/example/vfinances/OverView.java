package com.example.vfinances;
import android.view.View;
import android.widget.*;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
public class OverView extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Button homeHighlighted = (Button) findViewById(R.id.home_highlighted);
        Button wallet = (Button) findViewById(R.id.wallet);
        Button pig = (Button) findViewById(R.id.pig);
        Button lightbulb = (Button) findViewById(R.id.lightbulb);
        ImageButton notificationBell = (ImageButton) findViewById(R.id.notification_bell);
        Button seeAll = (Button) findViewById(R.id.see_all);

        notificationBell.setOnClickListener(v -> {
            Intent notifBell = new Intent(OverView.this, NotificationsScreen.class);
            startActivity(notifBell);
        });

        homeHighlighted.setOnClickListener(v-> {
            Toast.makeText(this, "You're on this activity already.", Toast.LENGTH_SHORT).show();
        });

        wallet.setOnClickListener(v ->{
            Intent userWallet = new Intent(OverView.this, WalletScreen.class);
            startActivity(userWallet);
        });

        pig.setOnClickListener(v ->{
            Intent piggy = new Intent(OverView.this, Budget.class);
            startActivity(piggy);
        });

        lightbulb.setOnClickListener(v ->{
        });

        seeAll.setOnClickListener(v ->{
            Intent seeTrans = new Intent(getApplicationContext(), SeeAllTransactions.class);
            startActivity(seeTrans);
        });
    }
}
