package com.example.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view) {
        TextView txtFirstName = findViewById(R.id.txtMessage1);
        EditText edtFirstName = findViewById(R.id.edtTxtFirstName);
        txtFirstName.setText("First Name -"+edtFirstName.getText().toString());
        TextView txtLastName = findViewById(R.id.txtMessage2);
        EditText edtLastName = findViewById(R.id.edtTxtLastName);
        txtLastName.setText("Last Name -"+edtLastName.getText().toString());
        TextView txtEmailId = findViewById(R.id.txtMessage3);
        EditText edtEmailId = findViewById(R.id.edtTxtEmailId);
        txtEmailId.setText("Email id -"+edtEmailId.getText().toString());

    }
}