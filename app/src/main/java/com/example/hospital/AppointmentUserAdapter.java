package com.example.hospital;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppointmentUserAdapter extends RecyclerView.Adapter<AppointmentUserAdapter.AppointmentUserHolder> {

    private List<BookingSummary> bookingSummaries = new ArrayList<>();

    @NonNull
    @Override
    public AppointmentUserAdapter.AppointmentUserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointment_user_display, parent, false);
        return new AppointmentUserAdapter.AppointmentUserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentUserAdapter.AppointmentUserHolder holder, int position) {

        BookingSummary currentBooking = bookingSummaries.get(position);

        holder.textView2.setText("DOCTOR: "+currentBooking.getDr_fname()+" "+currentBooking.getDr_lname());
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

    static class AppointmentUserHolder extends RecyclerView.ViewHolder{
        private TextView textView2,textView3,textView4,textView5;


        public AppointmentUserHolder(@NonNull View itemView){
            super(itemView);

            textView2 = itemView.findViewById(R.id.drname);
            textView3 = itemView.findViewById(R.id.day);
            textView4 = itemView.findViewById(R.id.slot);
            textView5 = itemView.findViewById(R.id.bid);

        }
    }

}
