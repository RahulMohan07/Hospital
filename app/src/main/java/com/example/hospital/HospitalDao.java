package com.example.hospital;

import android.widget.Spinner;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HospitalDao {
    @Insert
    void insert_user(User user);

    @Insert
    void insert_doc(Doctor doctor);

    @Query("SELECT * FROM User WHERE email_id=:mail")
    LiveData<List<User>> getlogin(String mail);

    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Query("SELECT  * FROM Doctor WHERE email_id =:email")
    LiveData<List<Doctor>> getlogindoc(String email);

    @Query("SELECT * FROM Doctor")
    LiveData<List<Doctor>> getdoc();

    @Delete
    void delete_doctor(Doctor doctor);

    @Update
    void update_user(User user);

    @Insert
    void insert_day(Day day);

    @Insert
    void insert_slot(Slot slot);

    @Insert
    void insert_intermediate(Intermediate intermediate);

    @Query("SELECT day_id FROM Day WHERE day_name =:weekday")
    LiveData<List<Integer>> getdayid(String weekday);

    @Query("SELECT slot_id FROM Intermediate WHERE email_id =:email AND day_id =:dayid ")
    LiveData<List<Integer>> getslotid(String email, int dayid);

    @Query("SELECT slot_name FROM Slot WHERE slot_id =:slotid")
    List<String> getslotname(int slotid);

    @Insert
    void insert_bookingdetails(BookingSummary bookingSummary);

    @Query("SELECT slot_id FROM Slot WHERE slot_name =:slot")
    LiveData<List<Integer>> getslot_id(String slot);

    @Query("SELECT * FROM BookingSummary")
    LiveData<List<BookingSummary>> getbookingdetails();

    @Query("SELECT * FROM BookingSummary WHERE dr_id =:name")
    LiveData<List<BookingSummary>> getdocbookingdetails(String name);

    @Query("SELECT * FROM BookingSummary WHERE user_id =:user")
    LiveData<List<BookingSummary>> getuserbookingdetails(String user);


}
