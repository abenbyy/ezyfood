package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ezyfood.adapter.OrderAdapter;
import com.example.ezyfood.adapter.PaymentAdapter;
import com.example.ezyfood.model.Cart;
import com.example.ezyfood.model.Wallet;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {
    PaymentAdapter adapter;
    RecyclerView rvOrders;
    TextView tvGrandTotal;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        rvOrders = findViewById(R.id.rv_orders);
        btnHome = findViewById(R.id.btn_home);

        adapter = new PaymentAdapter(this);
        tvGrandTotal = findViewById(R.id.tv_grand_total);

        rvOrders.setLayoutManager(new LinearLayoutManager(this));
        rvOrders.setAdapter(adapter);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Cart cart = Cart.getInstance();
        Wallet wallet = Wallet.getInstance();

        adapter.setOrders(cart.orders);
        tvGrandTotal.setText("Total: Rp. " + cart.grandTotal);
        adapter.notifyDataSetChanged();

        wallet.amount -= cart.grandTotal;
        cart.orders = new ArrayList<>();
        cart.grandTotal = 0;
    }
}