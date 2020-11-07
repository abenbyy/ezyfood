package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.database.Database;
import com.example.ezyfood.model.Cart;
import com.example.ezyfood.model.Item;

public class ItemDetailActivity extends AppCompatActivity {
    Database db;
    ImageView ivImage;
    TextView tvName, tvPrice;
    EditText etAmount;
    Button btnOrder;

    Item i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ivImage = findViewById(R.id.iv_image);
        tvName = findViewById(R.id.tv_name);
        tvPrice = findViewById(R.id.tv_price);
        etAmount = findViewById(R.id.et_amount);
        btnOrder = findViewById(R.id.btn_order);

        db = Database.getInstance();
        String itName = getIntent().getExtras().getString("item_name");

        i = db.getItem(itName);

        ivImage.setImageResource(i.getImage());
        tvName.setText(i.getName());
        tvPrice.setText("Rp. " + i.getPrice());

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etAmount.getText().toString() == null || etAmount.getText().toString().equals("") ){
                    Toast.makeText(ItemDetailActivity.this, "Please Input Amount",Toast.LENGTH_SHORT).show();
                }else if(etAmount.getText().toString().equals(0)){
                    Toast.makeText(ItemDetailActivity.this, "Amount can't be 0",Toast.LENGTH_SHORT).show();
                }else{
                    addToCart(i, Integer.parseInt(etAmount.getText().toString()));
                    finish();
                }
            }
        });

    }

    public void addToCart(Item i, int amount){
        Cart cart = Cart.getInstance();
        cart.addItem(i, amount);
    }
}