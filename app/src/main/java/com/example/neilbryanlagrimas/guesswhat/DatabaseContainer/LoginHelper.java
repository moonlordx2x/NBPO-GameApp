package com.example.neilbryanlagrimas.guesswhat.DatabaseContainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Neil Bryan Lagrimas on 20/01/2019.
 */

public class LoginHelper extends SQLiteOpenHelper {

    //DATABASE COMPONENT

    public static final String Login_Database = "Login_Database";
    public static final String Login_Table = "Login_Table";

    //TABLE COMPONENT
    public static final String Login_name = "user";
    public static final String Login_pass = "password";

    public LoginHelper(Context context) {
        super(context, Login_Database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DATABASE = "CREATE TABLE "+Login_Table + " ("+Login_name+" TEXT PRIMARY KEY,"+Login_pass+" TEXT);";
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DELETE_DATABASE = "DROP TABLE IF EXISTS "+Login_Table;
        db.execSQL(DELETE_DATABASE);
    }

    public boolean insertUser(String user,String Pass){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Login_name,user);
        contentValues.put(Login_pass,Pass);
        long insert = sqLiteDatabase.insert(Login_Table, null, contentValues);

        if (insert == -1){
            return false;
        }
        else{
            return true;
        }

    }
}
