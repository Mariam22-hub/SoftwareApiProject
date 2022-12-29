package com.example.SoftwareApiProject.services.User;


import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Repository.userRepository;
import com.example.SoftwareApiProject.services.serviceProviders.servicesProvidersImp;
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
        if (user != null) {
            boolean flag = servicesimp.subscribeUser(serviceName, user);
            if (flag) {
                return "user subscribed successfully to " + serviceName;
            }
            else
                return "subscription failed, please try again";
        }
        return "user not found";
    }


    public String PayByWallet(String username, String serviceName) {
        User user = userRepo.getUser(username);
        Services service = servicesimp.findSer(serviceName);
        return userRepo.PayWallet(service , user);
    }

    @Override
    public String signIn(User regesteredUser) {
        return userRepo.signIn(regesteredUser);
    }

}
