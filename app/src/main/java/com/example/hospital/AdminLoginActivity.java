package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText1,editText2;
    private TextView textView;
    private Button button;
    private String adminId = "medipaladmin";
    private String adminPassword = "12345abcde";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        imageView = findViewById(R.id.adminimg);
        editText1 = findViewById(R.id.adminlogin);
        editText2 = findViewById(R.id.adminpass);
        textView = findViewById(R.id.trademark);
        button = findViewById(R.id.logbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username,password;
                username = editText1.getText().toString().trim();
                password = editText2.getText().toString().trim();
                if(username.equals("")||password.equals("")){
                    Toast.makeText(AdminLoginActivity.this,"Please enter all the fields",Toast.LENGTH_LONG).show();
                }
                else {
                    if (username.equals(adminId) && password.equals(adminPassword)) {
                        Toast.makeText(AdminLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdminLoginActivity.this,AdminMainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(AdminLoginActivity.this,"Invalid User Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}