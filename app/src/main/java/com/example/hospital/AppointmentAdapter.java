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

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentHolder> {

    private List<Doctor> doctors = new ArrayList<>();
    private Context mContext;

    public AppointmentAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public AppointmentAdapter.AppointmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointment_bookinglist, parent, false);
        return new AppointmentAdapter.AppointmentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.AppointmentHolder holder, int position) {
        final Doctor currentDoctor = doctors.get(position);

        holder.textView1.setText("Name: "+currentDoctor.getFirst_names()+" "+currentDoctor.getLast_name());
        holder.textView2.setText("Department: "+currentDoctor.getBranch());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AppointmentBookingActivity.class);
                intent.putExtra("Email_id",currentDoctor.getEmail_id());
                intent.putExtra("FName",currentDoctor.getFirst_names());
                intent.putExtra("LName",currentDoctor.getLast_name());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public void getDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
        notifyDataSetChanged();
    }



    static class AppointmentHolder extends RecyclerView.ViewHolder{
        private TextView textView1,textView2;
        private CardView parent;

        public AppointmentHolder(@NonNull View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.drname);
            textView2 = itemView.findViewById(R.id.drdept);
            parent = itemView.findViewById(R.id.parent);

        }
    }

}
