package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.adapter.OrderAdapter;
import com.example.ezyfood.model.Cart;
import com.example.ezyfood.model.Wallet;

public class OrderActivity extends AppCompatActivity {

    OrderAdapter adapter;
    RecyclerView rvOrders;
    TextView tvGrandTotal;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvGrandTotal = findViewById(R.id.tv_grand_total);
        btnPay = findViewById(R.id.btn_pay);

        adapter = new OrderAdapter(this);

        rvOrders = findViewById(R.id.rv_orders);
        rvOrders.setLayoutManager(new LinearLayoutManager(this));
        rvOrders.setAdapter(adapter);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = Cart.getInstance();
                Wallet wallet = Wallet.getInstance();
                if(cart.grandTotal > wallet.amount){
                    Toast.makeText(OrderActivity.this, "Insufficient Wallet", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(OrderActivity.this, PaymentActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Cart cart = Cart.getInstance();

        adapter.setOrders(cart.orders);
        adapter.notifyDataSetChanged();
        tvGrandTotal.setText("Total: Rp. " + cart.grandTotal);

    }
}