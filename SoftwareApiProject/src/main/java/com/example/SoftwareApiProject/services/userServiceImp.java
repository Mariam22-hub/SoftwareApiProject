package com.example.SoftwareApiProject.services;


import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class userServiceImp implements userService {
    @Autowired
    userRepository userRepo;

    @Override
    public String addUser(User incomingUser) {
        return userRepo.addUser(incomingUser);
    }

    @Override
    public User getUser(String name) {
        return userRepo.getUser(name);
    }
}
