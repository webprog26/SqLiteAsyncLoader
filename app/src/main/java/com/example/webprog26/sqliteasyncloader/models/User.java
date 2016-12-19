package com.example.webprog26.sqliteasyncloader.models;

/**
 * Created by webprog26 on 19.12.2016.
 */

public class User {

    private long mUserId;
    private String mUserName;
    private String mUserCountry;

    public long getUserId() {
        return mUserId;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getUserCountry() {
        return mUserCountry;
    }

    public static Builder newBuilder(){
        return new User(). new Builder();
    }

    public class Builder{

        public Builder setUserId(long userId){
            User.this.mUserId = userId;
            return this;
        }

        public Builder setUserName(String userName){
            User.this.mUserName = userName;
            return this;
        }

        public Builder setUserCountry(String userCountry){
            User.this.mUserCountry = userCountry;
            return this;
        }

        public User build(){
            return User.this;
        }
    }
}
