package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Models.Admin.allTransactions;

@Service
public class userRepository {
    static public User loggedInUser;

    @Autowired
    public static ArrayList<User> usersArray = new ArrayList<User>();

    public String addUser(User incomingUser) {
        for (User users : usersArray) {
            if (users.getUsername().equals(incomingUser.getUsername()) || users.getEmail().equals(incomingUser.getEmail())) {
                return "user already added";
            }
        }
        usersArray.add(incomingUser);
        incomingUser.setSignedIn(true);
        loggedInUser = incomingUser;
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

    public String pay(Services service, User user , String PaymentMethod, double amount) {
//        Payment payMethod=null;
//
//        if(PaymentMethod.equals("Wallet")){
//        payMethod = new PayByWallet(user.getWallet());
//        }
//        if(PaymentMethod.equals("CreditCard"))
//        {
//        payMethod = new PayByCard(user.getCreditCard());
//        }
//        if(PaymentMethod.equals("Cash"))
//        {
//          payMethod = new PayByCash(user.getUsername());
//
//        }
//        service.setPayment(payMethod);
//        service.pay();

        if(PaymentMethod.equals("Wallet")){
            user.wallet.decrement(amount);
            //store transaction
            Transactions t = new Transactions(service);

            user.transactionPay.add(t);
            return "Payment by wallet is successful\nyour  amount is " + user.wallet.getAmount();
        }
        if (PaymentMethod.equals("CreditCard")) {
            user.getCreditCard().decrement(amount);
            Transactions t = new Transactions(service);
//            Transactions t2 = new Transactions(service, user);
//            allTransactions.add(t2);
            user.transactionPay.add(t);
            return "Payment by creditCard is successful\nyour amount is " + user.getCreditCard().getAmount();
        }
        if (PaymentMethod.equals("Cash")) {
            Transactions t = new Transactions(service);
//            Transactions t2 = new Transactions(service, user);
//            allTransactions.add(t2);
            user.transactionPay.add(t);
            return "Payment by Cash is successful\nyou Paid " + service.getPrice();
        }

        return "";
    }


    public String signIn(User regesteredUser) {
        for (User users : usersArray) {
            if (users.getUsername().equals(regesteredUser.getUsername()) && users.getEmail().equals(regesteredUser.getEmail())&&users.getPassword().equals(regesteredUser.getPassword())) {
                users.setSignedIn(true);
                loggedInUser = regesteredUser;
                return "you signed in successfully";
            }
        }
        return ("Invalid User Information");
    }
}
