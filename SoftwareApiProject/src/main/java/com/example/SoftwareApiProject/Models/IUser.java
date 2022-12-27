package com.example.SoftwareApiProject.Models;

public abstract class IUser {

    public String username;
    public String password;
    public String refundState;
    public String email;

    public IUser() {
    }

    public IUser(String username, String password, String refundState, String email) {
        this.username = username;
        this.password = password;
        this.refundState = refundState;
        this.email = email;
    }


}

