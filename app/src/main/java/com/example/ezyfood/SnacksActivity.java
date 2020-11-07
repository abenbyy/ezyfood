package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ezyfood.adapter.FoodAdapter;
import com.example.ezyfood.database.Database;

public class SnacksActivity extends AppCompatActivity {

    RecyclerView rvSnacks;
    FoodAdapter adapter;
    Database db;
    Button btnOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        btnOrders = findViewById(R.id.btn_order);
        db = Database.getInstance();

        rvSnacks = findViewById(R.id.rv_snacks);
        rvSnacks.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new FoodAdapter(this);
        rvSnacks.setAdapter(adapter);

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SnacksActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setItems(db.getItems("Snack"));
        adapter.notifyDataSetChanged();
    }
}