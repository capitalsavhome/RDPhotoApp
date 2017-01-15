package com.example.user1.rdphotoapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user1 on 15.01.2017.
 */

public class DataBaseWorker {

    private DBHelper mDbHelper;

    public static boolean writeToDb(DBHelper DbHelper, String data) {
        SQLiteDatabase database = DbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.SQL_PHOTO_COLUMN, data);

        long rowID = database.insert(DBHelper.SQL_PHOTOS_TABLE, null, contentValues);

        if (rowID != -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void readFromDb(DBHelper dbHelper) {
        
    }
}
