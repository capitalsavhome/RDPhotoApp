package com.example.user1.rdphotoapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user1 on 15.01.2017.
 */

public class DataBaseWorker {

    private final Context mContext;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDataBase;

    public DataBaseWorker(Context context) {
        mContext = context;
    }

    /**
     * open connection to DataBase
     */
    public void open() {
        mDBHelper = new DBHelper(mContext, DBHelper.SQL_DATABASE_NAME,
                null, DBHelper.SQL_DATABASE_VERSION);
        mDataBase = mDBHelper.getWritableDatabase();
    }

    /**
     * close connection to DataBase
     */
    public void close() {
        if (mDBHelper!=null) mDBHelper.close();
    }

    /**
     * get all data from the DataBase
     * @return Cursor
     */
    public Cursor getAllData() {
        return mDataBase.query(DBHelper.SQL_PHOTOS_TABLE, null, null, null, null, null, null);
    }

    /**
     * add record to DataBase Table
     * @param data
     */
    public void writeFromDataBase(String data) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.SQL_PHOTO_COLUMN, data);
        mDataBase.insert(DBHelper.SQL_PHOTOS_TABLE, null, contentValues);

    }

    /**
     * remove record from DataBase Table
     * @param id long with photo row id
     */
    public void removeFromDataBase(long id) {
        mDataBase.delete(DBHelper.SQL_PHOTOS_TABLE, DBHelper.SQL_PHOTOS_ID + " = " + id, null);
    }
}


class DBHelper extends SQLiteOpenHelper {

    public final static int SQL_DATABASE_VERSION = 1;

    public final static String SQL_DATABASE_NAME = "my_db";

    public final static String SQL_PHOTO_COLUMN = "path";

    public final static String SQL_PHOTOS_TABLE = "photos";

    public final static String SQL_PHOTOS_ID = "_id";

    private final static String SQL_CREATE_TABLE = "create table " + SQL_PHOTOS_TABLE + " ( " +
            SQL_PHOTOS_ID +" integer primary key autoincrement," +
            SQL_PHOTO_COLUMN + " text);";

    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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