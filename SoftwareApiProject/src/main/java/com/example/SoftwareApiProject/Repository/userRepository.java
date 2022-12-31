package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.Transactions;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Repository.adminRepository.transactionPays;

@Service
public class userRepository {
    static public User loggedInUser;

    @Autowired
    public static ArrayList<User> usersArray = new ArrayList<User>();

    public String addUser(User incomingUser) {
        for (User users : usersArray) {
            if (users.getUsername().toLowerCase().equals(incomingUser.getUsername().toLowerCase()) || users.getEmail().toLowerCase().equals(incomingUser.getEmail().toLowerCase())) {
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
            if (users.getUsername().toLowerCase().equals(name.toLowerCase())) {
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

    public String pay (Services service, User user , String PaymentMethod, double amount) {

        if(PaymentMethod.equals("Wallet")){
            user.wallet.decrement(amount);

            //store transaction
            Transactions t = new Transactions(service,user.getUsername(),amount);
            user.transactionPay.add(t);
            transactionPays.add(t);

            return "Payment by wallet is successful\nyour  amount is " + user.wallet.getAmount();
        }
        if (PaymentMethod.equals("CreditCard")) {
            user.getCreditCard().decrement(amount);
            Transactions t = new Transactions(service,user.getUsername(),amount);
            user.transactionPay.add(t);
            transactionPays.add(t);

            return "Payment by creditCard is successful\nyour amount is " + user.getCreditCard().getAmount();
        }
        if (PaymentMethod.equals("Cash")) {
            Transactions t = new Transactions(service,user.getUsername(),amount);
            user.transactionPay.add(t);
            transactionPays.add(t);

            return "Payment by Cash is successful\nyou Paid " + service.getPrice();
        }

        return "";
    }


    public String signIn(String username, String password, String email) {

        for (User users : usersArray) {

            if (users.getUsername().toLowerCase().equals(username.toLowerCase()) && users.getEmail().toLowerCase().equals(email.toLowerCase())&&users.getPassword().toLowerCase().equals(password.toLowerCase())) {
                users.setSignedIn(true);
                loggedInUser = users;
                return "You have signed";
            }
        }
        return ("Invalid User Information");
    }

    public String logOut(String name) {
        User user = getUser(name);
        user.setSignedIn(false);
        return "You have logged out\nPlease login to use our services";
    }
}
