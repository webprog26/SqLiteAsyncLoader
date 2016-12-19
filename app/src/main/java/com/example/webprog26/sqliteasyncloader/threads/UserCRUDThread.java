package com.example.webprog26.sqliteasyncloader.threads;

import android.os.Handler;

import com.example.webprog26.sqliteasyncloader.db.DbProvider;
import com.example.webprog26.sqliteasyncloader.interfaces.OnUserDataReadyListener;
import com.example.webprog26.sqliteasyncloader.models.User;

/**
 * Created by webprog26 on 19.12.2016.
 */

public class UserCRUDThread extends Thread {

    private Handler mUiHandler;
    private User mUser;
    private long mUserId;
    private DbProvider mDbProvider;
    private OnUserDataReadyListener mOnUserDataReadyListener;
    private int mAction;

    public static final int CREATE_USER = 2;
    public static final int UPDATE_USER = 3;
    public static final int DELETE_USER = 4;
    public static final int GET_USER = 5;

    public static final int SHOULD_UPDATE_UI = 1;

    public UserCRUDThread(DbProvider dbProvider, Handler mUiHandler, User user, int action) {
        this.mUiHandler = mUiHandler;
        this.mDbProvider = dbProvider;
        this.mUser = user;
        this.mAction = action;
    }

    public UserCRUDThread(DbProvider mDbProvider, Handler mUiHandler, long mUserId, OnUserDataReadyListener onUserDataReadyListener, int action) {
        this.mUiHandler = mUiHandler;
        this.mDbProvider = mDbProvider;
        this.mUserId = mUserId;
        this.mOnUserDataReadyListener = onUserDataReadyListener;
        this.mAction = action;
    }

    private void createUser(){
        if(mDbProvider.insertUserToDB(mUser)){
            sendMessageToHandler();
        }
    }

    private void updateUser(){
        if(mDbProvider.updateUser(mUser)){
            sendMessageToHandler();
        }
    }

    private void deleteUser(){
        if(mDbProvider.deleteUserById(mUserId)){
            sendMessageToHandler();
        }
    }

    private void getUser(){
        mOnUserDataReadyListener.onUserDataReady(mDbProvider.getUserById(mUserId));
    }

    @Override
    public void run() {
        super.run();
        switch (mAction){
            case CREATE_USER:
                if(!isUserNotNull()){
                    return;
                }
                createUser();
                break;
            case UPDATE_USER:
                if(!isUserNotNull()){
                    return;
                }
                updateUser();
                break;
            case DELETE_USER:
                if(!isUserIdExists()){
                    return;
                }
                deleteUser();
                break;
            case GET_USER:
                if(!isUserIdExists()){
                    return;
                }
                getUser();
                break;
        }
    }

    private boolean isUserNotNull(){
        return mUser != null;
    }

    private boolean isUserIdExists(){
        return mUserId > 0;
    }

    private void sendMessageToHandler(){
        mUiHandler.obtainMessage(SHOULD_UPDATE_UI).sendToTarget();
    }
}
