package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DoctorLoginActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private EditText editText1,editText2;
    private TextView textView;
    private HospitalViewModel hospitalViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        imageView = findViewById(R.id.docpic);
        button = findViewById(R.id.logbutton);
        editText1 = findViewById(R.id.doclogin);
        editText2 = findViewById(R.id.docpass);
        textView = findViewById(R.id.trademark);

        hospitalViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mail,password;
                mail = editText1.getText().toString().trim();
                password = editText2.getText().toString().trim();
                hospitalViewModel.getlogindoc(mail).observe(DoctorLoginActivity.this, new Observer<List<Doctor>>() {
                    @Override
                    public void onChanged(List<Doctor> doctors) {
                        if(doctors.size()==0){
                            Toast.makeText(DoctorLoginActivity.this,"Please check your email again!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if(password.equals(doctors.get(0).getRe_password())){
                                Intent intent = new Intent(DoctorLoginActivity.this,DoctorMainActivity.class);
                                intent.putExtra("Name", doctors.get(0).getFirst_names());
                                intent.putExtra("Lname",doctors.get(0).getLast_name());
                                intent.putExtra("mail",doctors.get(0).getEmail_id());
                                startActivity(intent);

                            }
                            else {
                                Toast.makeText(DoctorLoginActivity.this,"Please check your Password again!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}