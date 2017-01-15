package com.example.user1.rdphotoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user1 on 15.01.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private final static int SQL_DATABASE_VERSION = 1;

    private final static String SQL_DATABASE_NAME = "my_db";

    public final static String SQL_PHOTO_COLUMN = "path";

    public final static String SQL_PHOTOS_TABLE = "photos";

    private final static String SQL_CREATE_TABLE = "create table " + SQL_PHOTOS_TABLE + " ( " +
            "id integer primary key autoincrement," +
            SQL_PHOTO_COLUMN + " text);";

    public DBHelper(Context context) {
        super(context, SQL_DATABASE_NAME, null, SQL_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(MainActivity.TAG, "onCreate database");
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
