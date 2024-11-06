package com.example.androidbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Tên bác sĩ: Nguyễn Thanh Liêm", "Địa chỉ bệnh viện: Hà Nội", "Kinh nghiệm: 12 năm", "Số điện thoại: 8898989898", "300"},
                    {"Tên bác sĩ: Võ Thành Nhân", "Địa chỉ bệnh viện: Đà Nẵng", "Kinh nghiệm: 5 năm", "Số điện thoại: 9898989898", "608"},
                    {"Tên bác sĩ: Phạm Nhật An", "Địa chỉ bệnh viện: Huế", "Kinh nghiệm: 15 năm", "Số điện thoại: 7898989898", "960"},
                    {"Tên bác sĩ: Phan Quỳnh Lan", "Địa chỉ bệnh viện: Sài Gòn", "Kinh nghiệm: 20 năm", "Số điện thoại: 9898800000", "580"},
                    {"Tên bác sĩ: Tôn Thất Trí Dũng", "Địa chỉ bệnh viện: Hồ Chí Minh", "Kinh nghiệm: 7 năm", "Số điện thoại: 7798989898", "800"},
            };
    private String[][] doctor_details2 =
            {
                    {"Tên bác sĩ: Nguyễn Thanh Liêm", "Địa chỉ bệnh viện: Hà Nội", "Kinh nghiệm: 12 năm", "Số điện thoại: 8898989898", "300"},
                    {"Tên bác sĩ: Võ Thành Nhân", "Địa chỉ bệnh viện: Đà Nẵng", "Kinh nghiệm: 5 năm", "Số điện thoại: 9898989898", "608"},
                    {"Tên bác sĩ: Phạm Nhật An", "Địa chỉ bệnh viện: Huế", "Kinh nghiệm: 15 năm", "Số điện thoại: 7898989898", "960"},
                    {"Tên bác sĩ: Phan Quỳnh Lan", "Địa chỉ bệnh viện: Sài Gòn", "Kinh nghiệm: 20 năm", "Số điện thoại: 9898800000", "580"},
                    {"Tên bác sĩ: Tôn Thất Trí Dũng", "Địa chỉ bệnh viện: Hồ Chí Minh", "Kinh nghiệm: 7 năm", "Số điện thoại: 7798989898", "800"},
            };
    private String[][] doctor_details3 =
            {
                    {"Tên bác sĩ: Nguyễn Thanh Liêm", "Địa chỉ bệnh viện: Hà Nội", "Kinh nghiệm: 12 năm", "Số điện thoại: 8898989898", "300"},
                    {"Tên bác sĩ: Võ Thành Nhân", "Địa chỉ bệnh viện: Đà Nẵng", "Kinh nghiệm: 5 năm", "Số điện thoại: 9898989898", "608"},
                    {"Tên bác sĩ: Phạm Nhật An", "Địa chỉ bệnh viện: Huế", "Kinh nghiệm: 15 năm", "Số điện thoại: 7898989898", "960"},
                    {"Tên bác sĩ: Phan Quỳnh Lan", "Địa chỉ bệnh viện: Sài Gòn", "Kinh nghiệm: 20 năm", "Số điện thoại: 9898800000", "580"},
                    {"Tên bác sĩ: Tôn Thất Trí Dũng", "Địa chỉ bệnh viện: Hồ Chí Minh", "Kinh nghiệm: 7 năm", "Số điện thoại: 7798989898", "800"},
            };
    private String[][] doctor_details4 =
            {
                    {"Tên bác sĩ: Nguyễn Thanh Liêm", "Địa chỉ bệnh viện: Hà Nội", "Kinh nghiệm: 12 năm", "Số điện thoại: 8898989898", "300"},
                    {"Tên bác sĩ: Võ Thành Nhân", "Địa chỉ bệnh viện: Đà Nẵng", "Kinh nghiệm: 5 năm", "Số điện thoại: 9898989898", "608"},
                    {"Tên bác sĩ: Phạm Nhật An", "Địa chỉ bệnh viện: Huế", "Kinh nghiệm: 15 năm", "Số điện thoại: 7898989898", "960"},
                    {"Tên bác sĩ: Phan Quỳnh Lan", "Địa chỉ bệnh viện: Sài Gòn", "Kinh nghiệm: 20 năm", "Số điện thoại: 9898800000", "580"},
                    {"Tên bác sĩ: Tôn Thất Trí Dũng", "Địa chỉ bệnh viện: Hồ Chí Minh", "Kinh nghiệm: 7 năm", "Số điện thoại: 7798989898", "800"},
            };
    private String[][] doctor_details5 =
            {
                    {"Tên bác sĩ: Nguyễn Thanh Liêm", "Địa chỉ bệnh viện: Hà Nội", "Kinh nghiệm: 12 năm", "Số điện thoại: 8898989898", "300"},
                    {"Tên bác sĩ: Võ Thành Nhân", "Địa chỉ bệnh viện: Đà Nẵng", "Kinh nghiệm: 5 năm", "Số điện thoại: 9898989898", "608"},
                    {"Tên bác sĩ: Phạm Nhật An", "Địa chỉ bệnh viện: Huế", "Kinh nghiệm: 15 năm", "Số điện thoại: 7898989898", "960"},
                    {"Tên bác sĩ: Phan Quỳnh Lan", "Địa chỉ bệnh viện: Sài Gòn", "Kinh nghiệm: 20 năm", "Số điện thoại: 9898800000", "580"},
                    {"Tên bác sĩ: Tôn Thất Trí Dũng", "Địa chỉ bệnh viện: Hồ Chí Minh", "Kinh nghiệm: 7 năm", "Số điện thoại: 7798989898", "800"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Bác sĩ gia đình")==0){
            doctor_details = doctor_details1;
        } else if (title.compareTo("Chuyên gia dinh dưỡng")==0) {
            doctor_details = doctor_details2;
        }else if (title.compareTo("Nha sĩ")==0) {
            doctor_details = doctor_details3;
        }else if (title.compareTo("Bác sĩ phẫu thuật")==0) {
            doctor_details = doctor_details4;
        }else {
            doctor_details = doctor_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i=0; i<doctor_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Chi phí:"+doctor_details[i][4]+"đ");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}