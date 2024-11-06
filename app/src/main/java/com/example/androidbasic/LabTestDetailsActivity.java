package com.example.androidbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edtDetails;
    Button btnAddtoCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLTPackageName);
        tvTotalCost = findViewById(R.id.textViewLTTotalCost);
        edtDetails = findViewById(R.id.editTextLTTextMultiLine);
        btnBack = findViewById(R.id.btnGoBack);
        btnAddtoCart = findViewById(R.id.LTbuttonAddtoCart);


        edtDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edtDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Tổng tiền: "+ intent.getStringExtra("text3")+"đ");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences ("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra( "text3").toString());

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if(db.checkCart(username, product)==1){
                    Toast.makeText(getApplicationContext(),"Đã thêm sản phẩm", Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(username, product, price, "kham");
                    Toast.makeText(getApplicationContext(),"Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });
    }
}