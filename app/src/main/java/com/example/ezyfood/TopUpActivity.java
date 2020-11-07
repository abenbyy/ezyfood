package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ezyfood.model.Wallet;

public class TopUpActivity extends AppCompatActivity {

    EditText etAmount;
    Button btnTopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        etAmount = findViewById(R.id.et_amount);
        btnTopUp = findViewById(R.id.btn_top_up);

        btnTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etAmount.getText().toString() == null || etAmount.getText().toString().equals("")){
                    Toast.makeText(TopUpActivity.this, "Please Enter Amount", Toast.LENGTH_SHORT).show();
                }else if(Integer.parseInt(etAmount.getText().toString()) <= 0){
                    Toast.makeText(TopUpActivity.this, "Amount Can't be 0 or less", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TopUpActivity.this, "Top Up Success!", Toast.LENGTH_SHORT).show();
                    Wallet wallet = Wallet.getInstance();
                    wallet.amount += Integer.parseInt(etAmount.getText().toString());
                    finish();
                }
            }
        });
    }
}