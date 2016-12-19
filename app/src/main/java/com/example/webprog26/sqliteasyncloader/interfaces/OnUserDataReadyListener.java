package com.example.webprog26.sqliteasyncloader.interfaces;

import com.example.webprog26.sqliteasyncloader.models.User;

/**
 * Created by webprog26 on 19.12.2016.
 */

public interface OnUserDataReadyListener {

    public void onUserDataReady(User user);
}
