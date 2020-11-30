package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class DisplayDoctorActivity extends AppCompatActivity {

    private TextView textView;
    private RecyclerView recyclerView;
    private HospitalViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_doctor);

        textView = findViewById(R.id.txtTitle);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final DoctorAdapter adapter = new DoctorAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        viewModel.getdoc().observe(this, new Observer<List<Doctor>>() {
            @Override
            public void onChanged(List<Doctor> doctors) {
                adapter.getDoctors(doctors);
            }
        });





    }
}