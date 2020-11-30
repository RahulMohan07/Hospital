package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.jar.Attributes;

public class AccountActivity extends AppCompatActivity {

    private TextView textView1,textView2;
    private ImageView imageView;
    private Button button1,button2,button3,button4;
    public static String EMAILID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EMAILID = getIntent().getStringExtra("Email");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        textView1 = findViewById(R.id.welcometxt);
        imageView = findViewById(R.id.imgPerson);
        button1 = findViewById(R.id.bookappointments);
        button2 = findViewById(R.id.viewdoc);
        button3 = findViewById(R.id.updateinfo);
        button4 = findViewById(R.id.booked);
        textView2 = findViewById(R.id.trademark);
        String name = "WELCOME " + getIntent().getStringExtra("Name");
        textView1.setText(name);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,AppointmentActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,DisplayDoctorActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,UpdateUserActivity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,AppointmentUserDisplayActivity.class);
                intent.putExtra("mail",EMAILID);
                startActivity(intent);
            }
        });
    }
}