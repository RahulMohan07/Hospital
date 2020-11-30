package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BookingSummary {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int booking_id;

    private String user_id;
    private String dr_id;
    private String dr_fname;
    private String dr_lname;
    private String day;
    private String slot;

    public BookingSummary(String user_id, String dr_id, String dr_fname, String dr_lname, String day, String slot) {
        this.user_id = user_id;
        this.dr_id = dr_id;
        this.dr_fname = dr_fname;
        this.dr_lname = dr_lname;
        this.day = day;
        this.slot = slot;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getDr_id() {
        return dr_id;
    }

    public String getDr_fname() {
        return dr_fname;
    }

    public String getDr_lname() {
        return dr_lname;
    }

    public String getDay() {
        return day;
    }

    public String getSlot() {
        return slot;
    }
}
