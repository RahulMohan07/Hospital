package com.example.uibasics3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxHarry, checkBoxMatrix, checkBoxJoker;
    private RadioGroup radioGroup;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkBoxMatrix = findViewById(R.id.checkboxMatrix);
        checkBoxJoker = findViewById(R.id.checkboxJoker);
        radioGroup = findViewById(R.id.rhbuttons);
        progressBar = findViewById(R.id.progressbar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<10;i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();

        int checkedButton = radioGroup.getCheckedRadioButtonId();
        switch (checkedButton){
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this,"Married",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this,"Single",Toast.LENGTH_SHORT).show();

                break;
            case R.id.rbRelationship:
                Toast.makeText(MainActivity.this,"Relationship",Toast.LENGTH_SHORT).show();

                break;
            default:
                break;

        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this,"Married",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this,"Single",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.rbRelationship:
                        Toast.makeText(MainActivity.this,"Relationship",Toast.LENGTH_SHORT).show();

                        break;
                    default:
                        break;
                }
            }
        });

        if(checkBoxHarry.isChecked()){
            Toast.makeText(MainActivity.this,"You have watched Harry Potter",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"You haven't watched Harry Potter",Toast.LENGTH_SHORT).show();

        }


        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this,"You have watched Harry Potter",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"You haven't watched Harry Potter",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
