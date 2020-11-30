package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Day {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int day_id;

    private String day_name;

    public Day( String day_name) {
        this.day_name = day_name;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    public int getDay_id() {
        return day_id;
    }

    public String getDay_name() {
        return day_name;
    }
}
