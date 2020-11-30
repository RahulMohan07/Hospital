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

public class LoginActivity extends AppCompatActivity {

    private EditText editText1,editText2;
    private Button button;
    private HospitalViewModel hospitalViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = findViewById(R.id.emailid);
        editText2 = findViewById(R.id.password);
        button = findViewById(R.id.login);

        hospitalViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mail,password;
                mail = editText1.getText().toString().trim();
                password = editText2.getText().toString().trim();
                hospitalViewModel.getLogin(mail).observe(LoginActivity.this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        if (users.size()==0){
                            Toast.makeText(LoginActivity.this,"Please check your email again!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if(password.equals(users.get(0).getRepassword())){
                                Intent intent = new Intent(LoginActivity.this,AccountActivity.class);
                                intent.putExtra("Name", users.get(0).getFirst_name());
                                intent.putExtra("Email",users.get(0).getEmail_id());
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(LoginActivity.this,"Please check your Password again!",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });

            }
        });
    }
}