package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Doctor {
    @NonNull
    @PrimaryKey
    private String email_id;

    private String first_names,last_name,gender,password,re_password,branch;
    private int age;

    public Doctor(String email_id, String first_names, String last_name, String gender, String password, String re_password, String branch, int age) {
        this.email_id = email_id;
        this.first_names = first_names;
        this.last_name = last_name;
        this.gender = gender;
        this.password = password;
        this.re_password = re_password;
        this.branch = branch;
        this.age = age;
    }


    public String getEmail_id() {
        return email_id;
    }

    public String getFirst_names() {
        return first_names;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getRe_password() {
        return re_password;
    }

    public String getBranch() {
        return branch;
    }

    public int getAge() {
        return age;
    }
}
