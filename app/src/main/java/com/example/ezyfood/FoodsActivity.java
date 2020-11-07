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

public class FoodsActivity extends AppCompatActivity {

    RecyclerView rvFoods;
    FoodAdapter adapter;
    Database db;
    Button btnOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        btnOrders = findViewById(R.id.btn_order);
        db = Database.getInstance();

        rvFoods = findViewById(R.id.rv_foods);
        rvFoods.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new FoodAdapter(this);
        rvFoods.setAdapter(adapter);

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodsActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setItems(db.getItems("Food"));
        adapter.notifyDataSetChanged();
    }
}