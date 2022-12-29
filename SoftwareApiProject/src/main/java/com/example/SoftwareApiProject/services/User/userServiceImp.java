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
//        User user = userRepo.subscribe(username);
        User user = getUser(username);
        if (user != null) {
            boolean flag = servicesimp.subscribeUser(serviceName, user);
            if (flag) {
                return username + " successfully subscribed to " + serviceName;
            }
            else
                return "subscription failed, please try again";
        }
        return "user not found";
    }

    @Override
    public void PayByWallet(Services service, User user) {
        userRepo.PayWallet(service , user);
    }

}
