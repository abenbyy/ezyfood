package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ezyfood.model.Wallet;
import com.example.ezyfood.util.Seeder;

public class MainActivity extends AppCompatActivity {
    Wallet wallet;
    Button btnOrder, btnDrinks, btnFoods, btnSnacks, btnTopUp;
    TextView tvWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Insert Dummy Data
        Seeder.run();

        // Set wallet
        tvWallet = findViewById(R.id.tv_wallet);
        wallet = Wallet.getInstance();
        tvWallet.setText("Rp. " + wallet.amount);

        btnOrder = findViewById(R.id.btn_order);
        setIntent(btnOrder, OrderActivity.class);
        btnDrinks = findViewById(R.id.btn_drinks);
        setIntent(btnDrinks, DrinksActivity.class);
        btnFoods = findViewById(R.id.btn_foods);
        //setIntent(btnFoods, F);
        btnSnacks = findViewById(R.id.btn_snacks);
        //setIntent(btnSnacks, S);
        btnTopUp = findViewById(R.id.btn_top_up);
        //setIntent(btnTopUp, T);

    }

    public void setIntent(Button btn, Class<?> cls){
        final Class<?> clas = cls;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, clas);
                startActivity(intent);
            }
        });
    }
}