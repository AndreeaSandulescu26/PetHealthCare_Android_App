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

public class PharmacyActivity extends AppCompatActivity {

    private String[][] packages =
    {
        {"FleaAway", "", "", "", "50"},
        {"HeartGuard", "", "", "", "120"},
        {"Rimadyl", "", "", "", "64"},
        {"Apoquel", "", "", "", "149"},
        {"Revolution", "", "", "", "35"},
        {"Prozac", "", "", "", "179"},
        {"Sentinel", "", "", "", "84"},
        {"Cerenia", "", "", "", "99"},
        {"Methigel", "", "", "", "89"}
    };

    private String[] package_details = {
            " FleaAway is an oral medication for dogs and cats that helps control fleas and ticks. It provides long-lasting protection against these parasites, preventing infestations and reducing itching and discomfort.",
            " HeartGuard is a monthly chewable tablet for dogs that prevents heartworm disease. It kills the immature stages of heartworms and helps protect your pet from this potentially life-threatening condition.",
            " Rimadyl is a non-steroidal anti-inflammatory drug (NSAID) used to relieve pain and inflammation in dogs. It is commonly prescribed for conditions such as arthritis, post-operative pain, and musculoskeletal injuries.",
            " Apoquel is a medication used to manage itching and inflammation in dogs caused by allergic skin conditions such as atopic dermatitis. It provides fast relief and helps improve the quality of life for dogs with chronic itching.",
            " Revolution is a topical medication for dogs and cats that provides broad-spectrum protection against fleas, ticks, heartworms, ear mites, and certain types of worms. It is applied monthly to the skin and helps keep your pet protected from multiple parasites.",
            " Prozac, also known by its generic name fluoxetine, is a medication used in some cases to treat behavioral disorders in dogs and cats. It can help manage anxiety, aggression, and obsessive-compulsive behaviors under the guidance of a veterinarian.",
            " Sentinel is an oral medication for dogs that provides protection against heartworms, fleas, and certain intestinal parasites. It is given monthly and helps prevent these common issues in dogs.",
            " Cerenia is a medication used to prevent vomiting in dogs, particularly in cases of motion sickness or after surgical procedures. It helps reduce nausea and vomiting and can be administered orally or by injection.",
            " Methigel is a urinary acidifier for cats that helps manage and prevent urinary tract issues such as bladder stones or urinary tract infections. It helps maintain a healthy pH balance in the urine and supports urinary tract health."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PharmacyActivity.this, CartPharmacyActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PharmacyActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < packages.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: :" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(PharmacyActivity.this, PharmacyDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

    }
}