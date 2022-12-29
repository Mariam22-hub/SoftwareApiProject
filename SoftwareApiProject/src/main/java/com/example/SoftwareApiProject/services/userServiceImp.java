package com.example.SoftwareApiProject.services;


import com.example.SoftwareApiProject.Models.Provider;
import com.example.SoftwareApiProject.Models.Services;
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
    public String subscribe(String username, String serviceName, String serviceType) {
        User user = userRepo.subscribe(username);
        if (user != null){
            String servicename = servicesimp.subscribeUser(serviceName, user, serviceType);
            return "user subscribed successfully to " + servicename;
        }
        return "user not found";
    }

    @Override
    public void PayByWallet(Services service, User user) {
    userRepo.PayWallet(service , user);
    }

}
