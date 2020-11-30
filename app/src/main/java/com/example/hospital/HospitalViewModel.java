package com.example.hospital;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HospitalViewModel extends AndroidViewModel {

    private HospitalRepository repository;
    private LiveData<List<User>> login;
    private LiveData<List<Doctor>> logindr;
    private  LiveData<List<Doctor>> listdr;
    private LiveData<List<Integer>> dayid;
    private LiveData<List<Integer>> slotid;
    //private LiveData<List<String>> slotname;
   // private LiveData<List<User>> alluser;
    private LiveData<List<Integer>>slot_id;
    private LiveData<List<BookingSummary>> booking;
    private LiveData<List<BookingSummary>> bookingdr;
    private LiveData<List<BookingSummary>> bookinguser;

    public HospitalViewModel(@NonNull Application application) {
        super(application);
        repository = new HospitalRepository(application);
    }

    public LiveData<List<User>> getLogin(String mail){
        login = repository.getLogin(mail);
        return login;
    }

    /*public LiveData<List<User>> getAlluser(){
        alluser = repository.getAlluser();
        return alluser;
    }*/

    public void insert_user(User user){

        repository.insert_user(user);
    }

    public LiveData<List<Doctor>> getlogindoc(String email){
        logindr = repository.getlogindoc(email);
        return logindr;
    }

    public void insert_doc(Doctor doctor) {
        repository.insert_doc(doctor);

    }

    public LiveData<List<Doctor>> getdoc(){
        listdr = repository.getdoc();
        return listdr;
    }

    public void delete_doctor(Doctor doctor){
        repository.delete_doctor(doctor);
    }

    public void update_user(User user){
        repository.update_user(user);
    }

    public LiveData<List<Integer>> getDayid(String weekday){
        dayid = repository.getDayid(weekday);
        return dayid;
    }

    public LiveData<List<Integer>> getSlotid(String mail,int dayid){
        slotid = repository.getSlotid(mail,dayid);
        return slotid;
    }

    /*public LiveData<List<String>> getSlotname(int slotid){
        slotname = repository.getSlotname(slotid);
        return slotname;
    }*/

    public void insert_bookingdetails(BookingSummary bookingSummary){
        repository.insert_bookingdetails(bookingSummary);
    }

    public void insert_intermediate(Intermediate intermediate){
        repository.insert_intermediate(intermediate);
    }


    public LiveData<List<Integer>>getSlot_id(String slot){
        slot_id = repository.getSlot_id(slot);
        return slot_id;
    }

    public  LiveData<List<BookingSummary>> getbookingdetails(){
        booking = repository.getbookingdetails();
        return booking;

    }

    public LiveData<List<BookingSummary>> getdocbookingdetails(String name){
        bookingdr = repository.getdocbookingdetails(name);
        return bookingdr;
    }

    public LiveData<List<BookingSummary>> getuserbookingdetails(String user){
        bookinguser = repository.getuserbookingdetails(user);
        return  bookinguser;
    }
}
