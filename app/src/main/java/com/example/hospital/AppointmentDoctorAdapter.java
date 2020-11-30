package com.example.hospital;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDoctorAdapter extends RecyclerView.Adapter<AppointmentDoctorAdapter.AppointmentDoctorHolder> {

    private List<BookingSummary> bookingSummaries = new ArrayList<>();

    @NonNull
    @Override
    public AppointmentDoctorAdapter.AppointmentDoctorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointment_doctor_display, parent, false);
        return new AppointmentDoctorAdapter.AppointmentDoctorHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentDoctorAdapter.AppointmentDoctorHolder holder, int position) {

        BookingSummary currentBooking = bookingSummaries.get(position);

        holder.textView2.setText("PATIENT: "+currentBooking.getUser_id());
        holder.textView3.setText("DAY: "+currentBooking.getDay());
        holder.textView4.setText("SLOT: "+currentBooking.getSlot());
        holder.textView5.setText("BOOKING ID: "+currentBooking.getBooking_id());

    }

    @Override
    public int getItemCount() {
        return bookingSummaries.size();
    }

    public void getBookingDetails(List<BookingSummary> bookingSummaries) {
        this.bookingSummaries = bookingSummaries;
        notifyDataSetChanged();
    }

    static class AppointmentDoctorHolder extends RecyclerView.ViewHolder{
        private TextView textView2,textView3,textView4,textView5;


        public AppointmentDoctorHolder(@NonNull View itemView){
            super(itemView);

            textView2 = itemView.findViewById(R.id.patientname);
            textView3 = itemView.findViewById(R.id.day);
            textView4 = itemView.findViewById(R.id.slot);
            textView5 = itemView.findViewById(R.id.bid);

        }
    }

}
