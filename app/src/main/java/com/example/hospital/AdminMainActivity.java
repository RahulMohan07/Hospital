package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminMainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button1,button2,button3,button4;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        imageView = findViewById(R.id.adminlogo);
        button1 = findViewById(R.id.adminappointments);
        button2 = findViewById(R.id.adminadddoctor);
        button3 = findViewById(R.id.admindoctor);
        button4 = findViewById(R.id.adminremovedoc);
        textView = findViewById(R.id.trademark);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMainActivity.this,AddDoctorActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMainActivity.this,DisplayDoctorActivity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMainActivity.this,RemoveDoctorActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMainActivity.this,AppointmentAdminDisplayActivity.class);
                startActivity(intent);

            }
        });

    }
}