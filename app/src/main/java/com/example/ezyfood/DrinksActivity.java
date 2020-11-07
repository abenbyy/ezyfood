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

public class DrinksActivity extends AppCompatActivity {

    RecyclerView rvDrinks;
    FoodAdapter adapter;
    Database db;
    Button btnOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        btnOrders = findViewById(R.id.btn_order);
        db = Database.getInstance();

        rvDrinks = findViewById(R.id.rv_drinks);
        rvDrinks.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new FoodAdapter(this);
        rvDrinks.setAdapter(adapter);

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinksActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setItems(db.getItems("Drink"));
        adapter.notifyDataSetChanged();
    }
}