package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(foreignKeys = {@ForeignKey(entity = Doctor.class, parentColumns = "email_id", childColumns = "email_id"),
@ForeignKey(entity = Day.class, parentColumns = "day_id",childColumns = "day_id"),
@ForeignKey(entity = Slot.class, parentColumns = "slot_id",childColumns = "slot_id")},
primaryKeys = {"email_id","day_id","slot_id"})
public class Intermediate {
    @NonNull
    private String email_id;
    private int day_id;
    private int slot_id;

    public Intermediate(String email_id, int day_id, int slot_id) {
        this.email_id = email_id;
        this.day_id = day_id;
        this.slot_id = slot_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public int getDay_id() {
        return day_id;
    }

    public int getSlot_id() {
        return slot_id;
    }
}
