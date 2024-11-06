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

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Viên Uống Alpha Choay", "", "","", "50"},
                    {"Viên Uống Chromium Picolinate 200mcg của HealthVit", "", "","", "305"},
                    {"Viên Uống Vitamin B Complex", "", "","", "448"},
                    {"Viên Uống Dầu Mầm Lúa Mì Vitamin E của Inlife", "", "","", "539"},
                    {"Viên Uống Dolo 650", "", "","", "30"},
                    {"Viên Uống Crocin 650 Advance", "", "","", "50"},
                    {"Viên Ngậm Strepsils Dành Cho đau họng", "", "","", "40"},
                    {"Viên Uống Tata 1mg Canxi + Vitamin D3", "", "","", "30"},
                    {"Viên Uống Feronia-XT", "", "","", "130"},

            };
    private String[] package_details ={
            "Củng cố và duy trì xương và răng khỏe mạnh\n"+
                    "Giảm mệt mỏi/stress và đau cơ\n"+
                    "Tăng cường hệ miễn dịch và gia tăng khả năng kháng viêm",
            "Chromium là một khoáng chất vi lượng thiết yếu đóng vai trò quan trọng trong việc điều hòa insulin",
            "Cung cấp giải pháp cho các thiếu hụt vitamin B\n"+
                    "Hỗ trợ hình thành tế bào hồng cầu\n"+
                    "Duy trì hệ thần kinh khỏe mạnh",
            "Nó thúc đẩy sức khỏe cũng như mang lại lợi ích cho da.\n"+
                    "Giúp giảm tình trạng nám và sạm da.\n"+
                    "Bảo vệ da khỏi tác hại của tia UV A và UV B.",
            "Viên Dolo 650 giúp giảm đau và hạ sốt bằng cách chặn sự giải phóng của một số chất truyền tin hóa học",
            "Giúp giảm sốt và hạ nhiệt độ cao\n"+
                    "Phù hợp cho những người có bệnh tim hoặc huyết áp cao",
            "Giảm các triệu chứng của nhiễm trùng họng do vi khuẩn và làm dịu quá trình hồi phục\n"+
                    "Mang lại cảm giác ấm áp và dễ chịu trong khi bị đau họng",
            "Giảm nguy cơ thiếu canxi, còi xương và loãng xương\n"+
                    "Thúc đẩy di động và linh hoạt của các khớp",
            "Giúp giảm thiếu sắt do mất máu mạn tính hoặc thiếu hụt sắt trong chế độ ăn uống"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBackBM);
        btnGoToCart = findViewById(R.id.btnGotoCartBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("Line1",packages[i][0]);
            item.put("Line2",packages[i][1]);
            item.put("Line3",packages[i][2]);
            item.put("Line4",packages[i][3]);
            item.put("Line5","Tổng tiền: "+ packages[i][4]+"đ");
            list.add( item);
        }

        sa = new SimpleAdapter(this,list, R.layout.multi_lines,
                new String[] {"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}