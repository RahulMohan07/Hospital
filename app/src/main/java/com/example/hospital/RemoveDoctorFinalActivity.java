package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RemoveDoctorFinalActivity extends AppCompatActivity {

    private TextView textView1,textView2,textView3,textView4;
    private Button button;
    private HospitalViewModel hospitalViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_doctor_final);
        textView1 = findViewById(R.id.fname);
        textView2 = findViewById(R.id.lname);
        textView3 = findViewById(R.id.email);
        textView4 = findViewById(R.id.branch);
        button = findViewById(R.id.delbutton);

        String fname = getIntent().getStringExtra("FName");
        textView1.setText("First Name: "+fname);
        String lname = getIntent().getStringExtra("LName");
        textView2.setText("Last Name: "+ lname);
        String mail =  getIntent().getStringExtra("Email");
        textView3.setText("Email id: "+mail);
        String branch = getIntent().getStringExtra("Branch");
        textView4.setText("Branch: "+branch);

        String gender = getIntent().getStringExtra("Gender");
        String pass = getIntent().getStringExtra("Password");
        String repass = getIntent().getStringExtra("RePassword");
        int age = getIntent().getIntExtra("Age",-1);

        final Doctor doctor = new Doctor(mail,fname,lname,gender,pass,repass,branch,age);

        hospitalViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hospitalViewModel.delete_doctor(doctor);
                Toast.makeText(RemoveDoctorFinalActivity.this,"Doctor Deleted",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}