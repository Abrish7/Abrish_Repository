package com.abraham.sqlite_user_managmenet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;            //DATABASE VERSION
    private static final String DATABASE_NAME="users1.db";  //DATABASE NAME
    private static final String TABLE_USERS="users";        //TABLE NAME
    // COLUMNS TO BE CREATED
    private static final String COLUMN_ID = "id";               //---------------------
    private static final String COLUMN_FNAME = "firstname";
    private static final String COLUMN_LNAME = "lastname";
    private static final String COLUMN_SEX = "sex";             // COLUMNS
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME="username";
    private static final String COLUMN_PHONE = "Address";
    private static final String COLUMN_PASS = "password";       //----------------------

    public SQLiteDBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  // DATABASE CREATED HERE
        Log.d("Database Operation", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_USERS + "("
                +COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_FNAME+ " TEXT,"
                +COLUMN_LNAME+ " TEXT,"                                 // COLUMNS CREATED IN HERE
                +COLUMN_UNAME+ " TEXT,"
                +COLUMN_SEX+ " TEXT, "
                +COLUMN_EMAIL+ " TEXT,"
                +COLUMN_PHONE+ " TEXT,"
                +COLUMN_PASS+ " TEXT"
                +");";
        db.execSQL(query);  // QUERY EXECUTION
        Log.d("Database Operation", "Table "+TABLE_USERS+" created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);                     // HERE TO PERFORM CRUD OPERATION
        onCreate(db);
    }


    public void addUser(String fname,String lname,String uname,String email,String phone,String pass,String sex){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FNAME, fname);
        values.put(COLUMN_LNAME, lname);
        values.put(COLUMN_UNAME, uname);                // SET DATA INTO THE DATABASE
        values.put(COLUMN_SEX, sex);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_PASS, pass);

        long id = db.insert(TABLE_USERS,null,values);
        db.close();
        Log.d("Database Operation ", "One Row inserted.." + id);
    }

    public boolean getUser(String uname,String pass){
        String selectQuery = "SELECT * FROM "+ TABLE_USERS + " WHERE "
                +COLUMN_UNAME+ " = " + "'"+uname+"'" + " and "          // GET USER NAME AND PASSWORD FROM DATABASE
                +COLUMN_PASS+ " = " + "'"+pass+"'" ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public ArrayList<Users> getAllUsers(){
        ArrayList<Users> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_USERS ;         // GET ALL DATA FROM THE DATABASE

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.getCount()>0){
          //  cursor.moveToFirst();
            while(cursor.moveToNext()){
                Users u=new Users();
                u.setFname(cursor.getString(1));
                u.setLname(cursor.getString(2));
                u.setUname(cursor.getString(3));
                u.setGender(cursor.getString(4));
                u.setEmail(cursor.getString(5));
                u.setPhone(cursor.getString(6));
                users.add(u);
            }
            cursor.close();

        }
        return users;
    }


    public void removeUser(int id){                                                             // REMOVE SINGLE USER FROM THE DATABASE
        String selectQuery = "DELETE FROM "+ TABLE_USERS+" WHERE "+COLUMN_ID+" = "+id ;
        SQLiteDatabase db = this.getWritableDatabase();
        //db.delete(TABLE_USERS, COLUMN_ID +" = "+ id, null);
        db.execSQL(selectQuery);
    }
}
