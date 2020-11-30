package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorMainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);

        imageView = findViewById(R.id.random);
        textView = findViewById(R.id.txt);
        button = findViewById(R.id.appointmentsbtn);

        final String firstname = getIntent().getStringExtra("Name");

        final String email = getIntent().getStringExtra("mail");

        String name = "WELCOME " + firstname+" "+getIntent().getStringExtra("Lname");
        textView.setText(name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorMainActivity.this,AppointmentDoctorDisplayActivity.class);
                intent.putExtra("mail_id",email);
                startActivity(intent);
            }
        });


    }
}