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
        for (User users : usersArray) {
            if (users.getUsername().equals(incomingUser.getUsername()) || users.getEmail().equals(incomingUser.getEmail())) {
                users.setSignedIn(true);
                return "user already added";
            }
        }
        usersArray.add(incomingUser);
        return "user added successfully";
    }

    public User getUser(String name) {
        for (User users : usersArray) {
            if (users.getUsername().equals(name)) {
                return users;
            }
        }
        return null;
    }

    public User subscribe(String username) {
        for (User user : usersArray) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String pay(Services service, User user ,String PaymentMethod) {
        Payment payMethod=null;
        if(PaymentMethod.equals("Wallet")){
        payMethod = (Payment) new PayByWallet(user.getWallet());
        }
        if(PaymentMethod.equals("CreditCard"))
        {
        payMethod = (Payment) new PayByCard(user.getCreditCard());
        }
        if(PaymentMethod.equals("Cash"))
        {
          payMethod = (Payment) new PayByCash(user.getUsername());

        }
        service.setPayment(payMethod);
        service.pay();

        if(PaymentMethod.equals("Wallet")){
            user.wallet.decrement(service.getPrice());
            return "Payment by wallet is done your  amount is " + user.wallet.getAmount();
        }
        if(PaymentMethod.equals("CreditCard"))
        {
            user.creditCard.decrement(service.getPrice());
            return "Payment by creditCard is done your amount is " + user.creditCard.getAmount();
        }
        if(PaymentMethod.equals("Cash"))
        {
            return "Payment by Cash is done you Paid " + service.getPrice();
        }

        return "";
    }


    public String signIn(User regesteredUser) {
        return null;
    }
}
