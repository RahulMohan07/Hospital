package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EditAppointmentActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private HospitalViewModel hospitalViewModel;
    private HospitalRepository hospitalRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appointment);

        editText = findViewById(R.id.dayname);
        button = findViewById(R.id.removebtn);

        final String email = getIntent().getStringExtra("mail");


        hospitalViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        hospitalRepository = new HospitalRepository(getApplication());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {

                        String day;
                        int id=0;
                        day = editText.getText().toString().trim();

                        if(day.equals("Monday"))
                            id = 1;
                        else if(day.equals("Tuesday"))
                            id = 2;
                        else if(day.equals("Wednesday"))
                            id = 3;
                        else if(day.equals("Thursday"))
                            id = 4;
                        else if(day.equals("Friday"))
                            id = 5;
                        else if(day.equals("Saturday"))
                            id = 6;
                        else if(day.equals("Sunday"))
                            id = 7;

                        List<BookingSummary> bookingSummaries = hospitalRepository.getupdatedetails(email,day);

                        for (BookingSummary bs:bookingSummaries) {
                            bs.setBookingstatus("DONE");
                            hospitalViewModel.update_bookingsummary(bs);
                        }

                        List<Intermediate> intermediates = hospitalRepository.getIntermediate(email,id);
                        if(intermediates.size()>0){
                            for (Intermediate i: intermediates)
                            {
                                hospitalViewModel.delete_intermediate(i);
                            }
                            EditAppointmentActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(EditAppointmentActivity.this, "YOU CAN GO HOME PEACE", Toast.LENGTH_SHORT).show();

                                }
                            });
                            finish();

                        }
                        else
                        {
                            EditAppointmentActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(EditAppointmentActivity.this, "You have failed successfully", Toast.LENGTH_SHORT).show();

                                }
                            });

                        }


                    }


                });



            }
        });
    }
}