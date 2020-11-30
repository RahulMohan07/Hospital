package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class AddDoctorActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7;
    private Button button;
    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private HospitalViewModel hospitalViewModel;
    private RelativeLayout layout;
    private boolean notExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        imageView = findViewById(R.id.docidpic);
        editText1 = findViewById(R.id.FirstName);
        editText2 = findViewById(R.id.LastName);
        editText3 = findViewById(R.id.EamilId);
        editText4 = findViewById(R.id.Password);
        editText5 = findViewById(R.id.RePassword);
        editText6 = findViewById(R.id.Age);
        editText7 = findViewById(R.id.branch);
        textView = findViewById(R.id.txt);
        button = findViewById(R.id.Register);
        layout = findViewById(R.id.parent);
        radioGroup = findViewById(R.id.RgGroup);


        hospitalViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fname, lname, email, password, repassoword, branch, gender;
                final int age;
                notExists = false;

                fname = editText1.getText().toString().trim();
                lname = editText2.getText().toString().trim();
                email = editText3.getText().toString().trim();
                password = editText4.getText().toString().trim();
                repassoword = editText5.getText().toString().trim();
                branch = editText7.getText().toString().trim();
                age = Integer.parseInt(editText6.getText().toString());
                int selectid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectid);
                gender = radioButton.getText().toString().trim();

                hospitalViewModel.getlogindoc(email).observe(AddDoctorActivity.this, new Observer<List<Doctor>>() {
                    @Override
                    public void onChanged(List<Doctor> doctors) {
                        for (Doctor d : doctors) {
                            if (d.getEmail_id().equals(email)) {
                                notExists = true;
                                break;
                            }
                        }
                    }
                });

                if (notExists) {
                    Toast.makeText(AddDoctorActivity.this, "Account already exists", Toast.LENGTH_SHORT).show();
                } else {
                    if (fname.equals("") || lname.equals("") || email.equals("") || password.equals("") || repassoword.equals("")|| branch.equals("")) {
                        Toast.makeText(AddDoctorActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    } else {
                        if (password.equals(repassoword)) {
                            hospitalViewModel.insert_doc(new Doctor(email, fname, lname, gender, password, repassoword, branch, age));
                            editText1.getText().clear();
                            editText2.getText().clear();
                            editText3.getText().clear();
                            editText4.getText().clear();
                            editText5.getText().clear();
                            editText6.getText().clear();
                            editText7.getText().clear();
                            showSnackbar();
                        } else {
                            showSnackbar1();
                        }
                    }
                }
            }
        });
    }

    private void showSnackbar() {
        Snackbar.make(layout, "Registered Successfully", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AddDoctorActivity.this, "Close Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .setTextColor(Color.RED)
                .show();

    }

    private void showSnackbar1() {
        Snackbar.make(layout, "WARNING Fill all the fields", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AddDoctorActivity.this, "Close Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .setTextColor(Color.RED)
                .show();


    }
}