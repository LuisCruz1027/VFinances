package com.example.vfinancesproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperTransactions extends SQLiteOpenHelper {

    private static DBHelperTransactions dbHelperTransactions;
    private static final String DATABASE_NAME = "Transactions.db";
    private static final String TABLE_NAME = "Record";
    private static final String COUNTER = "Counter";
    private static final String ID_FIELD = "ID";
    private static final String TAG_FIELD = "Tag";
    private static final String CATEGORY_FIELD = "Category";
    private static final String PRICE_FIELD = "Price";

    public DBHelperTransactions(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    public static DBHelperTransactions instanceOfDatabase(Context context)
    {
        if(dbHelperTransactions == null)
            dbHelperTransactions = new DBHelperTransactions(context);

        return dbHelperTransactions;


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sql;
        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLE_NAME)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ID_FIELD)
                .append(" INT, ")
                .append(TAG_FIELD)
                .append(" TEXT, ")
                .append(PRICE_FIELD)
                .append(" INT, ")
                .append(CATEGORY_FIELD)
                .append(" TEXT)");

         sqLiteDatabase.execSQL(sql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Record");

    }

    public void populateNoteListArray()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        try(Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null))
        {
            if(result.getCount() != 0)
            {
                while(result.moveToNext())
                {
                    int id1=result.getInt(1);
                    String tag1= result.getString(2);
                    int price1= result.getInt(3);
                    String category1 = result.getString(4);
                    Note note = new Note(id1,tag1,price1,category1);
                    Note.noteArrayList.add(note);

                }
            }
        }
    }


   public void updateNoteInDB(Note note)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD,note.getId());
        contentValues.put(TAG_FIELD, note.getTag());
        contentValues.put(PRICE_FIELD, note.getPrice());
        contentValues.put(CATEGORY_FIELD, note.getCategory());
        sqLiteDatabase.update(TABLE_NAME, contentValues,ID_FIELD + " =? ",new String[]{String.valueOf(note.getId())});

    }

    public Boolean insertData(Note u) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, u.getId());
        contentValues.put(TAG_FIELD, u.getTag());
        contentValues.put(PRICE_FIELD,u.getPrice());
        contentValues.put(CATEGORY_FIELD,u.getCategory());
        long result = myDB.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
