package com.example.androidbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Gói 1: Kiểm tra toàn diện cơ thể", "", "", "", "999"},
            {"Gói 2: Đo đường huyết lúc đói","", "", "", "299"},
            {"Gói 3: Kiểm tra kháng thể COVID-19 - IgG", "", "", "", "899"},
            {"Gói 4: Kiểm tra tuyến giáp", "", "", "", "499"},
            {"Gói 5:  Kiểm tra hệ miễn dịch", "", "", "", "699"},
    };
    private String[] package_details = {
            "Đo đường huyết lúc đói\n" +
                    "Tổng phân tích tế bào máu\n" +
                    "Xét nghiệm HbA1c \n" +
                    "Xét nghiệm sắt\n" +
                    "Xét nghiệm chức năng thận\n" +
                    "Xét nghiệm LDH (Lactate Dehydrogenase) trong huyết thanh\n" +
                    "Hồ sơ lipid \n" +
                    "Xét nghiệm chức năng gan",
            "Đo đường huyết lúc đói",
            "Kiểm tra kháng thể COVID-19 - IgG",
            "Hồ sơ tuyến giáp tổng thể (T3, T4 & TSH nhạy cảm cao)",
            "Tổng phân tích tế bào máu\n" +
                    "Xét nghiệm định lượng CRP (C Reactive Protein) trong huyết thanh\n" +
                    "Xét nghiệm sắt\n" +
                    "Xét nghiệm chức năng thận\n" +
                    "Xét nghiệm 25-HydroxyVitamin D \n" +
                    "Xét nghiệm chức năng gan\n" +
                    "Hồ sơ lipid "
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGo, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGo = findViewById(R.id.btnAddtoCartLT);
        btnBack = findViewById(R.id.buttonLTBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i=0; i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Tổng tiền:"+packages[i][4]+"đ");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });
    }
}