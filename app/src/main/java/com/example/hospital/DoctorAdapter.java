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

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorHolder> {

    private List<Doctor> doctors = new ArrayList<>();


    @NonNull
    @Override
    public DoctorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctors_list, parent, false);
        return new DoctorHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorHolder holder, int position) {
        Doctor currentDoctor = doctors.get(position);

        holder.textView1.setText("First Name: "+currentDoctor.getFirst_names());
        holder.textView2.setText("Last Name: "+currentDoctor.getLast_name());
        holder.textView3.setText("Department: "+currentDoctor.getBranch());
        holder.textView4.setText("Age: "+currentDoctor.getAge());
        holder.textView5.setText("Gender: "+currentDoctor.getGender());


    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public void getDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
        notifyDataSetChanged();
    }

    static class DoctorHolder extends RecyclerView.ViewHolder{
        private TextView textView1,textView2,textView3,textView4,textView5;


        public DoctorHolder(@NonNull View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.drfname);
            textView2 = itemView.findViewById(R.id.drlname);
            textView3 = itemView.findViewById(R.id.drdept);
            textView4 = itemView.findViewById(R.id.drage);
            textView5 = itemView.findViewById(R.id.drgender);

        }
    }
}
