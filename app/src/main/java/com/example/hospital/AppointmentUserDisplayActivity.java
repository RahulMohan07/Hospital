package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import static com.example.hospital.AccountActivity.EMAILID;

public class AppointmentUserDisplayActivity extends AppCompatActivity {

    private TextView textView;
    private HospitalViewModel hospitalViewModel;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_user_display);

        textView = findViewById((R.id.txtTitle));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final AppointmentUserAdapter adapter = new AppointmentUserAdapter();
        recyclerView.setAdapter(adapter);

        hospitalViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        hospitalViewModel.getuserbookingdetails(EMAILID).observe(this, new Observer<List<BookingSummary>>() {
            @Override
            public void onChanged(List<BookingSummary> bookingSummaries) {
                adapter.getBookingDetails(bookingSummaries);
            }
        });

    }
}