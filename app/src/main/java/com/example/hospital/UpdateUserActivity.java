package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.hospital.AccountActivity.EMAILID;

public class UpdateUserActivity extends AppCompatActivity {

    private TextView firstname,lastname,age;
    private EditText editfirst,editlast,editage;
    private Button button;
    private HospitalViewModel hospitalViewModel;
    String gender,pass,repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        age = findViewById(R.id.age);
        editfirst = findViewById(R.id.editfirstname);
        editlast = findViewById(R.id.editlastname);
        editage = findViewById(R.id.editage);
        button = findViewById(R.id.updatebutton);


        hospitalViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        hospitalViewModel.getLogin(EMAILID).observe(UpdateUserActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                  gender = users.get(0).getGender();
                  pass = users.get(0).getPassword();
                  repass = users.get(0).getRepassword();
                  editfirst.setText(users.get(0).getFirst_name());
                  editlast.setText(users.get(0).getLast_name());
                  editage.setText(""+users.get(0).getAge());

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fname, lname;
                final int age;

                fname = editfirst.getText().toString().trim();
                lname = editlast.getText().toString().trim();
                age = Integer.parseInt(editage.getText().toString());

                if (fname.equals("") || lname.equals("") ){
                    Toast.makeText(UpdateUserActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    hospitalViewModel.update_user(new User(EMAILID,fname,lname,pass,gender,repass,age));
                    finish();
                }
            }
        });

    }
}