package com.example.androidbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity {

    EditText edtCC, edtCN;
    RadioGroup groupGT;
    RadioButton radNam, radNu;
    Button btnTinh, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        btnTinh = findViewById(R.id.btnDanhGia);
        edtCC = findViewById(R.id.edtCC);
        edtCN = findViewById(R.id.edtCN);
        groupGT = findViewById(R.id.groupGT);
        radNam = findViewById(R.id.radNam);
        radNu = findViewById(R.id.radNu);
        btnBack = findViewById(R.id.btnBMIBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BMIActivity.this,HomeActivity.class));
            }
        });

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCC.getText().toString().isEmpty() && edtCN.getText().toString().isEmpty()){
                    Toast.makeText(BMIActivity.this, "Chưa nhập chiều cao và cân nặng", Toast.LENGTH_SHORT).show();
                } else if (edtCC.getText().toString().isEmpty()) {
                    Toast.makeText(BMIActivity.this, "Chưa nhập chiều cao", Toast.LENGTH_SHORT).show();
                }else if (edtCN.getText().toString().isEmpty()) {
                    Toast.makeText(BMIActivity.this, "Chưa nhập cân nặng", Toast.LENGTH_SHORT).show();
                } else if (radNam.isChecked() == false && radNu.isChecked()== false) {
                    Toast.makeText(BMIActivity.this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show();
                }
                else{
                    double CC = Double.parseDouble(edtCC.getText()+"");
                    double CN = Double.parseDouble(edtCN.getText()+"");
                    DecimalFormat dcf = new DecimalFormat("0.00");
                    double BMI = CN / Math.pow(CC,2) *10000;
                    if ((CC==0)||(CN == 0)){
                        Toast.makeText(BMIActivity.this, "Chiều cao, cân nặng phải lớp hơn 0", Toast.LENGTH_SHORT).show();
                    } else {
                        if(BMI <18.5){
                            Toast.makeText(BMIActivity.this, "Chỉ số BMI của bạn: "+ dcf.format(BMI) +" Bạn quá gầy", Toast.LENGTH_SHORT).show();
                        } else if (18.5 <= BMI && BMI < 25) {
                            Toast.makeText(BMIActivity.this, "Chỉ số BMI của bạn: "+ dcf.format(BMI) +" Bạn bình thường", Toast.LENGTH_SHORT).show();
                        }else if (25 <= BMI && BMI < 30) {
                            Toast.makeText(BMIActivity.this, "Chỉ số BMI của bạn: "+ dcf.format(BMI) +" Bạn đang béo phì cấp I", Toast.LENGTH_SHORT).show();
                        }
                        else if (30 <= BMI && BMI < 35) {
                            Toast.makeText(BMIActivity.this, "Chỉ số BMI của bạn: "+ dcf.format(BMI) +" Bạn đang béo phì cấp II", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(BMIActivity.this, "Chỉ số BMI của bạn: "+ dcf.format(BMI) +" Bạn đang béo phì cấp III", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}