package com.example.SoftwareApiProject.services;


import com.example.SoftwareApiProject.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class userServiceImp implements userService {

    @Autowired
    public static ArrayList<User> usersArray = new ArrayList<User>();
    @Override
    public String addUser(User incomingUser) {
        for (User users : usersArray){
            if (users.username.equals(incomingUser.username)) {
                return "user already added";
            }
        }
        usersArray.add(incomingUser);
        return "user added successfully";
    }
}
