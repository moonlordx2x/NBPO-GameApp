package com.example.neilbryanlagrimas.guesswhat.DatabaseContainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.neilbryanlagrimas.guesswhat.MainActivity;

/**
 * Created by Neil Bryan Lagrimas on 02/01/2019.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // DATABASE COMPONENT

    public static final String Database_Name = "Score_DB";
    public static final String Table_Name = "ScoreData";

    //TABLE COMPONENT

    public static final String Score = "Score";
    public static final String First_Name = "User_Name";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_table = "CREATE TABLE "+Table_Name+" ("+Score+" INTEGER,"+First_Name+" TEXT);";
        //db.execSQL("CREATE TABLE "+Table_Name+"(Score INTEGER,User_Name TEXT)");
        db.execSQL(Create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS "+Table_Name;
        //db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean insertdata(int score,String Username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Score,score);
        contentValues.put(First_Name,Username);
        long insert = sqLiteDatabase.insert(Table_Name, null, contentValues);
        if (insert == -1)
            return false;
        else
            return true;
    }

    public Cursor viewdata(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + Table_Name,null);
        return cursor;
    }

}
