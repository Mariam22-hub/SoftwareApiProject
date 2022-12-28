package com.example.SoftwareApiProject.services;


import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImp implements userService {
    @Autowired
    userRepository userRepo;
    @Autowired
    servicesProvidersImp servicesimp;

    @Override
    public String addUser(User incomingUser) {
        return userRepo.addUser(incomingUser);
    }

    @Override
    public User getUser(String name) {
        return userRepo.getUser(name);
    }

    @Override
    public String subscribe(String username, String serviceName) {
        User user = userRepo.subscribe(username);
        if (user != null){
            servicesimp.subscribeUser(serviceName, user);
            return "user subscribed successfully to ";
        }
        return "user not found";
    }
}
