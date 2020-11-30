package com.example.registrationchallenege;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText1, editText2, editText3, editText4;
    private Button btntext, btnreg;
    private RadioGroup radioGroup;
    private TextView agreement, sex, country;
    private CheckBox checkBox;
    private Spinner spinner;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.txtImage);
        btntext = findViewById(R.id.btntxt);
        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextLastName);
        editText3 = findViewById(R.id.editTextPassword);
        editText4 = findViewById(R.id.editTextrepassword);
        sex = findViewById(R.id.gender);
        radioGroup = findViewById(R.id.rgroup);
        agreement = findViewById(R.id.agreement);
        checkBox = findViewById(R.id.cbox);
        country = findViewById(R.id.country);
        spinner = findViewById(R.id.countryspinner);
        btnreg = findViewById(R.id.btnregister);
        layout = findViewById(R.id.parent);





        final ArrayList<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("U.A.E");
        countries.add("France");
        countries.add("Spain");


        ArrayAdapter<String> studentsadapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,countries);
        spinner.setAdapter(studentsadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,countries.get(i)+" Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Image selected",Toast.LENGTH_SHORT).show();
            }
        });



        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = editText1.getText().toString();
                String y = editText2.getText().toString();
                String z = editText3.getText().toString();
                String w = editText4.getText().toString();
                boolean notEmpty = true;
                boolean isCheck = false;
                boolean isEqual = false;
                if(x.equals("")||y.equals("")||z.equals("")||w.equals("")){
                    notEmpty = false;
                }
                if (checkBox.isChecked()){
                    isCheck=true;
                }
                if (w.equals(z)){
                    isEqual = true;
                }
                if (notEmpty&&isCheck&&isEqual){
                    showSnackbar();
                }
                else {
                    showSnackbar1();
                }

            }
        });


    }

    private void showSnackbar() {
        Snackbar.make(layout, "Registered Successfully", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Close Clicked", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainActivity.this, "Close Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .setTextColor(Color.RED)
                .show();


    }

}
