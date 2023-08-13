package com.example.vfinancesproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "Account.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "'users'";
    private static final String COLUMN_EMAIL = "'email'";
    private static final String COLUMN_ID = "'id'";
    private static final String COLUMN_PASSWORD = "'password'";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EMAIL + " TEXT NOT NULL, " + COLUMN_PASSWORD + " TEXT NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users");

    }

    public Boolean insertData(User u) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, u.getUser_email());
        contentValues.put(COLUMN_PASSWORD, u.getUser_password());
        long result = myDB.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
        public Boolean checkEmail(String eemail){
            SQLiteDatabase myDB = this.getReadableDatabase();
            Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE email = ?", new String[] {eemail});
            if(cursor.getCount() > 0){
                return true;
            }
            else{
                return false;
            }
        }

    public User checkLogin(String eemail, String password){
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE email = ?", new String[] {eemail});
        if(cursor.moveToFirst()){
            String em = cursor.getString(0);
            String pass =  cursor.getString(1);
            if(em.equals(eemail) && pass.equals(password)) {
                cursor.close();
                myDB.close();
                return new User(em, pass);
            }
        }
        cursor.close();
        myDB.close();
        return null;
    }
        public Cursor viewData()
        {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(query,null);

            return cursor;
        }


    }

