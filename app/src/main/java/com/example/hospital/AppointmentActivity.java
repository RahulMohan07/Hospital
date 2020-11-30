package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

public class AppointmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HospitalViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final AppointmentAdapter adapter = new AppointmentAdapter(this);
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