package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText editText1,editText2,editText3,editText4,editText5,age;
    private Button button;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private HospitalViewModel hospitalViewModel;
    private RelativeLayout layout;
    private boolean notExists = false;
    private HospitalRepository hospitalRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText1 = findViewById(R.id.FirstName);
        editText2 = findViewById(R.id.LastName);
        editText3 = findViewById(R.id.EamilId);
        editText4 = findViewById(R.id.Password);
        editText5 = findViewById(R.id.RePassword);
        button = findViewById(R.id.Register);
        age = findViewById(R.id.Age);
        layout = findViewById(R.id.parent);

        radioGroup = findViewById(R.id.RgGroup);



        hospitalViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        hospitalRepository = new HospitalRepository(getApplication());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fname, lname, email, password, repassword, gender;
                final int age1;
                notExists = false;

                fname = editText1.getText().toString().trim();
                lname = editText2.getText().toString().trim();
                email = editText3.getText().toString().trim();
                password = editText4.getText().toString().trim();
                repassword = editText5.getText().toString().trim();
                age1 = Integer.parseInt(age.getText().toString());
                int selectid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectid);
                gender = radioButton.getText().toString().trim();
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        List<User>users = hospitalRepository.getAlluser();
                        for(User u: users){
                            if(u.getEmail_id().equals(email)){
                                notExists = true;
                                break;
                            }
                        }

                        if (notExists) {
                            RegisterActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,"Account already exists", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        else {
                            if (fname.equals("") || lname.equals("") || email.equals("") || password.equals("") || repassword.equals("")) {
                                RegisterActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                if (password.equals(repassword)) {
                                    hospitalViewModel.insert_user(new User(email, fname, lname, password, gender, repassword, age1));
                                    editText1.getText().clear();
                                    editText2.getText().clear();
                                    editText3.getText().clear();
                                    editText4.getText().clear();
                                    editText5.getText().clear();
                                    age.getText().clear();
                                    Intent intent = new Intent(RegisterActivity.this,AccountActivity.class);
                                    intent.putExtra("Username",email);
                                    intent.putExtra("Name",fname);
                                    startActivity(intent);
                                    RegisterActivity.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            showSnackbar();
                                        }
                                    });


                                } else {
                                    RegisterActivity.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            showSnackbar1();
                                        }
                                    });

                                }
                            }
                        }

                    }
                });




            }
        });
    }

    private void showSnackbar() {
        Snackbar.make(layout, "Registered Successfully", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(RegisterActivity.this, "Close Clicked", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(RegisterActivity.this, "Close Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .setTextColor(Color.RED)
                .show();


    }
}