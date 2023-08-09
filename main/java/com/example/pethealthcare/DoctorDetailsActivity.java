package com.example.pethealthcare;

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
                    {"Doctor Name: Ryan Reynolds", "Hospital Address: 12, Street 1, Chicago", "Experience: 10 years", "Mobile Number: 0725589634", "1000"},
                    {"Doctor Name: Michael Davis", "Hospital Address: 89, Principal Street , NewYork City", "Experience: 7 years", "Mobile Number: 0258637945", "800"},
                    {"Doctor Name: Olivia Green", "Hospital Address: 5, Flowers Street, Miami", "Experience: 3 years", "Mobile Number: 021114567", "500"},
                    {"Doctor Name: Justin Bieber", "Hospital Address: 35, No Name Street, Houston", "Experience: 5 years", "Mobile Number: 038896745", "600"},
                    {"Doctor Name: Andreea Sandulescu", "Hospital Address: 102, York Street, NewYork City", "Experience: 12 years", "Mobile Number: 011268978", "1200"},
                    {"Doctor Name: Teodora Miu", "Hospital Address: 99, Street 5, Miami", "Experience: 2 years", "Mobile Number: 0968889775", "250"}
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Ryan Reynolds", "Hospital Address: 12, Street 1, Chicago", "Experience: 10 years", "Mobile Number: 0725589634", "1000"},
                    {"Doctor Name: Michael Davis", "Hospital Address: 89, Principal Street , NewYork City", "Experience: 7 years", "Mobile Number: 0258637945", "800"},
                    {"Doctor Name: Olivia Green", "Hospital Address: 5, Flowers Street, Miami", "Experience: 3 years", "Mobile Number: 021114567", "500"},
                    {"Doctor Name: Justin Bieber", "Hospital Address: 35, No Name Street, Houston", "Experience: 5 years", "Mobile Number: 038896745", "600"},
                    {"Doctor Name: Andreea Sandulescu", "Hospital Address: 102, York Street, NewYork City", "Experience: 12 years", "Mobile Number: 011268978", "1200"},
                    {"Doctor Name: Teodora Miu", "Hospital Address: 99, Street 5, Miami", "Experience: 2 years", "Mobile Number: 0968889775", "250"}
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Ryan Reynolds", "Hospital Address: 12, Street 1, Chicago", "Experience: 10 years", "Mobile Number: 0725589634", "1000"},
                    {"Doctor Name: Michael Davis", "Hospital Address: 89, Principal Street , NewYork City", "Experience: 7 years", "Mobile Number: 0258637945", "800"},
                    {"Doctor Name: Olivia Green", "Hospital Address: 5, Flowers Street, Miami", "Experience: 3 years", "Mobile Number: 021114567", "500"},
                    {"Doctor Name: Justin Bieber", "Hospital Address: 35, No Name Street, Houston", "Experience: 5 years", "Mobile Number: 038896745", "600"},
                    {"Doctor Name: Andreea Sandulescu", "Hospital Address: 102, York Street, NewYork City", "Experience: 12 years", "Mobile Number: 011268978", "1200"},
                    {"Doctor Name: Teodora Miu", "Hospital Address: 99, Street 5, Miami", "Experience: 2 years", "Mobile Number: 0968889775", "250"}
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Ryan Reynolds", "Hospital Address: 12, Street 1, Chicago", "Experience: 10 years", "Mobile Number: 0725589634", "1000"},
                    {"Doctor Name: Michael Davis", "Hospital Address: 89, Principal Street , NewYork City", "Experience: 7 years", "Mobile Number: 0258637945", "800"},
                    {"Doctor Name: Olivia Green", "Hospital Address: 5, Flowers Street, Miami", "Experience: 3 years", "Mobile Number: 021114567", "500"},
                    {"Doctor Name: Justin Bieber", "Hospital Address: 35, No Name Street, Houston", "Experience: 5 years", "Mobile Number: 038896745", "600"},
                    {"Doctor Name: Andreea Sandulescu", "Hospital Address: 102, York Street, NewYork City", "Experience: 12 years", "Mobile Number: 011268978", "1200"},
                    {"Doctor Name: Teodora Miu", "Hospital Address: 99, Street 5, Miami", "Experience: 2 years", "Mobile Number: 0968889775", "250"}
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Teodora Miu", "Hospital Address: 12, Street 1, Chicago", "Experience: 10 years", "Mobile Number: 0725589634", "1000"},
                    {"Doctor Name: Michael Davis", "Hospital Address: 89, Principal Street , NewYork City", "Experience: 7 years", "Mobile Number: 0258637945", "800"},
                    {"Doctor Name: Olivia Green", "Hospital Address: 5, Flowers Street, Miami", "Experience: 3 years", "Mobile Number: 021114567", "500"},
                    {"Doctor Name: Justin Bieber", "Hospital Address: 35, No Name Street, Houston", "Experience: 5 years", "Mobile Number: 038896745", "600"},
                    {"Doctor Name: Andreea Sandulescu", "Hospital Address: 102, York Street, NewYork City", "Experience: 12 years", "Mobile Number: 011268978", "1200"},
                    {"Doctor Name: Teodora Miu", "Hospital Address: 99, Street 5, Miami", "Experience: 2 years", "Mobile Number: 0968889775", "250"}
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
        btn = findViewById(R.id.buttonBMCartCheckout);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("General Vet")==0)
            doctor_details = doctor_details1;
        else
             if(title.compareTo("Cardiologist Vet")==0)
                 doctor_details = doctor_details2;
             else
                if(title.compareTo("Ultrasound Vet")==0)
                    doctor_details = doctor_details3;
                else
                    if(title.compareTo("Dentist Vet")==0)
                        doctor_details = doctor_details4;
                    else
                            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,MakeAppointmentActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < doctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees: " + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
    ListView lst = findViewById(R.id.listViewBMCart);
    lst.setAdapter(sa);

    lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
            it.putExtra("text1", title);
            it.putExtra("text2", doctor_details[i][0]);
            it.putExtra("text3", doctor_details[i][1]);
            it.putExtra("text4", doctor_details[i][3]);
            it.putExtra("text5", doctor_details[i][4]);
            startActivity(it);
        }
    });
    }
}