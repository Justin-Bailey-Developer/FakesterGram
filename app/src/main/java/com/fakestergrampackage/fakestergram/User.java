package com.fakestergrampackage.fakestergram;

public class User {

    private String userHandle, email;

    public User(String userHandle, String email) {
        this.userHandle = userHandle;
        this.email = email;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
