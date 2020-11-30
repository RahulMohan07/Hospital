package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class AppointmentDoctorDisplayActivity extends AppCompatActivity {

    private TextView textView;
    private HospitalViewModel hospitalViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_doctor_display);


        textView = findViewById((R.id.txtTitle));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        String mail = getIntent().getStringExtra("mail_id");

        final AppointmentDoctorAdapter adapter = new AppointmentDoctorAdapter();
        recyclerView.setAdapter(adapter);

        hospitalViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        hospitalViewModel.getdocbookingdetails(mail).observe(this, new Observer<List<BookingSummary>>() {
            @Override
            public void onChanged(List<BookingSummary> bookingSummaries) {
                adapter.getBookingDetails(bookingSummaries);
            }
        });


    }
}