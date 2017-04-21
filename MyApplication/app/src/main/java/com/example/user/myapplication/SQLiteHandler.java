package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Aldrich Cheong on 1/20/2017.
 */

public class SQLiteHandler extends SQLiteOpenHelper{

    //Used to identify the class in console log for easier debugging
    private static final String TAG = SQLiteHandler.class.getSimpleName();

    //Configuration variables
    //Database version number
    private static final int DATABASE_VERSION = 1;

    //Name of database
    private static final String DATABASE_NAME = "student_db";

    //Name of table
    private static final String STUDENT_TABLE = "student";

    //Column names
    private static final String STUDENT_NAME = "stu_name";
    private static final String STUDENT_PHONE = "stu_phone";
    private static final String STUDENT_EMAIL = "stu_email";

    //Constructor
    public SQLiteHandler(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Triggered when application is installed
    @Override
    public void onCreate(SQLiteDatabase db){
        createStuTable(db);
    }

    //Triggered when database is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        dropStuTable(db);
        createStuTable(db);
    }

    //Create student table using SQL syntax
    public void createStuTable(SQLiteDatabase db){

        String CREATE_STUDENT_TABLE = "WRITE A SQL STATEMENT HERE";
        db.execSQL(CREATE_STUDENT_TABLE);

        Log.d(TAG, "Student Table is created");
    }

    //Drop student table using SQL syntax
    public void dropStuTable(SQLiteDatabase db){
        String DROP_STUDENT_TABLE = "DROP TABLE IF EXISTS " + STUDENT_TABLE;
        db.execSQL(DROP_STUDENT_TABLE);

        Log.d(TAG, "Student Table is dropped");
    }

    //method to add new student details into the student table
    public void addStudent(String name, String phone, String email){
        
    }

    //method that returns student information given the student name in a String Key value pair
    public HashMap<String,String> getStudent(String name){
        
    }

    //method that return a String array of all the student names in student table
    public String[] getStudentNameList(){
        
    }
}
