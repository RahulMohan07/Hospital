package com.example.hospital;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.hospital.AccountActivity.EMAILID;

public class AppointmentBookingActivity extends AppCompatActivity {

    private TextView textView,textView1,textView2;
    private Spinner spinner,spinner1;
    private Button button;
    private HospitalViewModel hospitalViewModel;
    private HospitalRepository hospitalRepository;
    private String selected;
    private String slot_selected;
    private int id;
    private int slot_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_booking);

        textView = findViewById(R.id.txtTitle);
        textView1 = findViewById(R.id.daysid);
        textView2 = findViewById(R.id.slotid);
        spinner = findViewById(R.id.daysspinner);
        spinner1 = findViewById(R.id.slotspinner);
        button = findViewById(R.id.bookbtn);
        final String email = getIntent().getStringExtra("Email_id");
        final String name1 = getIntent().getStringExtra("FName");
        final String name2 = getIntent().getStringExtra("LName");
        textView.setText("Booking for Dr. "+name1+" "+name2);

        final ArrayList<String> days = new ArrayList<>();
        
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        ArrayAdapter<String> daysadapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,days);
        spinner.setAdapter(daysadapter);



        hospitalViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(HospitalViewModel.class);
        hospitalRepository = new HospitalRepository(getApplication());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                final ArrayList<String> availslots = new ArrayList<>();
                selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(AppointmentBookingActivity.this,selected +" Selected",Toast.LENGTH_SHORT).show();

                hospitalViewModel.getDayid(selected).observe(AppointmentBookingActivity.this, new Observer<List<Integer>>() {
                    @Override
                    public void onChanged(List<Integer> integers_day) {

                        final ArrayList<Integer> slots = new ArrayList<>();
                        slots.add(1);
                        slots.add(2);
                        slots.add(3);
                        slots.add(4);
                        slots.add(5);
                        slots.add(6);
                        slots.add(7);
                        slots.add(8);
                        slots.add(9);

                        id = integers_day.get(0);



                        hospitalViewModel.getSlotid(email,id).observe(AppointmentBookingActivity.this, new Observer<List<Integer>>() {
                            @Override
                            public void onChanged(List<Integer> integers_slot) {
                                for (Integer i :integers_slot) {
                                    slots.remove(i);
                                }
                                availslots.add("Select Time");
                                AsyncTask.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        for (Integer i: slots) {
                                            List<String> temp = hospitalRepository.getSlotname(i);
                                            availslots.add(temp.get(0));


                                        }

                                    }
                                });



                                ArrayAdapter<String> slotsadapter = new ArrayAdapter<>(AppointmentBookingActivity.this,android.R.layout.simple_spinner_dropdown_item,availslots);

                                spinner1.setAdapter(slotsadapter);
                                textView2.setVisibility(View.VISIBLE);
                                spinner1.setVisibility(View.VISIBLE);


                            }
                        });


                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                slot_selected = adapterView.getItemAtPosition(i).toString();
                hospitalViewModel.getSlot_id(slot_selected).observe(AppointmentBookingActivity.this, new Observer<List<Integer>>() {
                    @Override
                    public void onChanged(List<Integer> integers) {
                        if(integers.size()>0){
                            slot_id = integers.get(0);
                        }

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(AppointmentBookingActivity.this).create();
                alertDialog.setTitle("Booking Confirmation");
                alertDialog.setMessage("Dr."+name1+" "+name2+"\n"
                        +"Day: "+selected+"\n"
                        +"Slot: "+slot_selected+"\n"
                        +"Email: "+EMAILID);
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        hospitalViewModel.insert_bookingdetails(new BookingSummary(EMAILID,email,name1,name2,selected,slot_selected,"BOOKED"));
                        hospitalViewModel.insert_intermediate(new Intermediate(email,id,slot_id));
                        Toast.makeText(AppointmentBookingActivity.this,"Booking Successful",Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "RETURN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                /*alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });*/
                alertDialog.setCancelable(false);
                alertDialog.show();
            }
        });




    }
}