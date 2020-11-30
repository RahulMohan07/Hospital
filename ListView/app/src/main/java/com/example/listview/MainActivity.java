package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.citylist);
        spinner  = findViewById(R.id.studentspinner);

        final ArrayList<String> students = new ArrayList<>();
        students.add("Rahul");
        students.add("Regish");
        students.add("Anisha");

        ArrayAdapter<String> studentsadapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,students);
        spinner.setAdapter(studentsadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,students.get(i)+" Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final ArrayList<String> cities = new ArrayList<>();
        cities.add("Madrid");
        cities.add("Lisbon");
        cities.add("New York");
        cities.add("Bnagalore");
        cities.add("Paris");
        ArrayAdapter<String> citiesadapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cities);

        listView.setAdapter(citiesadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,cities.get(i)+"Selected",Toast.LENGTH_SHORT).show();
            }
        });

    }
}