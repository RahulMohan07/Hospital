package com.example.hospital;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;
import androidx.room.Delete;

import java.util.List;


public class HospitalRepository {
    private HospitalDao hospitalDao;
    private LiveData<List<User>> login;
    private LiveData<List<Doctor>> logindr;
    private LiveData<List<Doctor>>listdr;
    private LiveData<List<Integer>>dayid;
    private LiveData<List<Integer>>slotid;
    private List<String>slotname;
    private List<User> alluser;
    private LiveData<List<Integer>>slot_id;
    private LiveData<List<BookingSummary>> booking;
    private LiveData<List<BookingSummary>> bookingdr;
    private LiveData<List<BookingSummary>> bookinguser;

    public HospitalRepository(Application application){
        HospitalDatabase database = HospitalDatabase.getInstance(application);
        hospitalDao = database.hospitalDao();
    }

    public void insert_user(User user){

        new InsertUserAsyncTask(hospitalDao).execute(user);
    }

    public  LiveData<List<User>> getLogin(String mail){
        login = hospitalDao.getlogin(mail);
        return login;

    }

    public List<User> getAlluser(){
        alluser = hospitalDao.getAllUsers();
        return alluser;
    }

    public void insert_doc(Doctor doctor){

        new InsertDoctorAsyncTask(hospitalDao).execute(doctor);
    }

    public LiveData<List<Doctor>> getlogindoc(String email){
        logindr = hospitalDao.getlogindoc(email);
        return logindr;
    }



    public LiveData<List<Doctor>> getdoc(){
        listdr = hospitalDao.getdoc();
        return listdr;
    }

    public void delete_doctor(Doctor doctor){
        new DeleteDoctorAsyncTask(hospitalDao).execute(doctor);
    }

    public void update_user(User user){
        new UpdateUserAsyncTask(hospitalDao).execute(user);
    }

    public LiveData<List<Integer>> getDayid(String weekday){
        dayid = hospitalDao.getdayid(weekday);
        return dayid;
    }

    public LiveData<List<Integer>> getSlotid(String mail,int dayid){
        slotid = hospitalDao.getslotid(mail,dayid);
        return slotid;
    }

    public List<String> getSlotname(int slotid){
        slotname = hospitalDao.getslotname(slotid);
        return slotname;
    }





    private static class InsertUserAsyncTask extends AsyncTask<User,Void,Void> {
        private HospitalDao hospitalDao;

        private InsertUserAsyncTask(HospitalDao hospitalDao){

            this.hospitalDao = hospitalDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            hospitalDao.insert_user(users[0]);
            return null;
        }


    }

    private static class InsertDoctorAsyncTask extends AsyncTask<Doctor,Void,Void>{
        private HospitalDao hospitalDao;

        private InsertDoctorAsyncTask(HospitalDao hospitalDao){
            this.hospitalDao = hospitalDao;
        }


        @Override
        protected Void doInBackground(Doctor... doctors) {
            hospitalDao.insert_doc(doctors[0]);
            return null;
        }
    }

    private static class DeleteDoctorAsyncTask extends AsyncTask<Doctor,Void,Void> {
        private HospitalDao hospitalDao;

        private DeleteDoctorAsyncTask(HospitalDao hospitalDao){

            this.hospitalDao = hospitalDao;
        }

        @Override
        protected Void doInBackground(Doctor... doctors) {
            hospitalDao.delete_doctor(doctors[0]);
            return null;
        }


    }

    private static class UpdateUserAsyncTask extends AsyncTask<User,Void,Void> {
        private HospitalDao hospitalDao;

        private UpdateUserAsyncTask(HospitalDao hospitalDao){

            this.hospitalDao = hospitalDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            hospitalDao.update_user(users[0]);
            return null;
        }


    }

    public void insert_bookingdetails(BookingSummary bookingSummary){
        new InsertBookingDetailsAsyncTask(hospitalDao).execute(bookingSummary);
    }


    private static class InsertBookingDetailsAsyncTask extends AsyncTask<BookingSummary,Void,Void> {
        private HospitalDao hospitalDao;

        private InsertBookingDetailsAsyncTask(HospitalDao hospitalDao){

            this.hospitalDao = hospitalDao;
        }

        @Override
        protected Void doInBackground(BookingSummary... bookingSummary) {
            hospitalDao.insert_bookingdetails(bookingSummary[0]);
            return null;
        }


    }

    public void insert_intermediate(Intermediate intermediate){
        new InsertIntermediateAsyncTask(hospitalDao).execute(intermediate);
    }

    private static class InsertIntermediateAsyncTask extends AsyncTask<Intermediate,Void,Void> {
        private HospitalDao hospitalDao;

        private InsertIntermediateAsyncTask(HospitalDao hospitalDao){

            this.hospitalDao = hospitalDao;
        }

        @Override
        protected Void doInBackground(Intermediate... intermediates) {
            hospitalDao.insert_intermediate(intermediates[0]);
            return null;
        }


    }

    public LiveData<List<Integer>>getSlot_id(String slot){
        slot_id = hospitalDao.getslot_id(slot);
        return slot_id;
    }

    public  LiveData<List<BookingSummary>> getbookingdetails(){
        booking = hospitalDao.getbookingdetails();
        return booking;

    }

    public LiveData<List<BookingSummary>> getdocbookingdetails(String name){
        bookingdr = hospitalDao.getdocbookingdetails(name);
        return bookingdr;
    }

    public LiveData<List<BookingSummary>> getuserbookingdetails(String user){
        bookinguser = hospitalDao.getuserbookingdetails(user);
        return  bookinguser;
    }



}
