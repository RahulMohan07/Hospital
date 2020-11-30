package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RemoveDoctorActivity extends AppCompatActivity {

    public Button button;
    public EditText editText;
    private HospitalViewModel hospitalViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_doctor);
        button = findViewById(R.id.delproceed);
        editText = findViewById(R.id.delmailid);

        hospitalViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail;
                mail = editText.getText().toString().trim();
                hospitalViewModel.getlogindoc(mail).observe(RemoveDoctorActivity.this, new Observer<List<Doctor>>() {
                    @Override
                    public void onChanged(List<Doctor> doctors) {
                        if(doctors.size()==0){
                            Toast.makeText(RemoveDoctorActivity.this,"Please check your email again!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent(RemoveDoctorActivity.this,RemoveDoctorFinalActivity.class);
                            intent.putExtra("FName",doctors.get(0).getFirst_names());
                            intent.putExtra("LName",doctors.get(0).getLast_name());
                            intent.putExtra("Email",doctors.get(0).getEmail_id());
                            intent.putExtra("Branch",doctors.get(0).getBranch());
                            intent.putExtra("Gender",doctors.get(0).getGender());
                            intent.putExtra("Password",doctors.get(0).getPassword());
                            intent.putExtra("RePassword",doctors.get(0).getRe_password());
                            intent.putExtra("Age",doctors.get(0).getAge());
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }
}