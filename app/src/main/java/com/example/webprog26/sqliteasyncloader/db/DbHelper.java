package com.example.webprog26.sqliteasyncloader.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by webprog26 on 19.12.2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "async_users_db";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String TABLE_USERS = "com.example.webprog26.sqliteasyncloader.table_users";
    public static final String USER_ID = "_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_COUNTRY = "user_country";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_USERS + "("
                + USER_ID + " integer primary key autoincrement, "
                + USER_NAME + " varchar(100), "
                + USER_COUNTRY + " varchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //
    }
}
