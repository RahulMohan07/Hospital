package com.example.hospital;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Slot {
    @NonNull
    @PrimaryKey
    private int slot_id;

    private String slot_name;

    public Slot(int slot_id, String slot_name) {
        this.slot_id = slot_id;
        this.slot_name = slot_name;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public String getSlot_name() {
        return slot_name;
    }
}
