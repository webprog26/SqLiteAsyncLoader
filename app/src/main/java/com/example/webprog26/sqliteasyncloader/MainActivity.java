package com.example.webprog26.sqliteasyncloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.webprog26.sqliteasyncloader.interfaces.OnUserDataReadyListener;
import com.example.webprog26.sqliteasyncloader.interfaces.ShouldUpdateUsersListCallback;
import com.example.webprog26.sqliteasyncloader.models.User;

public class MainActivity extends AppCompatActivity implements OnUserDataReadyListener, ShouldUpdateUsersListCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onUserDataReady(User user) {
        //
    }

    @Override
    public void shouldUpdateUsersList() {
        //
    }
}
