package com.example.renjf.firstapplication;

/**
 * Created by renjf on 9/22/2017.
 */

public class User {

    private String mUserName;
    private String mUscEmail;
    private String mPassword;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String password) {
        this.mUserName = username;
        this.mUscEmail = email;
        this.mPassword = password;
    }


    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getUscEmail() {
        return mUscEmail;
    }

    public void setUscEmail(String uscEmail) {
        mUscEmail = uscEmail;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "mUserName='" + mUserName + '\'' +
                ", mUscEmail='" + mUscEmail + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}
