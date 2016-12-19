package com.example.webprog26.sqliteasyncloader.db;

import android.database.Cursor;

import com.example.webprog26.sqliteasyncloader.models.User;

/**
 * Created by webprog26 on 19.12.2016.
 */

public class CursorManager {

    public static User getUser(Cursor cursor){
        if(cursor == null){
            return null;
        }

        User.Builder userBuilder = User.newBuilder();
        userBuilder.setUserId(cursor.getLong(cursor.getColumnIndex(DbHelper.USER_ID)));
        userBuilder.setUserName(cursor.getString(cursor.getColumnIndex(DbHelper.USER_NAME)));
        userBuilder.setUserCountry(cursor.getString(cursor.getColumnIndex(DbHelper.USER_COUNTRY)));

        return userBuilder.build();
    }
}
