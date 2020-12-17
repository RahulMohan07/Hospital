package com.example.hospital;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppointmentAdminAdapter extends RecyclerView.Adapter<AppointmentAdminAdapter.AppointmentAdminHolder> {


    private List<BookingSummary> bookingSummaries = new ArrayList<>();


    @NonNull
    @Override
    public AppointmentAdminHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointment_admin_display_list, parent, false);
        return new AppointmentAdminHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdminHolder holder, int position) {

        BookingSummary currentBooking = bookingSummaries.get(position);
        holder.textView1.setText("BOOKING ID: "+ String.valueOf(currentBooking.getBooking_id()));
        holder.textView2.setText("DOCTOR: "+currentBooking.getDr_fname()+" "+currentBooking.getDr_lname());
        holder.textView3.setText("PATIENT: "+currentBooking.getUser_id());
        holder.textView4.setText("DAY: "+currentBooking.getDay());
        holder.textView5.setText("SLOT: "+currentBooking.getSlot());
        holder.textView6.setText("BOOKING STATUS: "+currentBooking.getBookingstatus());


    }

    @Override
    public int getItemCount() {
        return bookingSummaries.size();
    }

    public void getBookingDetails(List<BookingSummary> bookingSummaries) {
        this.bookingSummaries = bookingSummaries;
        notifyDataSetChanged();
    }

    static class AppointmentAdminHolder extends RecyclerView.ViewHolder{
        private TextView textView1,textView2,textView3,textView4,textView5,textView6;


        public AppointmentAdminHolder(@NonNull View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.bid);
            textView2 = itemView.findViewById(R.id.drname);
            textView3 = itemView.findViewById(R.id.patientname);
            textView4 = itemView.findViewById(R.id.day);
            textView5 = itemView.findViewById(R.id.slot);
            textView6 = itemView.findViewById(R.id.bs);

        }
    }
}
