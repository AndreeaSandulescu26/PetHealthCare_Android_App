package com.example.pethealthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MakeAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appointment);

        CardView exit = findViewById(R.id.cardMAExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MakeAppointmentActivity.this, HomeActivity.class));

            }
        });

        CardView generalVet = findViewById(R.id.cardMAGeneralDoctor);
        generalVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent it = new Intent(new Intent(MakeAppointmentActivity.this, DoctorDetailsActivity.class));
              it.putExtra("title", "General Vet");
              startActivity(it);
            }
        });

        CardView cardiologistVet = findViewById(R.id.cardMACardiologist);
        cardiologistVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(new Intent(MakeAppointmentActivity.this, DoctorDetailsActivity.class));
                it.putExtra("title", "Cardiologist Vet");
                startActivity(it);
            }
        });

        CardView ultrasoundVet = findViewById(R.id.cardMAUltrasoundDoctor);
        ultrasoundVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(new Intent(MakeAppointmentActivity.this, DoctorDetailsActivity.class));
                it.putExtra("title", "Ultrasound Vet");
                startActivity(it);
            }
        });

        CardView dentistVet = findViewById(R.id.cardMADentist);
        dentistVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(new Intent(MakeAppointmentActivity.this, DoctorDetailsActivity.class));
                it.putExtra("title", "Dentist Vet");
                startActivity(it);
            }
        });

        CardView surgeonVet = findViewById(R.id.cardMASurgeon);
        surgeonVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(new Intent(MakeAppointmentActivity.this, DoctorDetailsActivity.class));
                it.putExtra("title", "Surgeon Vet");
                startActivity(it);
            }
        });

    }
}