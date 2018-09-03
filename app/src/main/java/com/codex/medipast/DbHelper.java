package com.codex.medipast;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="medipast.db";
    public static final int DB_VERSION=1;
    public static final String DOCTOR_TABLE_NAME="doctors_table";
    public static final String DOCTOR_ID="id";
    public static final String DOCTOR_NAME="name";
    public static final String DOCTOR_DETAILS="details";
    public static final String DOCTOR_DATE="appointment_date";
    public static final String DOCTOR_PHONE="phone";
    public static final String DOCTOR_EMAIL="Email";

    public static final String HISTORY_TABLE_NAME="history_table";
    public static final String HISTORY_ID="id";
    public static final String HISTORY_IMAGE_DATA="image";
    public static final String HISTORY_DOCTOR_NAME="name";
    public static final String HISTORY_DOCTOR_DETAILS="details";
    public static final String HISTORY_DATE="date";


    private static String createHistoryString = "CREATE TABLE "+ HISTORY_TABLE_NAME
            + "(" + HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ HISTORY_IMAGE_DATA +" TEXT,"
            + HISTORY_DOCTOR_NAME + " TEXT," + HISTORY_DOCTOR_DETAILS + " TEXT,"  + HISTORY_DATE + " TEXT" + ")";

    private static String createTabledoctorString = "CREATE TABLE "+ DOCTOR_TABLE_NAME
            + "(" + DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ DOCTOR_NAME +" TEXT," + DOCTOR_DETAILS + " TEXT,"
            + DOCTOR_DATE + " TEXT,"  + DOCTOR_PHONE + " TEXT,"  + DOCTOR_EMAIL + " TEXT"+")";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(createTabledoctorString);
            db.execSQL(createHistoryString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
