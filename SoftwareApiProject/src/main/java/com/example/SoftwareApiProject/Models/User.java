package com.example.SoftwareApiProject.Models;


import jakarta.persistence.*;

import java.util.ArrayList;

//@Entity
//@Table(name = "Users")
public class User extends IUser{


//    public static ArrayList<Double> transactions = new ArrayList<Double>();

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long userID;
    public User() {
    }

    public User(String username, String password, String refundState, String email) {
        super(username, password, refundState, email);
    }



}

