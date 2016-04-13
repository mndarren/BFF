package com.example.harrison.bffofscsu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Darren on 4/11/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE "+ ProfessorInfo.NewProfessorInfo.TABLE_NAME+"("
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_ID+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_FIRST_NAME+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_LAST_NAME+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_JOB_TITLE+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_ICON+" BLOB,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_DEPARTMENT+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_PHONE+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_OFFICE+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_EMAIL+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_WEBSITE+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_DEGREE+" TEXT,"
            + ProfessorInfo.NewProfessorInfo.PROFESSOR_INTEREST+" TEXT);";
    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPOERATIONS","Database created / opened...");
    }

    public UserDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.e("DATABASE OPOERATIONS","Database created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Professor table created...");
    }

    public void addInformation(ContentValues contentValues, SQLiteDatabase db){

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
