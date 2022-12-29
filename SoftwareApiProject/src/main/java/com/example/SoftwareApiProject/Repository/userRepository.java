package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.PayByWallet;
import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class userRepository {

    @Autowired
    public static ArrayList<User> usersArray = new ArrayList<User>();
    public String addUser(User incomingUser) {
        for (User users : usersArray){
            if (users.getUsername().equals(incomingUser.getUsername())) {
                return "user already added";
            }
        }
        usersArray.add(incomingUser);
        return "user added successfully";
    }

    public User getUser(String name) {
        for (User users : usersArray){
            if (users.getUsername().equals(name)){
                return users;
            }
        }
        return null;
    }

//    public User subscribe(String username) {
//        for (User user : usersArray) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
//        return null;
//    }
    public void PayWallet(Services service, User user)
    {
        Payment payMethod= (Payment) new PayByWallet(user.getWallet());
        service.setPayment(payMethod);
        service.pay();
        user.wallet.decriment(service.getPrice());
    }


}
