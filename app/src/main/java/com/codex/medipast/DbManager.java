package com.codex.medipast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbManager {

    private Context context;
    private  DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DbManager(Context context) {
        this.context = context;
        dbHelper =new DbHelper(context);
    }

    public boolean addToDoctor(Doctor doctor){
        sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.DOCTOR_NAME,doctor.getDoctorName());
        contentValues.put(DbHelper.DOCTOR_DETAILS,doctor.getDoctordetails());
        contentValues.put(DbHelper.DOCTOR_DATE,doctor.getAppointmentDate());
        contentValues.put(DbHelper.DOCTOR_PHONE,doctor.getDoctorPhone());
        contentValues.put(DbHelper.DOCTOR_EMAIL,doctor.getDoctorEmail());
        long insertedIntoDoctor = sqLiteDatabase.insert(DbHelper.DOCTOR_TABLE_NAME,null,contentValues);

        sqLiteDatabase.close();

        if (insertedIntoDoctor>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean addToHistory(MedicalHistory history){

        sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.HISTORY_IMAGE_DATA,history.getPrescriptionImageData());
        cv.put(DbHelper.HISTORY_DOCTOR_NAME,history.getVisitedDoctorName());
        cv.put(DbHelper.HISTORY_DOCTOR_DETAILS,history.getMedicalDetails());
        cv.put(DbHelper.HISTORY_DATE,history.getPrescriptionDate());

        long isInserted = sqLiteDatabase.insert(DbHelper.HISTORY_TABLE_NAME,null,cv);

        if (isInserted>0){
            return true;
        }else {
            return false;
        }

    }

    public ArrayList<Doctor> getAllDoctors(){
        ArrayList<Doctor> allDoctorsList = new ArrayList<>();
        sqLiteDatabase=dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DbHelper.DOCTOR_TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DbHelper.DOCTOR_ID));
                String name = cursor.getString(cursor.getColumnIndex(DbHelper.DOCTOR_NAME));
                String details = cursor.getString(cursor.getColumnIndex(DbHelper.DOCTOR_DETAILS));
                String date = cursor.getString(cursor.getColumnIndex(DbHelper.DOCTOR_DATE));
                String phone = cursor.getString(cursor.getColumnIndex(DbHelper.DOCTOR_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(DbHelper.DOCTOR_EMAIL));

                Doctor doctor = new Doctor(name,details,date,phone,email);
                allDoctorsList.add(doctor);
            }while (cursor.moveToNext());
        }
        return allDoctorsList;
    }

    public ArrayList<MedicalHistory> getAllhistories(){

        ArrayList<MedicalHistory> histories = new ArrayList<>();
        sqLiteDatabase=dbHelper.getReadableDatabase();
        String query = "SELECT * FROM "+DbHelper.HISTORY_TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                int id =cursor.getInt(cursor.getColumnIndex(DbHelper.HISTORY_ID));
                String image =cursor.getString(cursor.getColumnIndex(DbHelper.HISTORY_IMAGE_DATA));
                String name =cursor.getString(cursor.getColumnIndex(DbHelper.HISTORY_DOCTOR_NAME));
                String details =cursor.getString(cursor.getColumnIndex(DbHelper.HISTORY_DOCTOR_DETAILS));
                String date =cursor.getString(cursor.getColumnIndex(DbHelper.HISTORY_DATE));

                MedicalHistory history = new MedicalHistory(image,name,details,date);
                histories.add(history);
            }while (cursor.moveToNext());
        }
        return histories;

    }



}
