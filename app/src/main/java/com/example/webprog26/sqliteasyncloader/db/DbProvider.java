package com.example.webprog26.sqliteasyncloader.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.webprog26.sqliteasyncloader.db.DbHelper;
import com.example.webprog26.sqliteasyncloader.models.User;

import java.util.ArrayList;

/**
 * Created by webprog26 on 19.12.2016.
 */

public class DbProvider {

    private DbHelper mDbHelper;

    public DbProvider(Context context) {
        this.mDbHelper = new DbHelper(context);
    }

    public boolean insertUserToDB(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.USER_NAME, user.getUserName());
        contentValues.put(DbHelper.USER_COUNTRY, user.getUserCountry());

        return mDbHelper.getWritableDatabase().insert(DbHelper.TABLE_USERS, null, contentValues) != 0;
    }

    public ArrayList<User> getUsersFromDB(){

        ArrayList<User> userArrayList = new ArrayList<>();

        Cursor cursor = mDbHelper.getReadableDatabase().query(
                DbHelper.TABLE_USERS,
                null,
                null,
                null,
                null,
                null,
                DbHelper.USER_ID);
        while (cursor.moveToNext()){
            userArrayList.add(CursorManager.getUser(cursor));
        }
        cursor.close();
        return userArrayList;
    }

    public User getUserById(long userId){
        User user = new User();

        String selection = DbHelper.USER_ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(userId)};

        Cursor cursor = mDbHelper.getReadableDatabase().query(
                DbHelper.TABLE_USERS,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            user = CursorManager.getUser(cursor);
        }

        return user;
    }

    public boolean updateUser(User user){
        String whereClause = DbHelper.USER_ID + " = ?";
        String[] whereArgs = new String[]{String.valueOf(user.getUserId())};

        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.USER_NAME, user.getUserName());
        contentValues.put(DbHelper.USER_COUNTRY, user.getUserCountry());

        return mDbHelper.getWritableDatabase().update(DbHelper.TABLE_USERS, contentValues, whereClause, whereArgs) != 0;
    }

    public boolean deleteUserById(long userId){
        String whereClause = DbHelper.USER_ID + " = ?";
        String[] whereArgs = new String[]{String.valueOf(userId)};

        return mDbHelper.getWritableDatabase().delete(DbHelper.TABLE_USERS, whereClause, whereArgs) != 0;
    }
}
