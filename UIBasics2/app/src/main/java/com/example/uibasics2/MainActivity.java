package com.example.uibasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnBtnClick(View view){
        TextView textView = findViewById(R.id.txtView);
        EditText editText = findViewById(R.id.txtEdit);
        Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show();
        textView.setText("Hello "+editText.getText().toString());




    }
}