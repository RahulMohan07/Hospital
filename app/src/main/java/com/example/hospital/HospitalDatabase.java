package com.example.hospital;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class,Doctor.class,Day.class,Slot.class,Intermediate.class,BookingSummary.class}, version=1)
public abstract class HospitalDatabase extends RoomDatabase {
    private static final String DB_NAME = "hospital";
    private static HospitalDatabase instance;

    public static synchronized HospitalDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), HospitalDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    public abstract HospitalDao hospitalDao();

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new HospitalDatabase.PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private HospitalDao hospitalDao;

        public PopulateDBAsyncTask(HospitalDatabase db) {
            hospitalDao = db.hospitalDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            hospitalDao.insert_doc(new Doctor("sunnyvarghese@gmail.com","Sunny","Varghese","Male","sunny123","sunny123","Pediatrician",42));
            hospitalDao.insert_doc(new Doctor("rakeshkumar@gmail.com","Rakesh","Kumar","Male","rakesh123","rakesh123","Cardiologist",50));

            hospitalDao.insert_day(new Day("Monday"));
            hospitalDao.insert_day(new Day("Tuesday"));
            hospitalDao.insert_day(new Day("Wednesday"));
            hospitalDao.insert_day(new Day("Thursday"));
            hospitalDao.insert_day(new Day("Friday"));
            hospitalDao.insert_day(new Day("Saturday"));
            hospitalDao.insert_day(new Day("Sunday"));

            hospitalDao.insert_slot(new Slot(1,"10:00 - 11:00"));
            hospitalDao.insert_slot(new Slot(2,"11:00 - 12:00"));
            hospitalDao.insert_slot(new Slot(3,"12:00 - 13:00"));
            hospitalDao.insert_slot(new Slot(4,"13:00 - 14:00"));
            hospitalDao.insert_slot(new Slot(5,"15:00 - 16:00"));
            hospitalDao.insert_slot(new Slot(6,"16:00 - 17:00"));
            hospitalDao.insert_slot(new Slot(7,"17:00 - 18:00"));
            hospitalDao.insert_slot(new Slot(8,"18:00 - 19:00"));
            hospitalDao.insert_slot(new Slot(9,"19:00 - 20:00"));






            return null;
        }
    }
}
